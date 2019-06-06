package tads.heap;

public interface Heap<K extends Comparable, T> {
void agregar(K key,T data);
NodeHeap<K,T> obtenerYEliminar();
long obtenerTamanio();
}
