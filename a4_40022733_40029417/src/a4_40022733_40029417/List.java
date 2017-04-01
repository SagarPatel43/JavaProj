//Missing several special cases
package a4_40022733_40029417;

public class List {

    private class Node {

        private double data;
        private Node next;

        Node() {
            data = 0.0;
            next = null;
        }

        Node(double data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(double data) {
            this.data = data;
        }

        public void setNode(Node next) {
            this.next = next;
        }

        public double getData() {
            return data;
        }

        public Node getNode() {
            return next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    public List(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public double getFirstValue() {
        return head.data;
    }

    public double getLastValue() {
        return tail.data;
    }

    public void addToStart(int v) {
        head = new Node(v, head);
        size++;
    }

    public void addToEnd(int v) {
        if (head == null) {
            addToStart(v);
        } else {
            tail.next = new Node(v, null);
            tail = tail.next;
        }
        size++;
    }

    public void add(int v) {
        addToEnd(v);
    }

    public void addAtIndex(int v, int index) {
        Node t = head;
        for (int i = 1; i < index; i++) {
            t = t.next;
        }
        t = new Node(v, t);
        t = null;
        size++;
    }

    //Probably unneccesary
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int counter = 0;
            Node t = head;
            while (t.next != null) {
                counter++;
                t = t.next;
            }
            t = null;
            return counter;
        }
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        Node t = head;
        while (t.next.next != null) {
            t = t.next;
        }
        tail = t;
        t = null;
    }

}
