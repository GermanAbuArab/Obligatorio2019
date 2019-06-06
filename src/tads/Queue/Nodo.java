

public class Nodo<t> {
    private t value;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(t value) {
        this.value = value;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public t getValue() {
        return value;
    }
}
