

public abstract class Lenkeliste<E> implements Liste<E> {
    protected Node start;
    protected Node slutt;

    protected class Node {
        Node forrige;
        Node neste;
        E element;

        public Node(E x) {
            element = x;
        }
    }


    public void leggTil(E x) {
        Node nyNode = new Node(x);

        if (slutt == null) {
            slutt = nyNode;
            start = nyNode;
            return;
        }

        nyNode.forrige = slutt;
        slutt.neste = nyNode;
        slutt = nyNode;
        
    }

    public E hent() {
        return start.element;
    }

    public E fjern() {
        
        if (start == null) {
            throw new UgyldigListeindeks(stoerrelse());
        }

        if (stoerrelse() == 1) {
            E valgtE = start.element;
            slutt = null;
            start = start.neste;
            return valgtE;
        }

        E valgtE = start.element;
        System.out.println(toString());
        start = start.neste;
        return valgtE;
    }

    public int stoerrelse() {
        int teller = 0;
        if (start == null) {
            return teller;
        }

        Node peker = start;
        while (peker.neste != null) {
            peker = peker.neste;
            teller++;
        }
        teller++;
        return teller;
    }


    public String toString(){
        String s = "";
        
        int teller = 0;
        Node peker = start;
        while (teller < stoerrelse()) {
            s += teller + ": " + peker.element + "\n";
            teller++;
            peker = peker.neste;
        }
        return s;
    }
}
