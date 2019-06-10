import java.util.Scanner;

public class Menu {

    void main(String args[]) {


    String choice = null;
    Scanner sc =new Scanner(System.in);

    do{
        System.out.println("-------------[Menu Principal]--------------");
        System.out.println("1 -");
        System.out.println("2 -" );
        System.out.println("3 -");
        System.out.println("4 -");
        System.out.println("0 - Terminar");
        choice=sc.nextLine();
        switch (choice){
            case "1":

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
