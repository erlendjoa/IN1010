public class Hvite extends Resept {
    
    public Hvite(Legemiddel middel, Lege utskrivendeLege, int pasientId, int reit) {
        super(middel, utskrivendeLege, pasientId, reit);
    }

    public String farge() {
        return "hvite";
    }

    public int prisAaBetale() {
        return middel.hentPris();
    }
}
