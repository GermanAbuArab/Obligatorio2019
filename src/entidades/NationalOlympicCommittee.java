package entidades;

public class NationalOlympicCommittee {
    private String name ;
    private String region ;
    private int[] medallas;


    public int getMedallas() {
        int cantmedallas =medallas[0]+medallas[1]+medallas[2];
        return cantmedallas;
    }

    public int getMedallasOro() {
        int cantmedallas =medallas[0];
        return cantmedallas;
    }

    public int getMedallasPlata() {
        int cantmedallas =medallas[1];
        return cantmedallas;
    }

    public int getMedallasBronce() {
        int cantmedallas =medallas[2];
        return cantmedallas;
    }




    public NationalOlympicCommittee(String name, String region) {
        this.name = name;
        this.region = region;


        medallas = new int[3];
        medallas[0]=0;
        medallas[1]=0;
        medallas[2]=0;
    }

    public void sumarMedallaOro(){medallas[0]=medallas[0]+1;}
    public void sumarMedallaPlata(){medallas[1]=medallas[1]+1;}
    public void sumarMedallaBronce(){medallas[2]=medallas[2]+1;}

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
