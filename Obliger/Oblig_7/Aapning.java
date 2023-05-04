

public class Aapning extends HvitRute {
    
    public Aapning(Rute[][] labyrint, int rad, int kol) {
        super(labyrint, rad, kol);
    }

    @Override
    public void finn(Rute fra) {
        System.out.println("(" + rad + ", " + kol + ")");
    }
}
