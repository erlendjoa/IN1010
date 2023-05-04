

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

    public Hund finnEldsteKjenteOpphav() {
        if (mor() == null && far() == null) {
            return this;
        }
        Hund farKull = null;
        Hund morKull = null;

        if (mor() == null && far() != null) {
            farKull = far().finnEldsteKjenteOpphav();
        }
        if (mor() != null && far() == null) {
            morKull = mor().finnEldsteKjenteOpphav();
        }
        
        if (far() == null) return mor();
        if (mor() == null) return far();
        if (morKull.compareTo(farKull) == 1) {
            return morKull;
        } else { return farKull; }
    }
    
}
