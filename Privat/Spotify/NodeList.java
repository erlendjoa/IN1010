

public class NodeList<E> implements List<E>{
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
        while (head.next != null) {
            tempNode = tempNode.next; 
        }
        tempNode.next = newNode;
        newNode.prev = tempNode;
    }

    public E get(int index) {
        if (index > size()-1) {
            return null;
        }
        Node tempNode = head;
        for (int i = 1; i < size(); i++) {
            tempNode = tempNode.next;
        }
        return tempNode.element;
    }

    public E remove(int index) {
        if (index > size()-1) {
            return null;
        }
        Node tempNode = head;
        for (int i = 1; i < size(); i++) {
            tempNode = tempNode.next;
        }
        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;
        return tempNode.element;
    }

    public int size() {
        int counter = 1;
        Node tempNode = head;
        while (tempNode.next != null) {
            counter++;
            tempNode = tempNode.next;
        }
        return counter;
    }
}