public class NodeList {

    Node head;
    int max;

    private class Node<E> {
        E element;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }
    }
    
    public NodeList(int max) {
        this.max = max
        
    }

}
