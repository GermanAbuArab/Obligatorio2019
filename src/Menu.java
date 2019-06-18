import java.util.Date;
import java.util.Scanner;
import java.util.Date;

public class Menu {

    public static void main(String args[]) {

        CargaDeDatos.carga();
        String choice = null;
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
                    String choice2 = null;
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
                                Consultas.consultaUno(1);
                                choice2 = "0";
                                break;
                            case "2":
                                System.out.println("-------------{Jugadores con mas medallas de plata}--------------");
                                Consultas.consultaUno(2);
                                choice2 = "0";
                                break;
                            case "3":
                                System.out.println("-------------{Jugadores con mas medallas de bronce}--------------");
                                Consultas.consultaUno(3);
                                choice2 = "0";
                                break;
                            case "4":
                                System.out.println("-------------{Jugadores con mas medallas}--------------");
                                Consultas.consultaUno(4);
                                choice2 = "0";
                                break;
                        }
                    } while (!choice2.equals("0"));
                    break;
                case "2":
                    String choice3 = null;
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
                                Consultas.consultaDos(1);
                                choice3 = "0";
                                break;
                            case "2":
                                System.out.println("-------------{Regiones con mas medallas de plata}--------------");
                                Consultas.consultaDos(2);
                                choice3 = "0";
                                break;
                            case "3":
                                System.out.println("-------------{Regiones con mas medallas de bronce}--------------");
                                Consultas.consultaDos(3);
                                choice3 = "0";
                                break;
                            case "4":
                                System.out.println("-------------{Regiones con mas medallas}--------------");
                                Consultas.consultaDos(4);
                                choice3 = "0";
                                break;
                        }
                    } while (!choice3.equals("0"));
                    break;
                case "3":
                    Consultas.consultaTres();

                    break;
                case "4":
                    String choice4 = null;
                    do {
                        System.out.println("-------------{Elija el sexo}--------------");
                        System.out.println("1 - Hombre");
                        System.out.println("2 - Mujer");
                        System.out.println("0 - Volver al Menu");
                        choice4 = sc.nextLine();
                        if (!choice4.equals("0") && !choice4.equals("1") && !choice4.equals("2")) {
                            System.out.println("Operacion no valida");
                        }
                        if (!choice4.equals("0")) {
                            boolean sexo = false;
                            if (choice4.equals("1")) {
                                sexo = true;
                            }
                            Consultas.consultaCuatro(sexo);
                            choice4 = "0";
                        }
                    } while (!choice4.equals("0"));
                    break;
                case "5":
                    Date fecha = new Date();
                    String choice5 = null;
                    boolean cond = false;
                    long min;
                    long max;
                    do {
                        System.out.println("-------------{Indique el rango de años}--------------");

                        System.out.println("- Año mínimo");
                        choice5 = sc.nextLine();
                        min = Integer.valueOf(choice5);
                        System.out.println(" - Año máximo");
                        choice5 = sc.nextLine();
                        max = Integer.valueOf(choice5);
                        if (min > max || min < 0 || max > fecha.getYear())
                            System.out.println("Ingrese datos validos");
                        else {
                            cond = true;
                        }
                    } while (!cond);
                    Consultas.consultaCinco(min, max);
                    break;
            }
            System.out.println("  ");

        }
        while (!choice.equals("0"));
        sc.close();

    }

}
