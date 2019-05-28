package entidades;

public class AthleteOlympicParticipation {
    private MedalType medal;


    public AthleteOlympicParticipation(MedalType medal) {
        this.medal = medal;
    }

    public MedalType getMedal() {
        return medal;
    }

    public void setMedal(MedalType medal) {
        this.medal = medal;
    }
}
