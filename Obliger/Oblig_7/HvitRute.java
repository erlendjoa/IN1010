import java.util.ArrayList;

public class HvitRute extends Rute {
    
    public HvitRute(Rute[][] labyrint, int rad, int kol) {
        super(labyrint, rad, kol);
    }

    @Override 
    public String toString() {
        return "hvit";
    }

    @Override
    public void finn(Rute fra, int rad, int kol) {
        provd = true;
        tuppel.add(new Tuppel(rad, kol));

        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i].provd != true) {

                // Nabo dupliserer this sin ArrayList<Tuppel>. 
                naboer[i].tuppel = new ArrayList<>(tuppel);

                // Nabo kjører sin finn().
                naboer[i].finn(this, naboer[i].rad, naboer[i].kol);
            }
        }
    }
}
