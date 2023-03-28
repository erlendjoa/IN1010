

public class Prioritetskoe <E extends Comparable<E>> extends Lenkeliste<E> {
    
    @Override
    public void leggTil(E x) {
        Node nyNode = new Node(x);

        if (start == null) {    // går bare gjennom ved foerste element;
            start = nyNode;
            slutt = nyNode;
            return;

        } else if (x.compareTo(start.element) < 0) {
            nyNode.neste = start;
            start.forrige = nyNode;
            start = nyNode;
            return;
        
        } else if (x.compareTo(slutt.element) > 0) {
            nyNode.forrige = slutt;
            slutt.neste = nyNode;
            slutt = nyNode;
            return;
        }

        // loop sjekker .compareTo(x) == 0;

        Node peker = start;
        for (int i = 0; i < stoerrelse(); i++) {
            if (peker.element.compareTo(x) == 0) {
                nyNode.neste = peker.neste;
                nyNode.forrige = peker;
                peker.neste = nyNode;
                return;
            }
            if (peker.neste != null) {
                peker = peker.neste;
            }
        }

        System.out.println("Nå sjekkes: " + x);

        // loop sjekker peker.element < peker.neste.element;

        Node peker2 = start;
        for (int i = 0; i < stoerrelse(); i++) {
            if ((x.compareTo(peker2.element) < 0) || (peker2.element.compareTo(x) == 0)) {
                System.out.println(x + " gikk gjennom når pekers element var " + peker2.element + 
                ". Det betyr at " + x + " er mindre enn " + peker2.element);
                nyNode.neste = peker2.neste;
                nyNode.forrige = peker2;
                peker2.neste = nyNode;
                return;
            } 
            if (peker2.neste != null) {
                peker2 = peker2.neste;
            }
        }
    }
}