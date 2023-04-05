public class Subsekvens {

    public final String subskv;
    private int antall;

    public Subsekvens(String subskv, int antall) {
        this.subskv = subskv;
        this.antall = antall;
    }

    public String hentSubsekvens(){
        return subskv; }

    public int hentAntall() {
        return antall; }

    public void settAntall(int nyAntall) {
        antall = nyAntall;
    }

    public String toString() {
        return "( " + subskv + "," + antall + ")";
    }
}
