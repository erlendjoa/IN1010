

public abstract class Legemiddel {

    protected final String navn;
    protected int pris;
    protected final double virkestoff;

    public final int id;
    public static int teller = 0;

    public Legemiddel(String navn_, int pris_, double virkestoff_) {
        navn = navn_;
        pris = pris_;
        virkestoff = virkestoff_;

        id = teller;
        teller++;
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int nyPris) {
        pris = nyPris;
    }
    
    @Override
    public String toString() {
        return 
        "Navn: " + navn + "\n" + 
        "Pris: " + pris + "\n" + 
        "Virkestoff: " + virkestoff + "\n";
    }
}