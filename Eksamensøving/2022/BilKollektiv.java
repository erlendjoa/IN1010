public class BilKollektiv {
    public int AB;
    public Bil[] alleBilene;
    public Bil hode;
    public Bil hale;

    public BilKollektiv(int AB) {
        this.AB = AB;
        alleBilene = new Bil[AB-1];
    }

    public void lagBilPris(Bil b) {
        // Legg til bil i alleBilene lista
        for (int i = 0; i < alleBilene.length; i++) {
            if (alleBilene[i] == null) {
                alleBilene[i] = b;
                break;
            }
        }

        // ved tom liste
        if (hode == null) {
            hode = b;
            hale = b;
        }

        // let etter riktig plass for b
        Bil tempBil = hode;
        while (tempBil.neste != null || b.pris > tempBil.pris) {
            tempBil = tempBil.neste;
        }
        b.neste = tempBil.neste;
        b.forrige = tempBil;
        tempBil.neste = b;
        if (b.neste == null) {
            hale = b;
        } else {
            b.neste.forrige = b;
        }
    }

    public Bil taUtBil(Bil b) {
        // Finn riktig bil
        Bil tempBil = hode;
        while (tempBil != b) {
            tempBil = tempBil.neste;
        }
        // Sjekk om bilen er hode og/eller hale
        if (tempBil == hode && tempBil == hale) {
            hode = null;
            hale = null;
        } else if (tempBil == hode) {
            hode = tempBil.neste;
            tempBil.neste.forrige = null;
        } else if (tempBil == hale) {
            hale = tempBil.forrige;
            tempBil.forrige.neste = null;
        } 
        // Om ikke: deklarer riktig forrige og neste
        else {
            tempBil.neste.forrige = tempBil.forrige;
            tempBil.forrige.neste = tempBil.neste;
        }
        return tempBil;
    }

    public Bil velgBil(Dialog d) {
        boolean vilHaElektrisk = false;
        if (d.svarJaEllerNei("Oensker du elbil?")) {
            vilHaElektrisk = true;
        }
        Bil tempBil = hode;
        while (tempBil.neste != null) {
            // Om bruker bare vil ha elektriske biler
            if (vilHaElektrisk) {
                if (tempBil instanceof Elektrisk) {
                    if (d.svarJaEllerNei("Oensker du aa kjope " + tempBil)) {
                        return taUtBil(tempBil);
                    }
                }
            // Om bruker er åpen for alle biler
            } else {
                if (d.svarJaEllerNei("Oensker du aa kjope " + tempBil)) {
                    return taUtBil(tempBil);
                }
            }
        }
        // vil aldri skje med beskrivelse gitt i oppgaveteksen
        return null;
    }

    public Bil velgBilR(Dialog d) {
        boolean vilHaElektrisk = false;
        if (d.svarJaEllerNei("Oensker du elbil?")) {
            vilHaElektrisk = true;
        }
        return hode.finnBilR(d, vilHaElektrisk);
    }
}
