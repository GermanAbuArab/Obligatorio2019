public class Nodo<T> {
    private T value;
    private Nodo<T> siguiente;

    public Nodo(T o){
        this.value= o;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public T getValue() {
        return value;
    }
}
