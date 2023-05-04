import java.util.ArrayList;

public abstract class Rute {

    public Rute[][] labyrint;
    public Rute[] naboer = new Rute[4];
    public int rad;
    public int kol;
    public boolean provd = false;
    public ArrayList<Tuppel> tuppel = new ArrayList<>();
    
    public Rute(Rute[][] labyrint, int rad, int kol) {
        this.labyrint = labyrint;
        this.rad = rad;
        this.kol = kol;
    }
    public abstract String toString();
    public abstract void finn(Rute fra, int rad, int kol);
}