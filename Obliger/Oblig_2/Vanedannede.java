public class Vanedannede extends Legemiddel {
    
    final int styrke;
    
    public Vanedannede(String navn, int pris, double virkestoff, int id, int styrke_) {
        super(navn, pris, virkestoff);
        styrke = styrke_;
    }
}
