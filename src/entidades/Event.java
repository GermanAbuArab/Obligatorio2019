package entidades;

public class Event {
    private String name;
    private Sport deporte;

    public Event(String name, Sport deporte) {
        this.name = name;
        this.deporte = deporte;
    }
    //override
    public boolean equals(Event e){
      boolean temp=false;
        if(this.deporte.equals(e.deporte) && this.name.equals(e.name)) temp=true;
    return temp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeporte(Sport deporte) {
        this.deporte = deporte;
    }

    public String getName() {
        return name;
    }

    public Sport getDeporte() {
        return deporte;
    }
}
