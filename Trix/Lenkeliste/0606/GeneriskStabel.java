

public class GeneriskStabel<E> {

    Node hode;
    
    private class Node {
        E element;
        Node neste;
        public Node(E e) {
            element = e;
        }
    }

    public void leggPaa(E e) {
        Node nyNode = new Node(e);
        nyNode.neste = hode;
        hode = nyNode;
    }
    public E taAv() throws NullPointerException {
        Node tempNode = hode;
        hode = hode.neste;
        return tempNode.element;
    }
    public boolean erTom() {
        return hode == null;
    }
}
