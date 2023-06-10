public abstract class Inventar implements Comparable<Inventar> {
    
    String navn;
    int verdi;
    Inventar neste;

    public Inventar(String n, int v) {
        navn = n;
        verdi = v;
    }

    public int finnForsikringsverdi() {
        return verdi;
    }

    public int compareTo(Inventar inv) {
        return verdi - inv.verdi;
    }
}
