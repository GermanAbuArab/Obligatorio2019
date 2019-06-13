import java.util.Scanner;

public class Menu {

    public static void main(String args[]) {

    CargaDeDatos.carga();
    String choice = null;
    Scanner sc =new Scanner(System.in);

    do{
        System.out.println("-------------[Menu Principal]--------------");
        System.out.println("1 - Indicar el top 10 de atletas que consiguieron la mayor cantidad de medallas en la historia de los juegos");
        System.out.println("2 - Indicar el top 10 de regiones que consiguieron la mayor cantidad de medallas en la historia de los juegos" );
        System.out.println("3 - Indicar el top 10 de ediciones de los juegos olímpicos donde se tuvo mayor participación de atletas femeninos");
        System.out.println("4 - Indicar las 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo. Si es femenino o masculino se debe solicitar como dato de entrada");
        System.out.println("5 - Indicar los 5 equipos mas efectivos entre un rango de años (especificadas al ejecutar el reporte)");
        System.out.println("0 - Terminar");

        choice=sc.nextLine();
        switch (choice){
            case "1":
                    Consultas.consultaUno(4);
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
        }
    }
        while (!choice.equals("0"));
        sc.close();


    }

}
