package entidades;

public class RegionPorMedalla {
    private String region;
    private int[] medallas;

    public RegionPorMedalla(String region) {
        this.region = region;
        medallas = new int[3];
        medallas[0]=0;
        medallas[1]=0;
        medallas[2]=0;
    }
}
