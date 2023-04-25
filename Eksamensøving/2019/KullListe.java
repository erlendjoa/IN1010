import java.util.Iterator;
import java.util.NoSuchElementException;

public class KullListe extends Kull {

    private Hund foersteHund;
    
    public KullListe(Hund mor, Hund far) {
        super(mor, far);
    }

    public void settInn(Hund h) {
        if (foersteHund == null) {
            foersteHund = h;
            return;
        }

        for (Hund currentHund : this) {
            if (currentHund.neste != null) {
                if (currentHund.neste.compareTo(h) < 0 || currentHund.neste.compareTo(h) == 0) {
                    h.neste = currentHund.neste;
                    currentHund.neste = h;
                    return;
                }
            } 
            else {
                System.out.println("la til " + h.navn + " som siste");
                currentHund.neste = h;  // Maybe return statement after?
            }
            currentHund = currentHund.neste;
        }
    }

    public Iterator<Hund> iterator() {
        return new HundeIterator<Hund>(foersteHund);
    }

    
    private class HundeIterator<E> implements Iterator<Hund> {
        Hund hund;

        public HundeIterator(Hund foersteHund) {
            this.hund = foersteHund;
        }

        @Override
        public boolean hasNext() {
            return hund != null;
        }

        public Hund next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Hund tempHund = hund;
            hund = hund.neste;
            return tempHund;
        }
    }

    public String toString() {
        String s = "";
        for (Hund hund : this) {
            s += hund.navn + " | ";
        }
        return s;
    }


    public static void main(String[] args) {
        KullListe kull = new KullListe(null,null);
        Hund mor = new Hund(kull, "mother", new Tidspunkt(0, 0, 0, 0, 0, 0));
        Hund far = new Hund(kull, "father", new Tidspunkt(0, 0, 0, 0, 0, 0));

        KullListe nyttKull = new KullListe(mor, far);
        Hund son1 = new Hund(nyttKull, "Erlend", new Tidspunkt(1, 0, 0, 0, 0, 0));
        Hund son2 = new Hund(nyttKull, "Markus", new Tidspunkt(4, 0, 0, 0, 0, 0));
        Hund son3 = new Hund(nyttKull, "Patrick", new Tidspunkt(3, 0, 0, 0, 0, 0));
        Hund son4 = new Hund(nyttKull, "Noah", new Tidspunkt(10, 0, 0, 0, 0, 0));
        Hund daughter1 = new Hund(nyttKull, "Linn", new Tidspunkt(8, 0, 0, 0, 0, 0));
        // Erlend, Patrick, Markus, Linn, Noah

        nyttKull.settInn(son1);
        nyttKull.settInn(son2);
        nyttKull.settInn(son3);
        nyttKull.settInn(son4);
        nyttKull.settInn(daughter1);

        System.out.println(nyttKull);

    }


}
