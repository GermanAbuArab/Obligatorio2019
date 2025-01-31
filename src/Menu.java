import java.util.Scanner;

public class Menu {

    public static void menu() {


        CargaDeDatos.carga();

        long tiempoInicial;
        long tiempoFinal;

        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("-------------[Menu Principal]--------------");
            System.out.println("1 - Indicar el top 10 de atletas que consiguieron la mayor cantidad de medallas en la historia de los juegos");
            System.out.println("2 - Indicar el top 10 de regiones que consiguieron la mayor cantidad de medallas en la historia de los juegos");
            System.out.println("3 - Indicar el top 10 de ediciones de los juegos olímpicos donde se tuvo mayor participación de atletas femeninos");
            System.out.println("4 - Indicar las 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo. Si es femenino o masculino se debe solicitar como dato de entrada");
            System.out.println("5 - Indicar los 5 equipos mas efectivos entre un rango de años (especificadas al ejecutar el reporte)");
            System.out.println("0 - Terminar");


            choice = sc.nextLine();
            if (!choice.equals("0") && !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5")) {
                System.out.println("Operacion no valida");
            }
            switch (choice) {
                case "1":
                    String choice2;
                    do {
                        System.out.println("-------------[Elija Tipo De Medalla]--------------");
                        System.out.println("1 - Por medallas de oro");
                        System.out.println("2 - Por medallas de plata");
                        System.out.println("3 - Por medallas de bronce");
                        System.out.println("4 - Por medallas en total");
                        System.out.println("0 - Volver al Menu");
                        choice2 = sc.nextLine();
                        if (!choice2.equals("0") && !choice2.equals("1") && !choice2.equals("2") && !choice2.equals("3") && !choice2.equals("4")) {
                            System.out.println("Operacion no valida");
                        }

                        switch (choice2) {
                            case "1":
                                System.out.println("-------------{Jugadores con mas medallas de oro}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaUno(1);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice2 = "0";
                                break;
                            case "2":
                                System.out.println("-------------{Jugadores con mas medallas de plata}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaUno(2);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice2 = "0";
                                break;
                            case "3":
                                System.out.println("-------------{Jugadores con mas medallas de bronce}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaUno(3);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice2 = "0";
                                break;
                            case "4":
                                System.out.println("-------------{Jugadores con mas medallas}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaUno(4);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice2 = "0";
                                break;
                        }
                    } while (!choice2.equals("0"));
                    break;
                case "2":
                    String choice3;
                    do {

                        System.out.println("-------------[Elija Tipo De Medalla]--------------");
                        System.out.println("1 - Por medallas de oro");
                        System.out.println("2 - Por medallas de plata");
                        System.out.println("3 - Por medallas de bronce");
                        System.out.println("4 - Por medallas en total");
                        System.out.println("0 - Volver al Menu");
                        choice3 = sc.nextLine();
                        if (!choice3.equals("0") && !choice3.equals("1") && !choice3.equals("2") && !choice3.equals("3") && !choice3.equals("4")) {
                            System.out.println("Operacion no valida");
                        }

                        switch (choice3) {
                            case "1":
                                System.out.println("-------------{Regiones con mas medallas de oro}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaDos(1);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice3 = "0";
                                break;
                            case "2":
                                System.out.println("-------------{Regiones con mas medallas de plata}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaDos(2);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice3 = "0";
                                break;
                            case "3":
                                System.out.println("-------------{Regiones con mas medallas de bronce}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaDos(3);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice3 = "0";
                                break;
                            case "4":
                                System.out.println("-------------{Regiones con mas medallas}--------------");
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaDos(4);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice3 = "0";
                                break;
                        }
                    } while (!choice3.equals("0"));
                    break;
                case "3":
                    tiempoInicial = System.currentTimeMillis();
                    Consultas.consultaTres();
                    tiempoFinal = System.currentTimeMillis();
                    System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                    break;
                case "4":
                    String choice4;
                    do {
                        System.out.println("-------------{Elija el sexo}--------------");
                        System.out.println("1 - Hombre");
                        System.out.println("2 - Mujer");
                        System.out.println("0 - Volver al Menu");
                        choice4 = sc.nextLine();
                        if (!choice4.equals("0") && !choice4.equals("1") && !choice4.equals("2")) {
                            System.out.println("Operacion no valida");
                        } else {
                            if (!choice4.equals("0")) {
                                boolean sexo = false;
                                if (choice4.equals("1")) {
                                    sexo = true;
                                }
                                tiempoInicial = System.currentTimeMillis();
                                Consultas.consultaCuatro(sexo);
                                tiempoFinal = System.currentTimeMillis();
                                System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                                choice4 = "0";
                            }
                        }
                    } while (!choice4.equals("0"));
                    break;
                case "5":
                    String choice5;
                    boolean cond = false;
                    long min = 0;
                    long max = 0;
                    boolean condDePasada = true;
                    do {
                        System.out.println("-------------{Indique el rango de años}--------------");
                        System.out.println("- Año mínimo");
                        choice5 = sc.nextLine();
                        try {
                            min = Integer.valueOf(choice5);
                        } catch (java.lang.NumberFormatException e) {
                            condDePasada = false;
                        }
                        System.out.println(" - Año máximo");
                        choice5 = sc.nextLine();
                        try {
                            max = Integer.valueOf(choice5);
                        } catch (java.lang.NumberFormatException e) {
                            condDePasada = false;
                        }
                        if (min > max || min < 0 || max > 2019 || !condDePasada)
                            System.out.println("Ingrese datos validos");
                        else {
                            cond = true;
                        }
                    } while (!cond);
                    tiempoInicial = System.currentTimeMillis();
                    Consultas.consultaCinco(min, max);
                    tiempoFinal = System.currentTimeMillis();
                    System.out.println((tiempoFinal - tiempoInicial) / 1000.0 + " segundo en devolver");
                    break;
            }
            System.out.println("  ");
            System.gc();


        }
        while (!choice.equals("0"));
        sc.close();

    }

}
