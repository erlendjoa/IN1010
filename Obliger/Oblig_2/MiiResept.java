public class MiiResept extends Hvite {
    
    public MiiResept(Legemiddel middel_, Lege utskrivendeLege_, int pasientId_) {
        
        super(middel_, utskrivendeLege_, pasientId_, 3);
        middel.settNyPris(0);
        
    }
}
