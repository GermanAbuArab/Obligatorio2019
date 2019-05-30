package entidades;

public class AthleteOlympicParticipation {
    private MedalType medal;
    private Athlete atleta;
    private Event evento;
    private OlympicGame juegoOlimpico;

    public AthleteOlympicParticipation(MedalType medal, Athlete atleta, Event evento, OlympicGame juegoOlimpico) {
        this.medal = medal;
        this.atleta = atleta;
        this.evento = evento;
        this.juegoOlimpico = juegoOlimpico;

        if (medal == null) {
        } else if (medal.equals(MedalType.GOLD)) {
            atleta.sumarMedallaOro();
        } else if (medal.equals(MedalType.SILVER)) {
            atleta.sumarMedallaPlata();
        } else if (medal.equals(MedalType.BRONZE)) {
            atleta.sumarMedallaBronce();
        }


    }

    public MedalType getMedal() {
        return medal;
    }

    public Athlete getAtlteta() {
        return atleta;
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
        this.atleta = atlteta;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public void setJuegoOlimpico(OlympicGame juegoOlimpico) {
        this.juegoOlimpico = juegoOlimpico;
    }
}
