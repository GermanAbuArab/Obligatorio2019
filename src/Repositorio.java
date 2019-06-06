import entidades.Athlete;
import entidades.NationalOlympicCommittee;
import tads.heap.Heap;
import tads.hash.HashAbierto;

public class Repositorio {
    Heap<Integer, Athlete> medallasOro;
    Heap<Integer, Athlete> medallasPlata;
    Heap<Integer, Athlete> medallasBronce;
    Heap<Integer, Athlete> medallas;
}
