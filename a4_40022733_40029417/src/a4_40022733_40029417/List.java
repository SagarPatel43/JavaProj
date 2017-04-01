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

    public List(double data) {
        head = tail = new Node(data, null);
        size = 1;
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

    public void addToStart(double v) {
        head = new Node(v, head);
        size++;
    }

    public void addToEnd(double v) {
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

    public void addAtIndex(double v, int index) {
        if (index > size) {
            System.out.println("Index is out of range");
        } else if (size == 1) {
            addToStart(v);
        } else {
            Node t = head;
            for (int i = 1; i < index - 1; i++) {
                t = t.next;
            }
            t.next = new Node(v, t.next);
            t = null;
            size++;
        }
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
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            head = null;
        } else {
            Node t = head;
            while (t.next.next != null) {
                t = t.next;
            }
            tail = t;
            t.next = null;
            t = null;
            size--;
        }
    }

    public void clear() {
        head = null;
    }

    public int getIndex(double data) {
        Node t = head;
        int index = 1;
        while (t != null) {
            if (t.data == data) {
                return index;
            } else {
                t = t.next;
                index++;
            }
        }
        return -1;
    }

    public double getValue(int index) {
        if (index > size) {
            return 0;
        } else {
            Node t = head;
            int counter = 1;
            double x = 0;
            while (t != null) {
                if (counter == index) {
                    x = t.data;
                } else {
                    t = t.next;
                    counter++;
                }
            }
            t = null;
            return x;

        }

    }
}
