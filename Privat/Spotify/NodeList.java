import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeList<E> implements List<E>, Iterable<E> {
    Node head;
    int currentSize = 0;

    private class Node {
        protected Node next;
        protected Node prev;
        protected E element;

        public Node(E element) {
            this.element = element;
        }
    }

    public void add(E e) {
        Node newNode = new Node(e);
        currentSize++;

        if (head == null) {
            head = newNode;
            return; 
        }
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next; 
        }
        tempNode.next = newNode;
        newNode.prev = tempNode;
    }

    public E get(int index) {
        if (index > currentSize) {
            return null;
        }
        Node tempNode = head;
        for (int i = 1; i <= index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.element;
    }

    public E remove(int index) {
        if (index > currentSize) {
            return null;
        }
        Node tempNode = head;
        for (int i = 1; i <= index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;
        currentSize--;
        return tempNode.element;
    }

    /* 
    public int size() {
        int counter = 1;
        Node tempNode = head;
        if (tempNode == null) {
            return 0; }
        if (tempNode.next == null) {
            return 1; }
        while (tempNode.next != null) {
            counter++;
            tempNode = tempNode.next;
        }
        return counter;
    }
    */

    public boolean contains(E parameterElement) {
        for (E currentElement : this) {
            if (currentElement.equals(parameterElement)) {
                return true;
            }
        }
        return false;
    }


    public Iterator<E> iterator() {
        return new NodeIterator<E>(this);
    }

    private class NodeIterator<E> implements Iterator<E> {

        NodeList<E> nodeList;
        int counter;

        public NodeIterator(NodeList<E> nodeList) {
            this.nodeList = nodeList;
            counter = 0;
        }

        @Override
        public boolean hasNext() {
            return counter < nodeList.currentSize;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            counter++;
            return nodeList.get(counter);
        }
    }
}