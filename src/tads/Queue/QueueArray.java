public class QueueArray<T> implements MyQueue<T>{
    private T[] queue;
    private int posicion;
    private int tam;

    public QueueArray(int tam) {
        T[] queue1 = (T[]) new Object[tam];
        this.queue = queue1;
        this.posicion=0;
        this.tam=tam;
    }

    public void enqueue(T element) {
        if(posicion<tam) {
            queue[posicion] = element;
            posicion = posicion + 1;
        }else{
            tam=tam*2;
            T[] queue2 = (T[]) new Object[tam];
            int temp=0;
            while(temp<posicion){
                queue2[temp]=queue[temp];
                temp=temp+1;
            }
            this.queue=queue2;
        }
    }

    public T dequeue() throws EmptyQueueException {
        if(queue[0]==null){
            throw new EmptyQueueException();
        }
        T deque=queue[0];
        for(int i=0;i<posicion-1;i++){
            queue[i]=queue[i+1];
        }
        this.posicion=posicion-1;
        return deque;
    }

    public boolean isEmpty() {
        if(queue[0]==null){return true;}else{return false;}
    }

    public T getFirst() throws EmptyQueueException {
        if(queue[0]==null){
            throw new EmptyQueueException();
        }
        return queue[0];
    }
}
