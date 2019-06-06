package tads.Queue;

public interface MyQueue<T>  {

    void enqueue(T element);

    T dequeue() throws EmptyQueueException;

    boolean isEmpty();

    T getFirst() throws EmptyQueueException;

}
