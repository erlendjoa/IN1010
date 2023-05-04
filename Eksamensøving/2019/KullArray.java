import java.util.Iterator;

public class KullArray extends Kull {

    Hund[] hunder = new Hund[60];

    public KullArray(Hund mor, Hund far) {
        super(mor, far);
    }

    public void settInn(Hund h) {
        int hSek = h.minFodselstid.tid[5];
        if (hunder[hSek] == null) {
            hunder[hSek] = h;
        }
        else {
            Hund currentHund = hunder[hSek];
            if (currentHund.neste == null) {
                currentHund.neste = h;
                return;
            }
            while (currentHund.neste != null) {
              currentHund = currentHund.neste;
            }
            currentHund.neste = h;
        }

    }

    public Iterator<Hund> iterator() {
        return null;
    }

    public void skrivUtAlle() {
        for (Hund hund : hunder) {
            Hund tempHund = hund;
            while (tempHund != null) {
                System.out.println(tempHund.navn);
                tempHund = tempHund.neste;
            }
        }
    }


    public static void main(String[] args) {
        KullArray kull = new KullArray(null,null);
        Hund mor = new Hund(kull, "mother", new Tidspunkt(0, 0, 0, 0, 0, 0));
        Hund far = new Hund(kull, "father", new Tidspunkt(0, 0, 0, 0, 0, 0));

        KullArray nyttKull = new KullArray(mor, far);
        Hund son1 = new Hund(nyttKull, "Erlend", new Tidspunkt(1, 0, 0, 0, 0, 5));
        Hund son2 = new Hund(nyttKull, "Markus", new Tidspunkt(4, 0, 0, 0, 0, 4));
        Hund son3 = new Hund(nyttKull, "Patrick", new Tidspunkt(3, 0, 0, 0, 0, 8));
        Hund son4 = new Hund(nyttKull, "Noah", new Tidspunkt(10, 0, 0, 0, 0, 4));
        Hund daughter1 = new Hund(nyttKull, "Linn", new Tidspunkt(8, 0, 0, 0, 0, 4));

        nyttKull.settInn(son1);
        nyttKull.settInn(son2);
        nyttKull.settInn(son3);
        nyttKull.settInn(son4);
        nyttKull.settInn(daughter1);

        nyttKull.skrivUtAlle();
      }
}
