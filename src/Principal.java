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

    {
        try {
            br = new BufferedReader(new FileReader("athlete_events.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } {
        String line = null;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] values = line.split(",");
            int id = Integer.parseInt(values[0]);
            String name = values[1];
         //   SexType sex = SexType.valueOf(values[2]);
            int age = Integer.valueOf(values[3]);
            float heigth = Float.valueOf(values[4]);
            float weigth = Float.valueOf(values[5]);
            String team = values[6];
            String Noc = values[7];
            String games = values[8];
            int year = Integer.valueOf(values[9]);
           // SeasonType season = SeasonType.valueOf(values[10]);
            String city = values[11];
            String sport = values[12];
            String event = values[13];
            // MedalType medal = MedalType.valueOf(values[14]);


        }
    }
}
