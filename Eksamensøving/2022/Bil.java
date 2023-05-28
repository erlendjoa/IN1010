public abstract class Bil {
    public String bilnummer;
    public int pris;
    public Bil neste;
    public Bil forrige;

    public Bil(String bilnummer, int pris) {
        this.bilnummer = bilnummer;
        this.pris = pris;
    }

    public Bil finnBilR(Dialog dialog, boolean kunElektrisk) {
        // Om bil kun skal være elektrisk
        if (kunElektrisk) {
            if (this instanceof Elektrisk) {
                if (dialog.svarJaEllerNei("Oensker du aa laane " + this)) {
                    return this;
                }
            }
        // Om bil ikke trenger være elektrisk
        } else {
            if (dialog.svarJaEllerNei("Oensker du aa laane " + this)) {
                return this;
            }
        }
        return neste.finnBilR(dialog, kunElektrisk);
    }

    @Override
    public String toString() {
        return "\nBilnummer: " + bilnummer + "\nPris: " + pris;
    }
}
