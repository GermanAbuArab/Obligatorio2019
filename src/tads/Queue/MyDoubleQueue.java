package tads.Queue;

public class MyDoubleQueue<T> implements MyQueue<T> {
  private ListaEnlazada<T> lista;
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Nodo<T> getPrimero() {
        return primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public MyDoubleQueue() {
        ListaEnlazada<T> enlazada = new ListaEnlazada<>();
        this.lista = enlazada;
    }

    public void enqueue(T element) {
        lista.add(element);
        if (lista.getCantElementos() == 1) {
            this.primero = lista.getPrimero();
            this.ultimo = lista.getPrimero();
        } else {
            int cant = lista.getCantElementos();
            this.ultimo=lista.getNodo(cant-1);
        }

    }
    public void enqueueLeft(T element) {
        lista.addFirst(element);
        if (lista.getCantElementos() == 1) {
            this.primero = lista.getPrimero();
            this.ultimo = lista.getPrimero();
        } else {
            this.primero=lista.getNodo(0);
        }

    }
    public T dequeueRight() throws EmptyQueueException {
        int cant=lista.getCantElementos();
        Nodo<T> temp = lista.getPrimero();
        if (temp == null) throw new EmptyQueueException();
        Nodo<T> temp2 = lista.getNodo(cant-1);
        this.ultimo = lista.getNodo(cant-2);
        ultimo.setSiguiente(null);
        return temp2.getValue();
    }

    public T dequeue() throws EmptyQueueException {
        Nodo<T> temp = lista.getPrimero();
        Nodo<T> temp1 = temp;
        if (temp == null) throw new EmptyQueueException();
        temp = temp.getSiguiente();
        lista.setPrimero(temp);
        this.primero=temp;
        return temp1.getValue();
    }

    public boolean isEmpty() {
        if (lista.getPrimero() == null) {
            return true;
        } else {
            return false;
        }
    }

    public T getFirst() throws EmptyQueueException {
        if (lista.getPrimero() == null) throw new EmptyQueueException();
        return lista.getPrimero().getValue();
    }
}



