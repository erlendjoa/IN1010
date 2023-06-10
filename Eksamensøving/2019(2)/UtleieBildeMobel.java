public class UtleieBildeMobel extends UtleieInventar implements Bilde, Mobel {
    
    public UtleieBildeMobel(String n, int v, String f) {
        super(n, v, f);
    }

    public int bredde() {
        return 0;
    }
    public int areal() {
        return 0;
    }
}
