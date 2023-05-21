

public class Butikk {

    Person hode;

    public void entreButikk(Person p) {
        if (hode == null) {
            hode = p;
            return;
        }
        Person tempP = hode;
        while (tempP.neste != null)  {
            tempP = tempP.neste;
        }
        tempP.neste = p;
    }

    public void kassa() {
        while (hode != null) {
            System.out.println(hode.navn + " kjøper " + hode.gjenstand + ".");
            System.out.println("Hade bra!");
            hode = hode.neste;
        }
    }
}