package tads.hash;

import static java.lang.Math.abs;

public class Hash<K, T> implements HashTable<K, T> {
    public NodoHash<K, T>[] hash;
    private long tamanio;
    private long cantElementos;

    public Hash(int tamanio) {
        this.hash = new NodoHash[tamanio];
        this.tamanio = tamanio;
        this.cantElementos = 0;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void insertar(T clave, K valor) throws ElementoYaExistenteException {
        int pos = clave.hashCode();
        pos = abs(pos % (int) tamanio);
        NodoHash<K, T> temp = new NodoHash<K, T>(valor, clave, false);
        int vuelta = 1;
        int continuar = 1;
        int cantColisiones = 1;
        while (continuar == 1) {
            if (hash[pos] == null) {
                cantElementos++;
                hash[pos] = temp;
                continuar = 0;
            } else if (hash[pos].getClave().equals(clave) || hash[pos].isRemoved()) {
                if (hash[pos].getClave().equals(clave)) {
                    if (hash[pos].isRemoved()) {
                        cantElementos++;
                        hash[pos].setRemoved(false);
                    } else {
                        throw new ElementoYaExistenteException();
                    }
                } else {
                    hash[pos] = temp;
                    cantElementos++;
                }
                continuar = 0;
            }

            pos = pos + getNextPosition(cantColisiones);

            if (pos > tamanio - 1) {
                if (vuelta == 0) {
                    continuar = 0;
                }
                pos = pos - (int) tamanio;
                vuelta = 0;
            }

            cantColisiones = cantColisiones + 1;
        }
        if ((float) cantElementos / tamanio > 0.7) {
            agrandarTam(hash);
        }
    }

    private void agrandarTam(NodoHash<K, T>[] hash) {
        long aBuscarPrimo = tamanio * 2;
        boolean continuar = true;
        while (continuar) {
            if (esPrimo(aBuscarPrimo)) {
                continuar = false;
            } else {
                aBuscarPrimo++;
            }
        }
        NodoHash<K, T>[] temp = new NodoHash[(int) aBuscarPrimo];
        for (int i = 0; i < tamanio; i++) {
            temp[i] = hash[i];
        }
        this.tamanio = aBuscarPrimo;
        this.hash = temp;
    }

    private static boolean esPrimo(long numero) {
        long contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) primo = false;
            contador++;
        }
        return primo;
    }

    private int getNextPosition(int cantColisiones) {
        cantColisiones = cantColisiones;
        return cantColisiones;
    }

    public boolean pertenece(T clave) {
        boolean pertenece = false;
        int pos = clave.hashCode();
        pos = abs(pos % (int) tamanio);
        int continuar;
        int colisiones = 0;
        int vuelta = 1;
        if (hash[pos] == null) {
            return pertenece;
        } else {
            continuar = 1;
        }
        while (continuar == 1) {
            if (hash[pos].getClave().equals(clave)) {
                if (hash[pos].isRemoved()) {
                    pertenece = false;
                    continuar = 0;
                } else {
                    pertenece = true;
                    continuar = 0;
                }
            } else {
                colisiones = colisiones + 1;
                pos = pos + getNextPosition(colisiones);
                if (pos > tamanio - 1) {
                    if (vuelta == 0) {
                        continuar = 0;
                    }
                    pos = pos - (int) tamanio;
                    vuelta = 0;
                }
                if (hash[pos] == null) {
                    pertenece = false;
                    continuar = 0;
                }
            }
        }
        return pertenece;
    }

    public long getCantElementos() {
        return cantElementos;
    }

    public void borrar(T clave) throws NoExisteElemento {
        int pos = clave.hashCode();
        pos = abs(pos % (int) tamanio);
        int continuar;
        int colisiones = 0;
        int vuelta = 1;
        boolean existe = false;
        if (hash[pos] == null) {
            throw new NoExisteElemento();
        } else {
            continuar = 1;
        }
        while (continuar == 1) {
            if (hash[pos].getClave().equals(clave)) {
                if (hash[pos].isRemoved()) {
                    throw new NoExisteElemento();
                }
                hash[pos].setRemoved(true);
                cantElementos--;
                existe = true;
                continuar = 0;
            } else {
                colisiones = colisiones + 1;
                pos = pos + getNextPosition(colisiones);
                if (pos > tamanio - 1) {
                    if (vuelta == 0) {
                        continuar = 0;
                    }
                    pos = pos - (int) tamanio;
                    vuelta = 0;
                }
                if (hash[pos] == null) {
                    continuar = 0;
                }
            }
        }
        if (existe == false) {
            throw new NoExisteElemento();
        }
    }
}
