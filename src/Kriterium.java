import java.io.Serializable;

public class Kriterium implements Serializable {

    /*
        Problem: Wenn ein Wert gesetzt wird, der dem Default entspricht (z.B. sind nicht initialisierte
        ints standardmäßig 0), wird das Attribut beim Serialisieren übersprungen.

        Daher müssen wir nicht erreichbare Standardwerte setzen, sodass der Wert immer verarbeitet wird.
        (z.B. private int bewertung = -1)
     */

    private int bewertung = -1;
    private String name;
    private String tooltip;

    public Kriterium() {}

    public int getBewertung() {
        return this.bewertung;
    }

    public String getName() {
        return this.name;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public void setBewertung(int value) {
        this.bewertung = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public void init(int i) {
        setName("Kriterium #" + i);
        setTooltip("Dies ist ein Tooltip für Kriterium #" + i);
        setBewertung((int)Math.floor(Math.random() * 11));  // To reach 10 despite Math.floor()
    }
}