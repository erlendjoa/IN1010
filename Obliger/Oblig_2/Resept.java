public abstract class Resept {
    
    protected Legemiddel middel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;
    
    public Resept(Legemiddel middel_, Lege utskrivendeLege_, int pasientId_, int reit_) {

        middel = middel_;
        utskrivendeLege = utskrivendeLege_;
        pasientId = pasientId_;
        reit = reit_;

    }

    public int hentId() {
        return middel.id;
    }

    public Legemiddel hentLegemiddel() {
        return middel;
    }

    public Lege hentLege() {
        return utskrivendeLege;
    }

    public int hentPasientId() {
        return pasientId;
    }

    public int hentReit() {
        return reit;
    }


    public boolean bruk() {
        if (reit != 0) {
            reit -= 1;
            return true;
        }
        return false;
    }

    abstract public String farge();
    abstract public int prisAaBetale();


    @Override
    public String toString() {
        return "Pasient ID: " + pasientId + "\nLegemiddel: " + middel.navn + "\nReit: " + reit + "\n";
    }
}
