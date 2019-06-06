package tads.linkedlist;

public class Principal {
    public static void main(String[] args) {

        String hola = "lugar1";
        String hola2 = "lugar2";
        String hola3 = "lugar3";
        ListaDoblementeEnlazada<String> prueba2 = new ListaDoblementeEnlazada<String>();
        prueba2.add(hola);
        prueba2.add(hola2);
        prueba2.add(hola3);
        prueba2.remove(1);
        Nodo<String> temp = prueba2.getNodo(1);
        // System.out.println((temp.getSiguiente()).getValue());
        System.out.println(temp.getAnterior().getValue());
       /* ListaEnlazada<String> prueba = new ListaEnlazada<String>();
        prueba.add(hola);
        prueba.add(hola2);
        System.out.println( prueba.get(1));
        prueba.add(hola3);
        prueba.remove(1);
        System.out.println( prueba.get(1));
        if(prueba.existeElemento(hola)){
            System.out.println("funciono");
        }
        String hola4= "nuevopri";
        prueba.addFirst(hola4);
        System.out.println( prueba.get(1));
        System.out.println( prueba.get(0));
        */

    }
}
