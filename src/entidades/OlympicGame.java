package entidades;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    private City ciudad;
    private Event evento;

    public OlympicGame(String name, int year, SeasonType season, City ciudad, Event evento) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.ciudad = ciudad;
        this.evento = evento;
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

    public void setEvento(Event evento) {
        this.evento = evento;
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

    public Event getEvento() {
        return evento;
    }
}
