package tads.hash.Extras;

public class ListaEnlazada<t, k> {
    private Nodo<t, k> primero;
    private int cantElementos;

    public ListaEnlazada(Nodo<t, k> primero) {
        this.primero = primero;
        this.cantElementos = 1;
    }

    public ListaEnlazada() {
        this.cantElementos = 0;
    }


    public void add(k key, t value) throws ElementoYaExistente {
        Nodo nuevoElemento = new Nodo(key, value);

        if (this.primero == null) {
            this.primero = nuevoElemento;
            this.cantElementos = cantElementos + 1;
        } else {
            Nodo<t, k> temp = primero;
            while (temp.getSiguiente() != null || temp.getKey().equals(key)) {
                if (temp.getKey().equals(key)) {
                    throw new ElementoYaExistente();
                }
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoElemento);
            this.cantElementos = cantElementos + 1;
        }
    }


    public void remove(k key) throws ElementoNoExistente {
        if(primero==null){
            throw new ElementoNoExistente();
        }
        Nodo<t, k> temp = primero;
        Nodo<t, k> tempAnt = null;
        Nodo<t, k> tempPost = null;
        int i = 1;
        if (primero.getKey().equals(key)) {
            if (primero.getSiguiente() == null) {
                primero = null;
            } else {
                primero = primero.getSiguiente();
            }
        } else {
            while (i < cantElementos) {
                if (temp.getSiguiente().getKey().equals(key)) {
                    i=cantElementos+1;
                    tempAnt = temp;
                    temp = temp.getSiguiente();
                    if (temp.getSiguiente() != null) {
                        tempPost = temp.getSiguiente();
                        tempAnt.setSiguiente(tempPost);
                    } else {
                        tempAnt.setSiguiente(null);
                    }
                } else {
                    i++;
                    temp=temp.getSiguiente();
                }
            }
            if (i == cantElementos) {
                throw new ElementoNoExistente();
            }
        }
        this.cantElementos = cantElementos - 1;
    }


    public boolean existeElemento(k key) {
        Nodo<t, k> temp = primero;
        boolean existe = false;
        for (int i = 0; i < cantElementos; i++) {
            if ((temp.getKey()).equals(key)) {
                existe = true;
                break;
            }
            temp = temp.getSiguiente();

        }
        return existe;
    }

}

