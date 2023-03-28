public class Narkotika extends Legemiddel {

    final int styrke;
    
    public Narkotika(String navn, int pris, double virkestoff, int id, int styrke_) {
        super(navn, pris, virkestoff);
        styrke = styrke_;
    }
}

