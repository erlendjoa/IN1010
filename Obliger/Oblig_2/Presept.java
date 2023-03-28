public class Presept extends Hvite {

    public Presept(Legemiddel middel, Lege utskrivendeLege, int pasientId, int reit) {
        super(middel, utskrivendeLege, pasientId, reit);

        middel.pris -= 108;
        if (middel.pris < 0) {
            middel.pris = 0;
        }
    }
}

