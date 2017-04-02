package a4_40022733_40029417;

public class EmployeeList {

    private class Node {

        private Employee data;
        private Node next;

        public Node() {
            data =null;
            next = null;
        }

        public Node(Employee data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public EmployeeList() {
        head = null;
        tail = null;
        size = 0;
    }

    public EmployeeList(Employee data) {
        tail = head = new Node(data, null);
        size = 1;
    }

    public void add(Employee data) {
        if (size == 0) {
            tail = head = new Node(data, null);
            size = 1;
        } else {
            addToEnd(data);
        }
    }

    public void addIndex(Employee data, int index) {
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

    public void addToStart(Employee data) {
        head = new Node(data, head);
        size++;
    }

    public void addToEnd(Employee data) {
        tail.next = new Node(data, null);
        tail = tail.next;
        size++;
    }

    public void removeFirst() {
        head = head.next;
        size--;
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
        size--;
    }

    public void clear() {
        head = null;
    }

    public int getSize() {
        return size;
    }

    public int getIndex(Employee data) {
        Node temp = head;
        int counter = 0;
        for (int i = 0; i < size - 1; i++) {
            temp = head.next;
            if (data.equals(temp.data)) {
                temp = null;
                return counter;
            }
            counter++;
        }
        counter = -1;
        return counter;
    }

    public Employee getValue(int index) {
        if (index > size) {
            return null;
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Employee x = temp.data;
            temp = null;
            return x;
        }
    }

    public Employee getFirstValue() {
        return head.data;
    }

    public Employee getLastValue() {
        return tail.data;
    }

}


