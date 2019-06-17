import entidades.*;
import tads.hash.NodoHash;
import tads.heap.HeapImpl;


public class Consultas {


    public static void consultaUno(int tipo) {
        NodoHash<Athlete, Integer>[] temp = Repositorio.getHashAtleta().getHash();
        if (tipo == 1) {

            HeapImpl<Integer, Athlete> medallasOro = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasOro.agregar(temp[i].getValor().getMedallasOro(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasOro.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas oro: "
                        + athlete.getMedallasOro() + " - Año minimo: " + athlete.getAnioMinimo() + " - Año maximo: " + athlete.getAnioMaximo()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        } else if (tipo == 2) {
            HeapImpl<Integer, Athlete> medallasPlata = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasPlata.agregar(temp[i].getValor().getMedallasPlata(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasPlata.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas plata: "
                        + athlete.getMedallasPlata() + " - Año minimo: " + athlete.getAnioMinimo() + " - Año maximo: " + athlete.getAnioMaximo()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }

        } else if (tipo == 3) {
            HeapImpl<Integer, Athlete> medallasBronce = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasBronce.agregar(temp[i].getValor().getMedallasBronce(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasBronce.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas bronce: "
                        + athlete.getMedallasBronce() + " - Año minimo: " + athlete.getAnioMinimo() + " - Año maximo: " + athlete.getAnioMaximo()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        } else if (tipo == 4) {
            HeapImpl<Integer, Athlete> medallas = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallas.agregar(temp[i].getValor().getMedallas(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallas.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas: "
                        + athlete.getMedallas() + " - Año minimo: " + athlete.getAnioMinimo() + " - Año maximo: " + athlete.getAnioMaximo()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        }


    }

}
