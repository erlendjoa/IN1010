

public class Bil extends Kjoretoy {

    public Bil(String regNr_, String merke_, String modell_, double hastighet_) {
        super(regNr_, merke_, modell_, hastighet_);
    }

    public void skrivUt() {
        System.out.println(modell);
    }
}
