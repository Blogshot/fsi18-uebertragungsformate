import java.io.Serializable;
import java.util.ArrayList;

public class Evaluation implements Serializable {

    private ArrayList<Kriterium> kriterien = new ArrayList<>();

    public Evaluation() {
    }

    public Kriterium getKriterium(int position) {
        return kriterien.get(position);
    }

    public ArrayList<Kriterium> getKriterien() {
        return kriterien;
    }

    public void setKriterien(ArrayList<Kriterium> kriterien) {
        this.kriterien = kriterien;
    }

    public void addKriterium(Kriterium value) {
        this.kriterien.add(value);
    }
}
