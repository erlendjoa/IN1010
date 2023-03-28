

public class ElektriskBil extends Bil {
    private int batteri = 0;

    public ElektriskBil(String regNr_, String merke_, String modell_, double hastighet_) {
        super(regNr_, merke_, modell_, hastighet_);
    }

    public int hentBatteri() {
        return batteri;
    }

    public void lade(int strom) {
        batteri += strom;
    }
}
