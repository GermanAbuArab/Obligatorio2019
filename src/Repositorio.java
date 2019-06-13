import entidades.*;
import tads.hash.Hash;
import tads.heap.Heap;
import tads.hash.HashAbierto;

public class Repositorio {
    static Hash<NationalOlympicCommittee, String> hashNOC; //la key y la data estan al revez
    static Hash<Athlete, Integer> hashAtleta;
    static Hash<AthleteOlympicParticipation, Athlete> hashParticip;
    static Hash<OlympicGame, String> hashGames;

//    static Heap<Integer, Athlete> medallasOro;
//    static Heap<Integer, Athlete> medallasPlata;
//    static Heap<Integer, Athlete> medallasBronce;
//    static Heap<Integer, Athlete> medallas;
//    static Heap<Integer, RegionPorMedalla> medallasOroReg;
//    static Heap<Integer, RegionPorMedalla> medallasPlataReg;
//    static Heap<Integer, RegionPorMedalla> medallasBronceReg;
//    static Heap<Integer, RegionPorMedalla> medallasReg;


    public static void setHashGames(Hash<OlympicGame, String> hashGames) {
        Repositorio.hashGames = hashGames;
    }

    public static Hash<Athlete, Integer> getHashAtleta() {
        return hashAtleta;
    }

    public static void setHashAtleta(Hash<Athlete, Integer> hashAtleta) {
        Repositorio.hashAtleta = hashAtleta;
    }

    public static Hash<NationalOlympicCommittee, String> getHashNOC() {
        return hashNOC;
    }

    public static void setHashNOC(Hash<NationalOlympicCommittee, String> nOC) {
        hashNOC = nOC;
    }

    public static Hash<AthleteOlympicParticipation, Athlete> getHashParticip() {
        return hashParticip;
    }

    public static void setHashParticip(Hash<AthleteOlympicParticipation, Athlete> hashParticip) {
        Repositorio.hashParticip = hashParticip;
    }

//    public static Heap<Integer, Athlete> getMedallasOro() {
//        return medallasOro;
//    }
//
//    public static void setMedallasOro(Heap<Integer, Athlete> medallasOro) {
//        medallasOro = medallasOro;
//    }
//
//    public static Heap<Integer, Athlete> getMedallasPlata() {
//        return medallasPlata;
//    }
//
//    public static void setMedallasPlata(Heap<Integer, Athlete> medallasPlata) {
//        medallasPlata = medallasPlata;
//    }
//
//    public static Heap<Integer, Athlete> getMedallasBronce() {
//        return medallasBronce;
//    }
//
//    public static void setMedallasBronce(Heap<Integer, Athlete> medallasBronce) {
//        medallasBronce = medallasBronce;
//    }
//
//    public static Heap<Integer, Athlete> getMedallas() {
//        return medallas;
//    }
//
//    public static void setMedallas(Heap<Integer, Athlete> medallas) {
//        medallas = medallas;
//    }
//
//    public static Heap<Integer, RegionPorMedalla> getMedallasOroReg() {
//        return medallasOroReg;
//    }
//
//    public static void setMedallasOroReg(Heap<Integer, RegionPorMedalla> medallasOroReg) {
//        medallasOroReg = medallasOroReg;
//    }
//
//    public static Heap<Integer, RegionPorMedalla> getMedallasPlataReg() {
//        return medallasPlataReg;
//    }
//
//    public static void setMedallasPlataReg(Heap<Integer, RegionPorMedalla> medallasPlataReg) {
//        medallasPlataReg = medallasPlataReg;
//    }
//
//    public static Heap<Integer, RegionPorMedalla> getMedallasBronceReg() {
//        return medallasBronceReg;
//    }
//
//    public static void setMedallasBronceReg(Heap<Integer, RegionPorMedalla> medallasBronceReg) {
//        medallasBronceReg = medallasBronceReg;
//    }
//
//    public static Heap<Integer, RegionPorMedalla> getMedallasReg() {
//        return medallasReg;
//    }

//    public static void setMedallasReg(Heap<Integer, RegionPorMedalla> medallasReg) {
//        medallasReg = medallasReg;
//    }

}
