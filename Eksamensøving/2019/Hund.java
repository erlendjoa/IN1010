

public class Hund implements Comparable<Hund> {
    public String navn;
    public Kull mittKull;
    public Tidspunkt minFodselstid;
    public Hund neste = null;

    public Hund(Kull k, String navn, Tidspunkt fodt) {
        this.navn = navn;
        mittKull = k;
        minFodselstid = fodt;
    }

    @Override
    public int compareTo(Hund h) {
        return minFodselstid.compareTo(h.minFodselstid);
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

    public void finnEldsteKjenteOpphav() {
        // Rekursjon
    }
    
}
