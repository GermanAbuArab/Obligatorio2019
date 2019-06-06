package tads.hash;

public interface HashTable<K,T> {
    public void insertar (T clave, K valor) throws ElementoYaExistenteException;
    public boolean pertenece (T clave);
    public void borrar (T clave) throws NoExisteElemento;
}
