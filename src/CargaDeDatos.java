import entidades.*;
import tads.hash.ElementoYaExistenteException;
import tads.hash.Hash;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CargaDeDatos {
    private static BufferedReader br;
    private static BufferedReader br2;

    static void carga() {
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
            String[] values = line.split(",");
            if (primeraLinea == 1) {
                primeraLinea = 0;
            } else {
                long id;
                if (values[0].length() == 1) {
                    id = Long.valueOf("" + values[0].charAt(0));
                } else {
                    id = Long.valueOf(values[0].substring(0, (int) (values[0].length())));
                }
                String name = values[1].substring(0, ((int) (values[1].length())));
                SexType sex = null;
                if (("" + values[2].charAt(0)).equals("M")) {
                    sex = SexType.MALE;
                } else if (("" + values[2].charAt(0)).equals("F")) {
                    sex = SexType.FEMALE;
                }
//                int age;
//                if (values[3].equals("NA")) {
//                    age = 0;
//                } else {
//                    age = Integer.valueOf(values[3]);
//                }
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

                Team team = new Team(values[6].substring(0, ((int) (values[6].length()))));
                String Noc = values[7].substring(0, ((int) (values[7].length())));
                String game = values[8].substring(0, ((int) (values[8].length())));


                int year = Integer.valueOf(values[9]);
                SeasonType season = null;
                if (values[10].substring(0, ((int) (values[10].length()))).equals("Summer")) {
                    season = SeasonType.SUMMER;
                } else if (values[10].substring(0, ((int) (values[10].length()))).equals("Winter")) {
                    season = SeasonType.WINTER;
                }
                City city = new City(values[11].substring(0, ((int) (values[11].length()))));
                Sport sport = new Sport(values[12].substring(0, ((int) (values[12].length()))));
                String event = values[13].substring(0, ((int) (values[13].length())));
                MedalType medal = null;
                switch (values[14].substring(0, ((int) (values[14].length())))) {
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
                Athlete atleta ;

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
                Event evento ;
                if (hashEventos.pertenece(event)) {
                    evento= hashEventos.getValor(event);
                } else {
                    evento= new Event(event,sport);
                    try {
                        hashEventos.insertar(event,evento);
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
                    atleta.cambiarAnio(year,medal);
                    if (medal.equals(MedalType.BRONZE)) {

                        atleta.sumarMedallaBronce();
                        temp.sumarMedallaBronce();

                    } else if (medal.equals(MedalType.SILVER)) {
                        atleta.sumarMedallaPlata();
                        temp.sumarMedallaPlata();

                    } else if (medal.equals(MedalType.GOLD)) {
                        atleta.sumarMedallaOro();
                        temp.sumarMedallaOro();
                    }
                }
                listaParticip.add(participation);

            }

        }
        Repositorio.setHashEventos(hashEventos);
        Repositorio.setHashAtleta(hashAtleta);
        Repositorio.setHashGames(hashGames);
        Repositorio.setListaParticip(listaParticip);
    }
}
