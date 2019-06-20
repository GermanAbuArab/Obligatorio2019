import entidades.*;
import tads.hash.ElementoYaExistenteException;
import tads.hash.Hash;

import java.io.*;
import java.util.ArrayList;

class CargaDeDatos {
    private static BufferedReader br;
    private static BufferedReader br2;

    static void carga() {

        System.out.println("Cargando Datos...");

        long tiempoInicial=System.currentTimeMillis();
        try {
            br2 = new BufferedReader(new FileReader("noc_regions.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Hash<NationalOlympicCommittee, String> nocs = new Hash<>(330);
        String line2 = null;
        int primeraLinea2 = 1;
        while (true) {
            try {
                if ((line2 = br2.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert line2 != null;
            String[] values = line2.split(",");
            if (values.length != 15) values = line2.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (primeraLinea2 == 1) {
                primeraLinea2 = 0;
            } else {
                String noc1 = (values[0]);
                String region = (values[1]);
                NationalOlympicCommittee pais = new NationalOlympicCommittee(noc1, region);
                try {
                    nocs.insertar(noc1, pais);
                } catch (ElementoYaExistenteException e) {
                    System.out.println("Si esto aparece , arde roma");// nunca va a pasar porque no se repiten los noc
                }
            }
        }
        NationalOlympicCommittee noManLand = new NationalOlympicCommittee("NA", "Sin Region");
        try {
            nocs.insertar("NA", noManLand);
        } catch (ElementoYaExistenteException e) {
            e.printStackTrace();
        }
        Repositorio.setHashNOC(nocs);


        try {
            br = new BufferedReader(new FileReader("athlete_events.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        int primeraLinea = 1;
        Hash<Athlete, Integer> hashAtleta = new Hash<>(75000);
        ArrayList<AthleteOlympicParticipation> listaParticip = new ArrayList<>(1000000);
        Hash<OlympicGame, String> hashGames = new Hash<>(120);
        Hash<Event, String> hashEventos = new Hash<>(120);
        while (true) {

            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert line != null;
            String[] values = line.split(",");
            if (values.length != 15) values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (primeraLinea == 1) {
                primeraLinea = 0;
            } else {
                long id;
                if (values[0].length() == 1) {
                    id = Long.valueOf("" + values[0].charAt(0));
                } else {
                    id = Long.valueOf(values[0].substring(1, values[0].length() - 1));
                }
                String name = values[1].substring(1, values[1].length() - 1);
                SexType sex = null;

                if (values[2].substring(1, values[2].length() - 1).equals("M")) {
                    sex = SexType.MALE;
                } else if (values[2].substring(1, values[2].length() - 1).equals("F")) {
                    sex = SexType.FEMALE;
                }

                float heigth;
                if (values[4].equals("NA")) {
                    heigth = 0;
                } else {
                    heigth = Float.valueOf(values[4]);
                }
                float weigth;
                if (values[5].equals("NA")) {
                    weigth = 0;
                } else {
                    weigth = Float.valueOf(values[5]);
                }

                Team team = new Team(values[6].substring(1, values[6].length() - 1));
                String Noc = values[7].substring(1, values[7].length() - 1);
                String game = values[8].substring(1, values[8].length() - 1);


                int year = Integer.valueOf(values[9]);
                SeasonType season = null;
                if (values[10].substring(1, values[10].length() - 1).equals("Summer")) {
                    season = SeasonType.SUMMER;
                } else if (values[10].substring(1, values[10].length() - 1).equals("Winter")) {
                    season = SeasonType.WINTER;
                }
                City city = new City(values[11].substring(1, values[11].length() - 1));
                Sport sport = new Sport(values[12].substring(1, values[12].length() - 1));
                String event = values[13].substring(1, values[13].length() - 1);
                MedalType medal = null;
                switch (values[14].substring(1, values[14].length() - 1)) {
                    case "NA":
                        medal = null;
                        break;
                    case "Bronze":
                        medal = MedalType.BRONZE;
                        break;
                    case "Silver":
                        medal = MedalType.SILVER;
                        break;
                    case "Gold":
                        medal = MedalType.GOLD;
                        break;
                }


                NationalOlympicCommittee temp = Repositorio.getHashNOC().getValor(Noc);
                if (temp == null) {
                    temp = Repositorio.getHashNOC().getValor("NA");
                }
                Athlete atleta;

                if (hashAtleta.pertenece((int) id)) {
                    atleta = hashAtleta.getValor((int) id);
                } else {
                    atleta = new Athlete(id, name, sex, heigth, weigth, team, temp);
                    try {
                        hashAtleta.insertar((int) id, atleta);
                    } catch (ElementoYaExistenteException e) {
                        e.printStackTrace();
                    }

                }
                Event evento;
                if (hashEventos.pertenece(event)) {
                    evento = hashEventos.getValor(event);
                } else {
                    evento = new Event(event, sport);
                    try {
                        hashEventos.insertar(event, evento);
                    } catch (ElementoYaExistenteException e) {
                        e.printStackTrace();
                    }

                }

                new Event(event, sport);
                OlympicGame juegoOlimpico;

                if (hashGames.pertenece(game)) {
                    juegoOlimpico = hashGames.getValor(game);
                } else {
                    juegoOlimpico = new OlympicGame(game, year, season, city);
                    try {
                        hashGames.insertar(game, juegoOlimpico);
                    } catch (ElementoYaExistenteException e) {
                        e.printStackTrace();
                    }

                }
                juegoOlimpico.addEvento(evento);

                AthleteOlympicParticipation participation = new AthleteOlympicParticipation(atleta, evento, juegoOlimpico);

                if (medal != null) {
                    participation.setMedal(medal);
                    atleta.cambiarAnio(year, medal);
                    if (medal.equals(MedalType.BRONZE)) {
                        atleta.sumarMedallaBronce();
                    } else if (medal.equals(MedalType.SILVER)) {
                        atleta.sumarMedallaPlata();
                    } else if (medal.equals(MedalType.GOLD)) {
                        atleta.sumarMedallaOro();
                    }
                }
                listaParticip.add(participation);

            }

        }
        long tiempoFinal=System.currentTimeMillis();
        Repositorio.setHashEventos(hashEventos);
        Repositorio.setHashAtleta(hashAtleta);
        Repositorio.setHashGames(hashGames);
        Repositorio.setListaParticip(listaParticip);
        System.out.println("Datos Cargados");
        float tiempo = tiempoFinal-tiempoInicial;
        System.out.println(((tiempo)/1000)+ " segundos en cargar");
    }
}
