public class Blaa extends Resept{

    public Blaa(Legemiddel middel, Lege utskrivendeLege, int pasientId, int reit) {
        super(middel, utskrivendeLege, pasientId, reit);
    }

    public String farge() {
        return "blaa";
    }

    public int prisAaBetale() {
        int rabattPris = (int) Math.round((middel.pris /= 4));
        return rabattPris;
    }
}
