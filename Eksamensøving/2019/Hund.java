public class Hund implements Comparable<Hund>{
    String navn;
    Kull mittKull;
    Tidspunkt minFodselstid;
    Hund neste = null;

    public Hund(Kull k, String navn, Tidspunkt fodt) {
        this.navn = navn;
        mittKull = k;
        minFodselstid = fodt;
    }

    @Override
    public int compareTo(Hund h) {
        return h.minFodselstid.compareTo(minFodselstid);
    }

    public Hund mor() {
        return mittKull.mor;
    }

    public Hund far() {
        return mittKull.far;
    }

    public boolean erHelsosken(Hund h) {
        return (h.mor() == mor() && h.far() == far());
    }

    public boolean erHalvsosken(Hund h) {
        return (h.mor() == mor() || h.far() == far());
    }

    public Hund finnEldsteKjenteOpphav() {
        // Rekursjon
    }
}
