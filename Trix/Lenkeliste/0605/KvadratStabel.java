

public class KvadratStabel {

    Node hode;
    
    private class Node {
        Kvadrat element;
        Node neste;
        public Node(Kvadrat k) {
            element = k;
        }
    }

    public void leggPaa(Kvadrat k) {
        Node nyNode = new Node(k);
        nyNode.neste = hode;
        hode = nyNode;
    }
    public Kvadrat taAv() throws NullPointerException {
        Node tempNode = hode;
        hode = hode.neste;
        return tempNode.element;
    }
    public boolean erTom() {
        return hode == null;
    }
}
