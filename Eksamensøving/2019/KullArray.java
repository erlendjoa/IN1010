import java.util.Iterator;

public class KullArray extends Kull {

    Hund[][] hunder = new Hund[60][1];
    
    public KullArray(Hund mor, Hund far) {
        super(mor, far); 
    }

    public void settInn(Hund h) {
        int sek = h.minFodselstid.tid[5];
    }

    public Iterator<Hund> iterator() {
        return null;
    }
}
