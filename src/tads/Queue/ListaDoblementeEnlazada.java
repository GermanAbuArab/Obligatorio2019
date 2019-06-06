

public class ListaDoblementeEnlazada<t> implements Lista<t> {
    private Nodo primero;
    private int cantElementos;

    public ListaDoblementeEnlazada(Nodo primero) {
        this.primero = primero;
        this.cantElementos = 1;
    }

    public ListaDoblementeEnlazada() {
        this.cantElementos = 0;
    }

    public void add(t objeto) {
        this.cantElementos = cantElementos + 1;
        Nodo nuevoElemento = new Nodo(objeto);
        if (this.primero == null) {
            this.primero = nuevoElemento;
        } else {
            Nodo<t> temp = primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            nuevoElemento.setAnterior(temp);
            temp.setSiguiente(nuevoElemento);
        }
    }

    public Nodo<t> getNodo(int position) {
        Nodo<t> temp = primero;
        for (int i = 0; i < position; i++) {
            temp = temp.getSiguiente();
        }
        return temp;
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


