package tads.Queue;

public class ListaCircular<t> implements Lista<t> {
    private Nodo primero;
    private int cantElementos;

    public ListaCircular(t o) {
        Nodo<t> primero = new Nodo<>(o);
        this.primero = primero;
        primero.setSiguiente(primero);
        primero.setAnterior(primero);
        this.cantElementos = 1;
    }


    public void add(t objeto) {

        Nodo nuevoElemento = new Nodo(objeto);
        Nodo<t> temp = primero;
        int posicion=0;
        while(posicion<cantElementos-1){
            temp = temp.getSiguiente();
            posicion=posicion+1;
        }
        nuevoElemento.setAnterior(temp);
        nuevoElemento.setSiguiente(primero);
        temp.setSiguiente(nuevoElemento);
        if(temp.getAnterior().equals(temp)){
            temp.setAnterior(nuevoElemento);
        }
        this.cantElementos = cantElementos + 1;
    }


    public t get(int position) {
        Nodo<t> temp = primero;
        for (int i = 0; i < position; i++) {
            temp = temp.getSiguiente();
        }
        return temp.getValue();
    }

    public void remove(int position) {
        this.cantElementos = cantElementos - 1;
        Nodo<t> temp = primero;
        Nodo<t> tempAnt = null;
        Nodo<t> tempPost = null;
        for (int i = 0; i <= position; i++) {
            if (i == position - 1) {
                tempAnt = temp;
            }
            if (i == position) {
                tempPost = temp.getSiguiente();
                tempAnt.setSiguiente(tempPost);
                tempPost.setAnterior(tempAnt);
            }
            if (i < position) {
                temp = temp.getSiguiente();
            }
        }
    }


}