package tads.linkedlist;

public class ListaEnlazada<t> implements Lista<t> {
    private Nodo primero;
    private int cantElementos;

    public ListaEnlazada(Nodo primero) {
        this.primero = primero;
        this.cantElementos = 1;
    }

    public ListaEnlazada() {
        this.cantElementos = 0;
    }

    public void addFirst(t value) {
        Nodo<t> temp = primero;
        Nodo<t> nuevoPri = new Nodo(value);
        nuevoPri.setSiguiente(temp);
        this.primero = nuevoPri;
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
            temp.setSiguiente(nuevoElemento);
        }
    }


    public void remove(int position) {
        this.cantElementos = cantElementos - 1;
        Nodo<t> temp = primero;
        Nodo<t> tempAnt = null;
        Nodo<t> tempPost = null;
        if(position==0){
            Nodo<t> zero = primero.getSiguiente();
            this.primero=zero;
            position=-1;
        }
        for (int i = 0; i <= position; i++) {
            if (i == position - 1) {
                tempAnt = temp;
            }
            if (i == position) {
                tempPost = temp.getSiguiente();
                tempAnt.setSiguiente(tempPost);
            }
            if (i < position) {
                temp = temp.getSiguiente();
            }
        }
    }


    public t get(int position) {
        Nodo<t> temp = primero;
        for (int i = 0; i < position; i++) {
            temp = temp.getSiguiente();
        }
        return temp.getValue();
    }

    public boolean existeElemento(t elemento) {
        Nodo<t> temp = primero;
        boolean existe = false;
        for (int i = 0; i < cantElementos; i++) {
            if ((temp.getValue()).equals(elemento)) {
                existe = true;
            }
            temp = temp.getSiguiente();

        }
        return existe;
    }

}

