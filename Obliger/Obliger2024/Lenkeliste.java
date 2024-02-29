public class Lenkeliste<E> implements Liste<E> {
    Node hode;
    Node hale;
    
    protected class Node {
        E e;
        Node forrige;
        Node neste;
        
        public Node(E e) {
            this.e = e;
        }
    }
    

    public void leggTil(E x) {
        Node nyNode = new Node(x);

        if (hale == null) {
            hode = nyNode;
            hale = nyNode;
            return;
        }
        nyNode.forrige = hale;
        hale.neste = nyNode;
        hale = nyNode;
    }

    public E hent() {
        return hode.e;
    }

    public E fjern() {
        if (stoerrelse() == 1) {
            E valgtE = hode.e;
            hale = null;
            hode= null;
            return valgtE;
        }
        E valgtE = hode.e;
        hode = hode.neste;
        return valgtE;
    }

    public int stoerrelse() {
        int teller = 0;
        if (hode == null) {
            return teller;
        }
        Node current = hode;
        while (current != null) {
            teller++;
            current = current.neste;
        }
        return teller;
    }

    @Override
    public String toString() {
        return "";
    }
}
