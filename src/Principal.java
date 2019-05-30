import entidades.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
    // aca ponemos las consultas que nos pide hacer
    // to do generar todos los atletas y guardarlos en un

    List<List<String>> records = new ArrayList<>();
    BufferedReader br;
    BufferedReader br2;

    // ToDo nocRegister

// main 
    {
        try {
            br2 = new BufferedReader(new FileReader("noc_regions.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        String line2 = null;
        int primeralinea2 = 1;
        while (true) {
            try {
                if ((line2 = br2.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] values = line2.split(",");
            if (primeralinea2 == 1) {
                primeralinea2 = 0;
            } else {
                String = (long) Integer.valueOf(values[0]);
            }
        }

    }

    {
        try {
            br = new BufferedReader(new FileReader("athlete_events.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        String line = null;
        int primeralinea = 1;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] values = line.split(",");

            if (primeralinea == 1) {
                primeralinea = 0;
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
                if (values[14].equals("NA")) {
                    medal = null;
                } else if (values[14].equals("Bronze")) {
                    medal = MedalType.BRONZE;
                } else if (values[14].equals("Silver")) {
                    medal = MedalType.SILVER;
                } else if (values[14].equals("Gold")) {
                    medal = MedalType.GOLD;
                }


              //  Athlete atleta = new Athlete(id, name, sex, heigth, weigth, team, no)
            }
        }
    }
}
