import tads.heap.Node;

import java.util.ArrayList;

public class ArbolCompleto<K extends Comparable, T> {

    private Node<K, T> root;
    private Node<K, T> ultimo;

    public Node<K, T> getUltimo() {
        return ultimo;
    }

    public void insert(K key, T data) {
        Node<K, T> nuevo = new Node<>(key, data);
        if (root == null) {
            ultimo = nuevo;
            root = nuevo;
        } else {
            insert(root, nuevo);
            ultimo = nuevo;
        }
    }

    private void insert(Node<K, T> root, Node<K, T> nuevo) {
        if (root.getLeftChild() == null) root.setLeftChild(nuevo);
        else if (root.getRightChild() == null) root.setRightChild(nuevo);
        else if (root.getLeftChild() != null) insert(root.getLeftChild(), nuevo);
        else if (root.getRightChild() != null) insert(root.getRightChild(), nuevo);
    }

    public void delete(K key) {
        Node<K, T> padreDeEliminar = buscarPadre(root, key);
        Node<K, T> padreDeUltimo = buscarPadre(root, ultimo.getKey());
        if (padreDeEliminar.getLeftChild().getKey().equals(key)) {
            if(padreDeEliminar.getLeftChild().getLeftChild()!=null){
                Node<K, T> temp1 = padreDeEliminar.getLeftChild().getLeftChild();
                ultimo.setLeftChild(temp1);
                if(padreDeEliminar.getLeftChild().getRightChild()!=null){
                    Node<K, T> temp2 = padreDeEliminar.getLeftChild().getRightChild();
                    ultimo.setRightChild(temp2);
                }
            }
            padreDeEliminar.setLeftChild(ultimo);
        } else {
            if(padreDeEliminar.getRightChild().getLeftChild()!=null){
                Node<K, T> temp1 = padreDeEliminar.getRightChild().getLeftChild();
                ultimo.setLeftChild(temp1);
                if(padreDeEliminar.getRightChild().getRightChild()!=null){
                    Node<K, T> temp2 = padreDeEliminar.getRightChild().getRightChild();
                    ultimo.setRightChild(temp2);
                }
            }
            padreDeEliminar.setRightChild(ultimo);
        }
        if (padreDeUltimo.getRightChild() != null) padreDeUltimo.setRightChild(null);
        else {
            padreDeUltimo.setLeftChild(null);
        }
        ultimo = buscarultimo(root);
    }

    public Node<K, T> buscarultimo(Node<K, T> root) {
        ArrayList<Node<K,T>> ultimo = new ArrayList<>();
        ultimo.add(root);
        int i=0;
        while(i<ultimo.size()){
            if(ultimo.get(i).getLeftChild()!=null) {
                ultimo.add(ultimo.get(i).getLeftChild());
            }
            if(ultimo.get(i).getRightChild()!=null){
                ultimo.add(ultimo.get(i).getRightChild());
            }
            i=i+1;
        }
        return ultimo.get(ultimo.size()-1);
    }


    public Node<K, T> buscarPadre(Node<K, T> aux, K key) {
        Node<K, T> result = null;
        int continuar=1;
        if (aux != null) {
            if(aux.getRightChild()!=null) {
                if (aux.getRightChild().getKey().equals(key)) {
                    result = aux;
                    continuar = 0;
                }
            }
            if(aux.getLeftChild()!=null){
                if(aux.getLeftChild().getKey().equals(key)){
                    result = aux;
                    continuar = 0;
                }
            }
            if(continuar==1) {
                if (aux.getLeftChild() != null) {
                    result = buscarPadre(aux.getLeftChild(), key);
                }
                if (result == null && aux.getRightChild() != null) {

                    result = buscarPadre(aux.getRightChild(), key);
                }
            }
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

    public Node<K, T> getRoot() {
        return root;
    }
}
