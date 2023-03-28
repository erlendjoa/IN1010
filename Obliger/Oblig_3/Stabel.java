public class Stabel<E> extends Lenkeliste<E> {

    @Override
    public void leggTil(E element) {

        Node nyNode = new Node(element);

        if (start == null) {
            start = nyNode;
            slutt = nyNode;

        } else {
            nyNode.neste = start;
            start.forrige = nyNode;
            start = nyNode;
        }
    }
}