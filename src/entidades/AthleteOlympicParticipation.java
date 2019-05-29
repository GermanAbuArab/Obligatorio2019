package entidades;

public class AthleteOlympicParticipation {
    private MedalType medal;
    private Athlete atlteta;
    private Event evento;
    private OlympicGame juegoOlimpico;

    public AthleteOlympicParticipation(MedalType medal, Athlete atlteta, Event evento, OlympicGame juegoOlimpico) {
        this.medal = medal;
        this.atlteta = atlteta;
        this.evento = evento;
        this.juegoOlimpico = juegoOlimpico;
    }

    public MedalType getMedal() {
        return medal;
    }

    public Athlete getAtlteta() {
        return atlteta;
    }

    public Event getEvento() {
        return evento;
    }

    public OlympicGame getJuegoOlimpico() {
        return juegoOlimpico;
    }

    public void setMedal(MedalType medal) {
        this.medal = medal;
    }

    public void setAtlteta(Athlete atlteta) {
        this.atlteta = atlteta;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public void setJuegoOlimpico(OlympicGame juegoOlimpico) {
        this.juegoOlimpico = juegoOlimpico;
    }
}
