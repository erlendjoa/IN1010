import java.util.Iterator;
import java.util.ArrayList;

public class KullListe extends Kull {

    ArrayList<Hund> liste;
    
    public KullListe(Hund mor, Hund far) {
        super(mor, far);
    }

    public void settInn(Hund h) {

        for (Hund valgtHund : liste) {
            if (h.minFodselstid.compareTo(valgtHund.minFodselstid) < 0) {
                h.neste = valgtHund.neste;
                valgtHund.neste = h;
            }
        }
    }
    public Iterator<Hund> iterator() {
        return iterator();
    }


}
