package entidades;

import java.util.ArrayList;

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

        aniosMaxYMin = new int[6];
        aniosMaxYMin[0] = 0; //MIN ORO
        aniosMaxYMin[1] = 0; //MAXX ORO
        aniosMaxYMin[2] = 0;  //MIN PLATA
        aniosMaxYMin[3] = 0;  //MAX PLATA
        aniosMaxYMin[4] = 0;  //MIN BRONCE
        aniosMaxYMin[5] = 0;  //MAX BRONCE
        medallas = new int[3];
        medallas[0] = 0;
        medallas[1] = 0;
        medallas[2] = 0;

    }

    public void cambiarAnio(int anio,MedalType medalType) {
        if (medalType.equals(MedalType.BRONZE)) {
            if (aniosMaxYMin[4] > anio || aniosMaxYMin[4]==0) {
                aniosMaxYMin[4] = anio;
            }
            if (aniosMaxYMin[5] < anio) {
                aniosMaxYMin[5] = anio;
            }
        } else if (medalType.equals(MedalType.SILVER)) {
            if (aniosMaxYMin[2] > anio || aniosMaxYMin[2]==0) {
                aniosMaxYMin[2] = anio;
            }
            if (aniosMaxYMin[3] < anio) {
                aniosMaxYMin[3] = anio;
            }
        } else if (medalType.equals(MedalType.GOLD)) {
            if (aniosMaxYMin[0] > anio || aniosMaxYMin[0]==0) {
                aniosMaxYMin[0] = anio;
            }
            if (aniosMaxYMin[1] < anio) {
                aniosMaxYMin[1] = anio;
            }

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

    public int getAnioMaximoB() {
        int temp = aniosMaxYMin[5];
        return temp;
    }

    public int getAnioMinimoB() {
        int temp = aniosMaxYMin[4];
        return temp;
    }
    public int getAnioMaximoP() {
        int temp = aniosMaxYMin[3];
        return temp;
    }

    public int getAnioMinimoP() {
        int temp = aniosMaxYMin[2];
        return temp;
    }
    public int getAnioMaximoO() {
        int temp = aniosMaxYMin[1];
        return temp;
    }

    public int getAnioMinimoO() {
        int temp = aniosMaxYMin[0];
        return temp;
    }
    public int getAnioMaximo() {
        int temp = aniosMaxYMin[1];
        if(temp<aniosMaxYMin[3]){
            temp=aniosMaxYMin[3];
        }
        if(temp<aniosMaxYMin[5]){
            temp=aniosMaxYMin[5];
        }
        return temp;
    }

    public int getAnioMinimo() {
        int temp = aniosMaxYMin[0];
        if(temp>aniosMaxYMin[2]){
            temp=aniosMaxYMin[2];
        }
        if(temp>aniosMaxYMin[4]){
            temp=aniosMaxYMin[4];
        }
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

