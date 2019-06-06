public class Node<K extends Comparable, T extends Comparable>  {
    private K key; //atributo extra
    private T data;
    private Node<K, T> leftChild;
    private Node<K, T> rightChild;

    public Node(K key, T data) {
        this.key = key;
        this.data = data;
        leftChild=null;
        rightChild=null;
    }

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}