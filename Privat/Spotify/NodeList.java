import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeList<E> implements List<E>, Iterable<E> {
    Node head;

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
        if (index >= size()) {
            return null;
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.element;
    }

    public E remove(int index) {
        if (index+1 > size()) {
            return null;
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;
        return tempNode.element;
    }

    public int size() {
        int currentCounter = 0;
        Node tempNode = head;
        if (tempNode == null) {
            return 0; }
        if (tempNode.next == null) {
            return 1; }
        while (tempNode.next != null) {
            currentCounter++;
            tempNode = tempNode.next;
        }
        return currentCounter;
    }

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
            return counter < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E tempElement = nodeList.get(counter);
            counter++;
            return tempElement;
        }
    }
}