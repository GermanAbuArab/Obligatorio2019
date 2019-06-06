package tads.heap;

public class HeapImpl<K extends Comparable, T> implements Heap<K,T> {
    private NodeHeap[] heap; //maximo
    private int lastPosition;
    private int tipoHeap;


    public HeapImpl(int tamanio,int i) {
        NodeHeap[] temp = new NodeHeap[tamanio];
        heap=temp;
        tipoHeap=i;
        lastPosition=0;
    }

    public void agregar(K key, T data) {
        NodeHeap<K,T> nuevo = new NodeHeap<>(key,data);
        heap[lastPosition]=nuevo;
        if(lastPosition==0){
            lastPosition++;
        }else{
            int continuar=1;
            int auxPosHijo=lastPosition;
            int auxPosPadre=(auxPosHijo-1)/2;
            while(continuar==1) {
                if(heap[auxPosHijo].getKey().compareTo(heap[auxPosPadre].getKey())==-1*tipoHeap){
                    lastPosition++;
                    continuar=0;
                }
                if((heap[auxPosHijo].getKey().compareTo(heap[auxPosPadre].getKey())==1*tipoHeap)){
                    NodeHeap<K,T> padre = heap[auxPosPadre];
                    heap[auxPosPadre]=heap[auxPosHijo];
                    heap[auxPosHijo]=padre;
                    auxPosHijo=auxPosPadre;
                    if(auxPosHijo!=0){
                        auxPosPadre=(auxPosHijo-1)/2;
                    }else{
                        continuar=0;
                        lastPosition++;
                    }
                }
            }
        }

    }

    public NodeHeap<K,T> obtenerYEliminar() {
        NodeHeap<K,T> devolver = heap[0];
        heap[0]=heap[lastPosition-1];
        heap[lastPosition-1]=null;
        lastPosition=lastPosition-1;
        int continuar=1;
        int auxPosPadre=0;
        int auxPosHijo1=2*auxPosPadre+1;
        int auxPosHijo2=2*auxPosPadre+2;
        while(continuar==1) {
            if(auxPosHijo1>lastPosition-1 || auxPosHijo2>lastPosition-1){
                if(auxPosHijo1>lastPosition-1 && auxPosHijo2>lastPosition-1){
                    continuar=0;
                }
                else{
                    if(auxPosHijo1>lastPosition-1){
                        auxPosHijo1=auxPosHijo2;
                    }
                    else if(auxPosHijo2>lastPosition-1){
                        auxPosHijo2=auxPosHijo1;
                    }
                }
            }
            else if (heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo1].getKey()) == 1*tipoHeap
                    || heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo1].getKey()) == 0){
                if(heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo2].getKey()) == 1*tipoHeap
                        || heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo2].getKey()) == 0){
                    continuar=0;
                }
            }
            else if (heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo1].getKey()) == -1*tipoHeap
                    && heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo2].getKey()) == -1*tipoHeap){
                if(heap[auxPosHijo1].getKey().compareTo(heap[auxPosHijo2].getKey()) == -1*tipoHeap){
                    NodeHeap<K,T> padre = heap[auxPosPadre];
                    heap[auxPosPadre]=heap[auxPosHijo2];
                    heap[auxPosHijo2]=padre;
                    auxPosPadre=auxPosHijo2;
                    auxPosHijo2=2*auxPosHijo2+2;
                }else{
                    NodeHeap<K,T> padre = heap[auxPosPadre];
                    heap[auxPosPadre]=heap[auxPosHijo1];
                    heap[auxPosHijo1]=padre;
                    auxPosPadre=auxPosHijo1;
                    auxPosHijo1=2*auxPosHijo1+1;
                }
            }
            else if (heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo1].getKey()) == -1*tipoHeap) {
                NodeHeap<K,T> padre = heap[auxPosPadre];
                heap[auxPosPadre]=heap[auxPosHijo1];
                heap[auxPosHijo1]=padre;
                auxPosPadre=auxPosHijo1;
                auxPosHijo1=2*auxPosHijo1+1;
            }
            else if (heap[auxPosPadre].getKey().compareTo(heap[auxPosHijo2].getKey()) == -1*tipoHeap) {
                NodeHeap<K,T> padre = heap[auxPosPadre];
                heap[auxPosPadre]=heap[auxPosHijo2];
                heap[auxPosHijo2]=padre;
                auxPosPadre=auxPosHijo2;
                auxPosHijo2=2*auxPosHijo2+2;
            }
        }
        return devolver;
    }

    public long obtenerTamanio() {
        return lastPosition;
    }

    public void mostrarItems(){
        for(int i=0;i<lastPosition;i++){
            System.out.println(heap[i].getKey());
        }
    }
}
