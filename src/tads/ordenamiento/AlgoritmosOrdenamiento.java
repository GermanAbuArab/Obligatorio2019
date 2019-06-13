package tads.ordenamiento;

public class AlgoritmosOrdenamiento<K extends Comparable> {


    public K[] BubbleSort(K[] elementos) {
        int contador = elementos.length;
        for (int i = 0; i < elementos.length - 1; i++) {
            for (int j = 0; j < contador - 1; j++) {
                if (elementos[j].compareTo(elementos[j + 1]) == -1) {
                    K temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
            contador--;
        }
        return elementos;
    }

    public K[] BubbleSortParImpar(K[] elementos) {
        int contador = elementos.length;
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < elementos.length - 1; j = j + 2) {
                if (elementos[j].compareTo(elementos[j + 1]) == -1) {
                    K temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
            for (int h = 1; h < elementos.length - 1; h = h + 2) {
                if (elementos[h].compareTo(elementos[h + 1]) == -1) {
                    K temp = elementos[h];
                    elementos[h] = elementos[h + 1];
                    elementos[h + 1] = temp;
                }
            }
        }
        return elementos;
    }

    public K[] seleccion(K[] elementos) {
        int contador = elementos.length;
        for (int i = 0; i < contador; i++) {
            K temp = elementos[i];
            int pos = i;
            for (int j = i; j < contador; j++) {
                if (elementos[j].compareTo(elementos[i]) == -1
                        && elementos[j].compareTo(temp) == -1) {
                    temp = elementos[j];
                    pos = j;
                }
            }
            if (pos != i) {
                K temp2 = elementos[i];
                elementos[i] = temp;
                elementos[pos] = temp2;
            }
        }
        return elementos;
    }

    public K[] insercion(K[] elementos) {
        for (int i = 1; i < elementos.length; i++) {
            int pos = i;
            while (pos>0 && elementos[i].compareTo(elementos[pos - 1]) == 1) {
                pos = pos - 1;
            }
            K temp = elementos[pos];
            K temp2 = null;
            elementos[pos]=elementos[i];
            for(int h=pos+1;h<=i;h++){
                temp2=elementos[h];
                elementos[h]=temp;
                temp=temp2;
            }

        }

        return elementos;
    }


    public void imprimir(K[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            System.out.println(elementos[i]);
        }
    }
}
