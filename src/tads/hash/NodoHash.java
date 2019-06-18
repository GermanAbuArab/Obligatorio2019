package tads.hash;

public class NodoHash<K,T> {
    private K valor;
    private T clave;
    private boolean isRemoved;

    public NodoHash(K valor, T clave, boolean isRemoved) {
        this.valor = valor;
        this.clave = clave;
        this.isRemoved = isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public void setValor(K valor) {
        this.valor = valor;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public K getValor() {
        return valor;
    }

    public T getClave() {
        return clave;
    }

    public boolean isRemoved() {
        return isRemoved;
    }
}
