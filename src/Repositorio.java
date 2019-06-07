import entidades.Athlete;
import entidades.NationalOlympicCommittee;
import entidades.RegionPorMedalla;
import tads.heap.Heap;
import tads.hash.HashAbierto;

public class Repositorio {
    Heap<Integer, Athlete> medallasOro;
    Heap<Integer, Athlete> medallasPlata;
    Heap<Integer, Athlete> medallasBronce;
    Heap<Integer, Athlete> medallas;
    Heap<Integer, RegionPorMedalla> medallasOroReg;
    Heap<Integer, RegionPorMedalla> medallasPlataReg;
    Heap<Integer, RegionPorMedalla> medallasBronceReg;
    Heap<Integer, RegionPorMedalla> medallasReg;

}
