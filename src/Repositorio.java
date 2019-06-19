import entidades.*;
import tads.hash.Hash;

import java.util.ArrayList;

public class Repositorio {
    static Hash<NationalOlympicCommittee, String> hashNOC; //la key y la data estan al revez
    static Hash<Athlete, Integer> hashAtleta;
    static ArrayList<AthleteOlympicParticipation> listaParticip;
    static Hash<OlympicGame, String> hashGames;
    static Hash<Event, String> hashEventos;



    public static void setHashGames(Hash<OlympicGame, String> hashGames) {
        Repositorio.hashGames = hashGames;
    }

    public static void setListaParticip(ArrayList<AthleteOlympicParticipation> listaParticip) {
        Repositorio.listaParticip = listaParticip;
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

    public static ArrayList<AthleteOlympicParticipation> getParticip() {
        return listaParticip;
    }

    public static Hash<OlympicGame, String> getHashGames() {
        return hashGames;
    }


    public static Hash<Event, String> getHashEventos() {
        return hashEventos;
    }

    public static void setHashEventos(Hash<Event, String> hashEventos) {
        Repositorio.hashEventos = hashEventos;
    }


}
