import java.util.ArrayList;

public class State {

    private String name;
    private ArrayList<County> counties;

    public State(String name){
        this.name = name;
        counties = new ArrayList<>();
    }

    public void add(County c){
        counties.add(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<County> getCounties() {
        return counties;
    }

    public void setCounties(ArrayList<County> counties) {
        this.counties = counties;
    }
}
