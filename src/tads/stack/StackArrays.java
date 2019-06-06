public class StackArrays<T> implements MyStack<T> {
    private T[] stack;
    private int posicion;

    public StackArrays(int tam){
        T[] stack1 = (T[]) new Object[tam];
        this.stack = stack1;
        this.posicion = 0;
    }

    public void pop() throws EmptyStackException {
        if (this.stack[posicion] == null) throw new EmptyStackException();
        stack[posicion] = null;
        posicion = posicion - 1;

    }

    public T top() throws EmptyStackException {
        if (stack[posicion] == null) throw new EmptyStackException();
        return stack[posicion];
    }

    public void push(T element) {
        posicion = posicion + 1;
        stack[posicion] = element;
    }


    public boolean isEmpty() {
        if (stack[posicion] == null) return true;
        return false;
    }

    public void makeEmpty() {
        for (int i = 0; i <= posicion; i++) {
            stack[i] = null;
        }
        posicion = 0;
    }
}
