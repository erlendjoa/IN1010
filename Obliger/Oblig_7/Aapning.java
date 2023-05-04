

public class Aapning extends HvitRute {
    
    public Aapning(Rute[][] labyrint, int rad, int kol) {
        super(labyrint, rad, kol);
    }

    @Override
    public void finn(Rute fra, int rad, int kol) {
        System.out.println("\nAapning paa: (" + rad + ", " + kol + ")");
        for (Tuppel tp : tuppel) {
            System.out.print("(" + tp.rad + ", " + tp.kol + ") ");
        }
    }
}
