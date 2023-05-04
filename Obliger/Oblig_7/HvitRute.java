

public class HvitRute extends Rute {
    
    public HvitRute(Rute[][] labyrint, int rad, int kol) {
        super(labyrint, rad, kol);
    }

    @Override 
    public String toString() {
        return "hvit";
    }

    @Override
    public void finn(Rute fra) {
        provd = true;
        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i].provd != true) {
                naboer[i].finn(this);
            }
        }
    }
}
