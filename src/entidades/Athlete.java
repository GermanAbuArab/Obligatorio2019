package entidades;

public class Athlete {

    private long id;
    private String name;
    private SexType sex;
    private float height;
    private float weight;
    private Team team;
    private NationalOlympicCommittee NatOlimpic;

    public Athlete(long id, String name, SexType sex, float height, float weight, Team team, NationalOlympicCommittee natOlimpic) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.team = team;
        NatOlimpic = natOlimpic;
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
