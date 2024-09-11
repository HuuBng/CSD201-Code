package LinkedList;

public class CircularLinkedList {

    private Node head;

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
    }

    public void insertAtPos(int data, int pos) {
        if (pos == 1) {
            this.insertAtHead(data);
            return;
        }
        if (pos > this.findLength() || pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == this.findLength()) {
            this.insertAtEnd(data);
        }
        Node current = head;
        int count = 0;
        while (count < pos - 1) {
            current = current.next;
            count++;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void traversal() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + " ----> ");
            current = current.next;
        }
        System.out.print(current.data + " --|--> " + current.next.data);
        System.out.println();
    }

    public int findLength() {
        int count = 0;
        Node current = head;
        while (current.next != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void removeAtHead() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = head.next;
        head = head.next;
    }

    public void removeAtEnd() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current.next.next != head) {
            current = current.next;
        }
        current.next = head;
    }

    public void removeAtPos(int pos) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (pos == 1) {
            this.removeAtHead();
            return;
        }
        if (pos > this.findLength() || pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == this.findLength()) {
            this.removeAtEnd();
            return;
        }

        int count = 1;
        Node current = head;
        while (count < pos - 1) {
            current = current.next;
            count++;
        }

        current.next = current.next.next;
    }

    public static void main(String[] args) {
        // TODO: test everything

        CircularLinkedList myList = new CircularLinkedList();

        myList.insertAtHead(10);
        myList.insertAtHead(20);
        myList.insertAtHead(30);

        myList.traversal();
        System.out.println("Length: " + myList.findLength());

        myList.insertAtEnd(40);
        myList.insertAtEnd(50);

        myList.traversal();
        System.out.println("Length: " + myList.findLength());

        myList.insertAtPos(60, 3);

        myList.traversal();
        System.out.println("Length: " + myList.findLength());

        myList.removeAtHead();

        myList.traversal();
        System.out.println("Length: " + myList.findLength());

        myList.removeAtEnd();

        myList.traversal();
        System.out.println("Length: " + myList.findLength());

        myList.removeAtPos(2);
        myList.removeAtPos(2);

        myList.traversal();
        System.out.println("Length: " + myList.findLength());
    }
}
