package entidades;

public class Athlete {
    private long id;
    private String name;
    private SexType sex;
    private float height;
    private float weight;
    private Team team;
    private NationalOlympicCommittee NatOlimpic;
    private int[] medallas;
    private int[] aniosMaxYMin;


    public boolean equals(Athlete comp) {
        boolean temp = false;
        if (this.id == comp.getId()) temp = true;
        return temp;

    }


    public Athlete(long id, String name, SexType sex, float height, float weight, Team team, NationalOlympicCommittee natOlimpic) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.team = team;
        NatOlimpic = natOlimpic;

        aniosMaxYMin = new int[2];
        aniosMaxYMin[0] = 0;
        aniosMaxYMin[1] = 0;
        medallas = new int[3];
        medallas[0] = 0;
        medallas[1] = 0;
        medallas[2] = 0;

    }

    public void cambiarAnio(int anio) {

        if (aniosMaxYMin[0] > anio || aniosMaxYMin[0]==0) {
            aniosMaxYMin[0] = anio;
        }
        if (aniosMaxYMin[1] < anio) {
            aniosMaxYMin[1] = anio;
        }

    }

    public void sumarMedallaOro() {
        medallas[0] = medallas[0] + 1;
    }

    public void sumarMedallaPlata() {
        medallas[1] = medallas[1] + 1;
    }

    public void sumarMedallaBronce() {
        medallas[2] = medallas[2] + 1;
    }

    public int getMedallas() {
        int cantmedallas = medallas[0] + medallas[1] + medallas[2];
        return cantmedallas;
    }

    public int getMedallasOro() {
        int cantmedallas = medallas[0];
        return cantmedallas;
    }

    public int getMedallasPlata() {
        int cantmedallas = medallas[1];
        return cantmedallas;
    }

    public int getMedallasBronce() {
        int cantmedallas = medallas[2];
        return cantmedallas;
    }

    public int getAnioMaximo() {
        int temp = aniosMaxYMin[1];
        return temp;
    }

    public int getAnioMinimo() {
        int temp = aniosMaxYMin[0];
        return temp;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SexType getSex() {
        return sex;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public Team getTeam() {
        return team;
    }

    public NationalOlympicCommittee getNatOlimpic() {
        return NatOlimpic;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setNatOlimpic(NationalOlympicCommittee natOlimpic) {
        NatOlimpic = natOlimpic;
    }


}

