import entidades.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    // aca ponemos las consultas que nos pide hacer
    // ToDo generar todos los atletas y guardarlos en un-
    //  hay que cambiar esto a otra clase
    // Tenemos problemas con el main y no se solucinoarlo aaaaaah aiudaaaaa, se lo pregunto a rolo tech
    List<List<String>> records = new ArrayList<>();
    static BufferedReader br;
    static BufferedReader br2;

    // ToDo nocRegister

    public static void main(String[] args) {



            try {
                br2 = new BufferedReader(new FileReader("noc_regions.csv"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



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
                    String notas = (values[2]);
                    //agregarlo a un tad
                }
            }


            try {
                br = new BufferedReader(new FileReader("athlete_events.csv"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



            String line = null;
            int primeraLinea = 1;
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


                    long id = Long.valueOf(values[0]);
                    String name = values[1];
                    SexType sex;
                    if (values[2].equals("M")) {
                        sex = SexType.MALE;
                    } else if (values[2].equals("F")) {
                        sex = SexType.FEMALE;
                    }
                    int age = Integer.valueOf(values[3]);
                    float heigth = Float.valueOf(values[4]);
                    float weigth = Float.valueOf(values[5]);

                    //
                    Team team = new Team(values[6]);
                    String Noc = values[7];
                    String games = values[8];
                    int year = Integer.valueOf(values[9]);
                    SeasonType season;
                    if (values[10].equals("Summer")) {
                        season = SeasonType.SUMMER;
                    } else if (values[10].equals("Winter")) {
                        season = SeasonType.WINTER;
                    }
                    String city = values[11];
                    String sport = values[12];
                    String event = values[13];
                    MedalType medal;
                    switch (values[14]) {
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


                    //  Athlete atleta = new Athlete(id, name, sex, heigth, weigth, team, no)
                }
            }

    }
}
