import entidades.*;
import tads.hash.ElementoYaExistenteException;
import tads.hash.Hash;
import tads.hash.HashAbierto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public  class CargaDeDatos {
    static BufferedReader br;
    static BufferedReader br2;

    // ToDo nocRegister

    public static void main(String[] args) {


        try {
            br2 = new BufferedReader(new FileReader("noc_regions.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Hash<NationalOlympicCommittee,String> nocs = new Hash<>(330);
        String line2 = null;
        int primeraLinea2 = 1;
        while (true) {
            try {
                if ((line2 = br2.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] values = line2.split(",");
            if (primeraLinea2 == 1) {
                primeraLinea2 = 0;
            } else {
                String noc1 = (values[0]);
                String region = (values[1]);
                NationalOlympicCommittee pais = new NationalOlympicCommittee(noc1,region);
                try {
                    nocs.insertar(noc1,pais);
                } catch (ElementoYaExistenteException e) {
                    e.printStackTrace(); // nunca va a pasar porque no se repiten los noc
                }
            }
        }
        Repositorio.setHashNOC(nocs);


        try {
            br = new BufferedReader(new FileReader("athlete_events.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        String line = null;
        int primeraLinea = 1;
        HashAbierto<Athlete,Integer> hashAtleta = new HashAbierto<>(75000);
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


                long id = Long.valueOf(values[0].substring(1,(int) (values[0].length()-1))); // hay un tema  no podemos usar el long value of porque hay "" y las toma como parte del string
                String name = values[1].substring(1,((int) (values[1].length()-1)));
                SexType sex;
                if (values[2].substring(1,((int) (values[2].length()-1))).equals("M")) {
                    sex = SexType.MALE;
                } else if (values[2].substring(1,((int) (values[2].length()-1))).equals("F")) {
                    sex = SexType.FEMALE;
                }
                int age = Integer.valueOf(values[3]);
                float heigth = Float.valueOf(values[4]);
                float weigth = Float.valueOf(values[5]);

                //
                Team team = new Team(values[6].substring(1,((int) (values[6].length()-1))));
                String Noc =values[7].substring(1,((int) (values[7].length()-1)));
                String games = values[8].substring(1,((int) (values[8].length()-1)));
                int year = Integer.valueOf(values[9]);
                SeasonType season;
                if (values[10].substring(1,((int) (values[10].length()-1))).equals("Summer")) {
                    season = SeasonType.SUMMER;
                } else if (values[10].substring(1,((int) (values[10].length()-1))).equals("Winter")) {
                    season = SeasonType.WINTER;
                }
                String city = values[11].substring(1,((int) (values[11].length()-1)));
                String sport = values[12].substring(1,((int) (values[12].length()-1)));
                String event = values[13].substring(1,((int) (values[13].length()-1)));
                MedalType medal;
                switch (values[14].substring(1,((int) (values[14].length()-1)))) {
                    case "":
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

                //
                NationalOlympicCommittee temp = Repositorio.getHashNOC().
                Athlete atleta = new Athlete(id,name,sex,heigth,weigth,team,noc)



                //  Athlete atleta = new Athlete(id, name, sex, heigth, weigth, team, no)
            }
        }

    }
}
