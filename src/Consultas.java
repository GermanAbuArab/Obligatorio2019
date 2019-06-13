import entidades.*;
import tads.hash.Hash;
import tads.hash.NodoHash;
import tads.heap.Heap;
import tads.heap.HeapImpl;
import tads.heap.NodeHeap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consultas {


    public static void consultaUno(int tipo) {
        NodoHash<Athlete, Integer>[] temp = Repositorio.getHashAtleta().getHash();
        if (tipo == 1) {

            HeapImpl<Integer, Athlete> medallasOro =new HeapImpl<>(150000,1) ;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasOro.agregar(temp[i].getValor().getMedallasOro(), temp[i].getValor());
                }
            }
        } else if (tipo == 2) {
            HeapImpl<Integer, Athlete> medallasPlata =new HeapImpl<>(150000,1) ;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasPlata.agregar(temp[i].getValor().getMedallasPlata(), temp[i].getValor());
                }
            }
        }else if (tipo == 3) {
            HeapImpl<Integer, Athlete> medallasBronce =new HeapImpl<>(150000,1) ;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasBronce.agregar(temp[i].getValor().getMedallasBronce(), temp[i].getValor());
                }
            }
        }
        else if (tipo == 4) {
            HeapImpl<Integer, Athlete> medallas =new HeapImpl<>(150000,1) ;
            for (int i = 0; i < temp.length-1; i++) {
                if (temp[i] != null) {
                    medallas.agregar(temp[i].getValor().getMedallas(), temp[i].getValor());
                }
            }
            for(int i=0;i<10;i++){
                Athlete athlete=medallas.obtenerYEliminar().getData();
                System.out.println("Nombre: "+ athlete.getName()+""+ athlete.getMedallas()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        }


    }

}
