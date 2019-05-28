package entidades;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;

    public OlympicGame(String name, int year, SeasonType season) {
        this.name = name;
        this.year = year;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SeasonType getSeason() {
        return season;
    }

    public void setSeason(SeasonType season) {
        this.season = season;
    }
}
