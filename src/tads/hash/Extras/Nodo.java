package tads.hash.Extras;

public class Nodo<t, k> {
    private k key;
    private t value;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(k key, t value) {
        this.key = key;
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

    public k getKey() { return key; }

    public t getValue() {
        return value;
    }
}
