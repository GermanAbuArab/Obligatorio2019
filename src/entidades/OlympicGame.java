package entidades;

import java.util.ArrayList;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    private City ciudad;
    private ArrayList<Event> eventos;
    private ArrayList<AthleteOlympicParticipation> participaciones; // TODO hay que crear el game antes que la participacion y el evento

    public OlympicGame(String name, int year, SeasonType season, City ciudad) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.ciudad = ciudad;
        this.eventos = new ArrayList<Event>(40);

    }

    public void  agregarEvento(Event evento){
        if(!eventos.contains(evento)) {
            eventos.add(evento);
        }
        else
        {}

    }
    public ArrayList<Event> getEventos() {
        return eventos;
    }

    public void addEvento(Event evento){
        if(eventos.contains(evento)){

        }else{
            this.eventos.add(evento);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeason(SeasonType season) {
        this.season = season;
    }

    public void setCiudad(City ciudad) {
        this.ciudad = ciudad;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public SeasonType getSeason() {
        return season;
    }

    public City getCiudad() {
        return ciudad;
    }

}
