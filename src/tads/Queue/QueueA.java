public class QueueA<T> implements MyQueue<T> {
    private ListaEnlazada<T> lista;

    public QueueA() {
        ListaEnlazada<T> enlazada = new ListaEnlazada<>();
        this.lista = enlazada;
    }

    public void enqueue(T element) {
        lista.add(element);
    }

    public T dequeue() throws EmptyQueueException {
        Nodo<T> temp = lista.getPrimero();
        Nodo<T> temp1 = temp;
        if (temp == null) throw new EmptyQueueException();
        temp = temp.getSiguiente();
        lista.setPrimero(temp);
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
