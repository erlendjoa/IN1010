import java.util.Iterator;
import java.util.NoSuchElementException;

public class KullListe extends Kull {

    Hund foersteHund;
    
    public KullListe(Hund mor, Hund far) {
        super(mor, far);
    }

    public void settInn(Hund h) {
        Hund currentHund = foersteHund;

        if (currentHund == null) {
            foersteHund = h;
            return;
        }

        while (currentHund != null) {
            if (currentHund.compareTo(h) < 0 || currentHund.compareTo(h) == 0) {
                h.neste = currentHund.neste;
                currentHund.neste = h;
                return;
            }
            currentHund = currentHund.neste;
        }

        currentHund = h;
    }

    public Iterator<Hund> iterator() {
        return new HundeIterator<Hund>(foersteHund);
    }

    public class HundeIterator<Hund> implements Iterator<Hund> {
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


}
