package a4_40022733_40029417;

public class SalaryList {

    private class Node {

        private double data;
        private Node next;

        public Node() {
            data = 0.0;
            next = null;
        }

        public Node(double data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SalaryList() {
        head = null;
        tail = null;
        size = 0;
    }

    public SalaryList(double data) {
        tail = head = new Node(data, null);
        size = 1;
    }

    public void add(double data) {
        addToEnd(data);
    }

    public void addIndex(double data, int index) {
        if (index > size) {
            System.out.println("Out of range in list");
        } else if (size == 1) {
            addToStart(data);
        } else {
            Node temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(data, temp.next);
            temp = null;
            size++;
        }
    }

    public void addToStart(double data) {
        head = new Node(data, head);
        size++;
    }

    public void addToEnd(double data) {
        tail.next = new Node(data, null);
        tail = tail.next;
        size++;
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        if (size == 1 || head == null) {
            head = null;
        } else {
            Node temp = head;
            //fix for tail
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            temp = null;
        }
    }
    
    public void clear(){
        head = null;
    }

    public int getSize() {
        return size;
    }

    public int getIndex(double data) {
        Node temp = head;
        int counter = 0;
        for (int i = 0; i < size - 1; i++) {
            temp = head.next;
            if (data == temp.data) {
                temp = null;
                return counter;
            }
            counter++;
        }
        counter = -1;
        return counter;
    }

    public double getValue(int index) {
        if (index > size) {
            return -0;
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = head.next;
            }
            double x = temp.data;
            temp = null;
            return x;
        }
    }

    public double getFirstValue() {
        return head.data;
    }

    public double getLastValue() {
        return tail.data;
    }

}
