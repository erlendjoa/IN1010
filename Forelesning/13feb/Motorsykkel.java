

public class Motorsykkel extends Kjoretoy{
    protected final int antHjul = 2;

    public Motorsykkel(String regNr_, String merke_, String modell_, double hastighet_) {
        super(regNr_, merke_, modell_, hastighet_);
    }

    public void skrivUt() {
        System.out.println(modell);
    }
}
