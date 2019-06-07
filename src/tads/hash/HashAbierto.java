package tads.hash;

import tads.hash.Extras.*;

import static java.lang.Math.abs;

public class HashAbierto<K, T> implements HashTable<K, T> {
    private ListaEnlazada[] hash;
    private int tamanio;

    public HashAbierto(int tamanio) {
        this.hash = new ListaEnlazada[tamanio];
        this.tamanio = tamanio;
    }

    public void insertar(T clave, K valor) throws ElementoYaExistenteException {
        int pos = clave.hashCode();
        pos = abs(pos % tamanio);
        if (hash[pos]==null){
            Nodo<K,T> nuevo = new Nodo<>(clave,valor);
            ListaEnlazada<K,T> temp = new ListaEnlazada<>(nuevo);
            hash[pos]= temp;
        }else{
            try {
                hash[pos].add(clave, valor);
            }catch (ElementoYaExistente e){
                throw new ElementoYaExistenteException();
            }
        }

    }

    public boolean pertenece(T clave) {
        int pos = clave.hashCode();
        pos = abs(pos % tamanio);
        if(hash[pos]==null){
            return false;
        }else{
            return hash[pos].existeElemento(clave);
        }
    }
    public K getValor(T clave) {
        int pos = clave.hashCode();
        pos = abs(pos % tamanio);
        if(hash[pos]==null){
            return null;
        }else{
            return (K) hash[pos].getElemento(clave);
        }
    }

    public void borrar(T clave) throws NoExisteElemento {
        int pos = clave.hashCode();
        pos = abs(pos % tamanio);
        if(hash[pos]==null){
            throw new NoExisteElemento();
        }else{
            try{
            hash[pos].remove(clave);
            } catch (ElementoNoExistente e){
                throw new NoExisteElemento();
            }
        }

    }
}
