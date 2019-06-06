public class Principal {
    public static void main(String[] args) {
       /* Stack<String> prueba = new Stack<>("hola0");
        prueba.push("hola1");

        prueba.push("hola2");
        if(prueba.isEmpty()) System.out.println("vacioooo");
        try {
            System.out.println(prueba.top());
            prueba.pop();
            System.out.println(prueba.top());
            prueba.makeEmpty();
            System.out.println(prueba.top());
            System.out.println("se hace?");

        } catch (EmptyStackException e) {
            System.out.println("stack vacio");
        }

        */
        StackArrays<String> prueba2 = new StackArrays<>(101);
        prueba2.push("hola1");
        prueba2.push("hola2");
        if (prueba2.isEmpty()) {
            System.out.println("vacioooo");
        }
        if (!prueba2.isEmpty()) {
            System.out.println("no vacioooo");
        }

        ;
        try {
            System.out.println(prueba2.top());
            prueba2.pop();
            System.out.println(prueba2.top());
            prueba2.makeEmpty();
            System.out.println(prueba2.top());
            System.out.println("se hace?");

        } catch (EmptyStackException e) {
            System.out.println("stack vacio");
        }


    }
}
