public class Stack<T> implements MyStack<T> {
    private Nodo<T> primero;


    public Stack(T o) {
        Nodo<T> nuevo = new Nodo<T>(o);
        this.primero = nuevo;
    }

    public T top() throws EmptyStackException {
        if (primero == null) throw new EmptyStackException();
        Nodo<T> temp = primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        return temp.getValue();
    }

    public void pop() throws EmptyStackException { //sacar el ultimo
        if (primero == null) throw new EmptyStackException();
        int i = 0;
        if (primero.getSiguiente() == null) {
            primero=null;
            i=1;
        }
        if (i == 0) {
            Nodo<T> temp = primero;
            Nodo<T> tempant = primero;
            while (temp.getSiguiente() != null) {
                tempant = temp;
                temp = temp.getSiguiente();
            }
            tempant.setSiguiente(null);
        }
    }

    public void push(T element) {//mete uno arriba
        Nodo<T> ultimo = new Nodo<>(element);
        Nodo<T> temp = primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(ultimo);
    }

    public boolean isEmpty() {
        if (primero == null) {
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        primero = null;
    }
}
