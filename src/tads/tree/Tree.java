import java.util.ArrayList;
import java.util.List;

public class Tree<K extends Comparable, T extends Comparable> implements MyTree<K, T> {

    private Node<K, T> root;


    public Tree(Node<K, T> root) {
        this.root = root;
    }

    public T find(K key) {
        return find2(root, key);
    }

    public List<K> inOrder() {
        List<K> inOrder = new ArrayList<>();
        inOrder2(root,inOrder);
        return inOrder;
    }
    private void inOrder2(Node<K,T> aux,List<K> inOrder){
        if(aux == null) return;
        inOrder2(aux.getLeftChild(),inOrder);
        inOrder.add(aux.getKey());
        inOrder2(aux.getRightChild(),inOrder);
    }

    public List<K> preOrder() {
        List<K> preOrder = new ArrayList<>();
        preOrder2(root,preOrder);
        return preOrder;
    }
    private void preOrder2(Node<K,T> aux,List<K> preOrder){
        if(aux == null) return;
        preOrder.add(aux.getKey());
        preOrder2(aux.getLeftChild(),preOrder);
        preOrder2(aux.getRightChild(),preOrder);
    }

    public List<K> postOrder() {
        List<K> postOrder = new ArrayList<>();
        postOrder2(root,postOrder);
        return postOrder;
    }

    private void postOrder2(Node<K,T> aux,List<K> postOrder){
        if(aux == null) return;
        postOrder2(aux.getLeftChild(),postOrder);
        postOrder2(aux.getRightChild(),postOrder);
        postOrder.add(aux.getKey());
    }

    private T find2(Node<K, T> aux, K key) {
        T result = null;

        if (aux != null) {
            if (aux.getKey().equals(key)) {
                result = aux.getData();
            } else {
                if (aux.getLeftChild() != null) {
                    result = find2(aux.getLeftChild(), key);
                }
                if (result == null && aux.getRightChild() != null) {

                    result = find2(aux.getRightChild(), key);
                }
            }
        }
        return result;
    }

    public void delete(K key) {
        Node<K, T> nuevo = buscarPadre(root,key);
        if(nuevo.getLeftChild().getKey().equals(key)) nuevo.setLeftChild(null);
        else nuevo.setRightChild(null);
    }

    public void insert(K key, T data, K parentKey) {
        Node<K, T> nuevo = new Node<>(key, data);
        Node<K, T> padre = buscarNodo(root, parentKey);
        if (padre != null) {
            if(padre.getLeftChild()==null) padre.setLeftChild(nuevo);
            else if(padre.getRightChild()==null) padre.setRightChild(nuevo);
        }
    }

    public long size(){
        long result=0;
        result=size2(root,result);
        return result;
    }

    public long countLeaf(){
        long result=0;
        result= countLeaf2(root,result);
        return result;
    }

    public long countCompleteElements(){
        long result=0;
        result= countCompleteElements(root,result);
        return result;
    }

    private long countCompleteElements(Node<K,T> aux, long result) {
        if (aux.getLeftChild()!= null && aux.getRightChild()!=null) {
            result=result+1;
        }

        if (aux.getLeftChild() != null) {
            result = countCompleteElements(aux.getLeftChild(), result);
        }
        if (aux.getRightChild() != null) {
            result = countCompleteElements(aux.getRightChild(), result);
        }

        return result;
    }

    private long countLeaf2(Node<K,T> aux, long result) {
        if (aux.getLeftChild()== null && aux.getRightChild()==null) {
            result=result+1;
        }

        if (aux.getLeftChild() != null) {
            result = countLeaf2(aux.getLeftChild(), result);
        }
        if (aux.getRightChild() != null) {
            result = countLeaf2(aux.getRightChild(), result);
        }

        return result;
    }


    private long size2(Node<K, T> aux,long result) {
        if (aux != null) {
            result=result+1;
            }

        if (aux.getLeftChild() != null) {
            result = size2(aux.getLeftChild(), result);
        }
        if (aux.getRightChild() != null) {
            result = size2(aux.getRightChild(), result);
        }

        return result;
    }

    public Node<K, T> buscarNodo(Node<K, T> aux, K key) {
        Node<K, T> result = null;
        if (aux != null) {
            if (aux.getKey().equals(key)) {
                result = aux;
            } else {
                if (aux.getLeftChild() != null) {
                    result = buscarNodo(aux.getLeftChild(), key);
                }
                if (result == null && aux.getRightChild() != null) {

                    result = buscarNodo(aux.getRightChild(), key);
                }
            }
        }
        return result;
    }
    public Node<K, T> buscarPadre(Node<K, T> aux, K key) {
        Node<K, T> result = null;
        if (aux != null) {
            if (aux.getRightChild().getKey().equals(key) || aux.getLeftChild().getKey().equals(key)) {
                result = aux;
            } else {
                if (aux.getLeftChild() != null) {
                    result = buscarNodo(aux.getLeftChild(), key);
                }
                if (result == null && aux.getRightChild() != null) {

                    result = buscarNodo(aux.getRightChild(), key);
                }
            }
        }
        return result;
    }
}
