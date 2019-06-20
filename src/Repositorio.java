import entidades.*;
import tads.hash.Hash;

import java.util.ArrayList;

class Repositorio {
    private static Hash<NationalOlympicCommittee, String> hashNOC; //la key y la data estan al revez
    private static Hash<Athlete, Integer> hashAtleta;
    private static ArrayList<AthleteOlympicParticipation> listaParticip;
    private static Hash<OlympicGame, String> hashGames;
    private static Hash<Event, String> hashEventos;


    static void setHashGames(Hash<OlympicGame, String> hashGames) {
        Repositorio.hashGames = hashGames;
    }

    static void setListaParticip(ArrayList<AthleteOlympicParticipation> listaParticip) {
        Repositorio.listaParticip = listaParticip;
    }

    static Hash<Athlete, Integer> getHashAtleta() {
        return hashAtleta;
    }

    static void setHashAtleta(Hash<Athlete, Integer> hashAtleta) {
        Repositorio.hashAtleta = hashAtleta;
    }

    static Hash<NationalOlympicCommittee, String> getHashNOC() {
        return hashNOC;
    }

    static void setHashNOC(Hash<NationalOlympicCommittee, String> nOC) {
        hashNOC = nOC;
    }

    static ArrayList<AthleteOlympicParticipation> getParticip() {
        return listaParticip;
    }

    static Hash<OlympicGame, String> getHashGames() {
        return hashGames;
    }

    static Hash<Event, String> getHashEventos() {
        return hashEventos;
    }

    static void setHashEventos(Hash<Event, String> hashEventos) {
        Repositorio.hashEventos = hashEventos;
    }

}
