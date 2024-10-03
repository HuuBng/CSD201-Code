package LinkedList;

class DoublyLinkedList {

    private Node head;

    public static class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void traversal() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        System.out.print("null <---- ");


        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <----> ");
            }
            current = current.next;
        }
        System.out.print(" ----> null");
        System.out.println();
    }

    public int findLength() {
        int count = 0;
        Node current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
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
            count++;
            current = current.next;
        }

        Node newNode = new Node(data);

        newNode.next = current.next;
        current.next = newNode;
        newNode.prev = current;
        newNode.next.prev = newNode;

    }

    public void removeAtHead() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        head = head.next;
        head.prev = null;
    }

    public void removeAtEnd() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current = current.prev;
        current.next = null;
    }

    public void removeAtPos(int pos) {
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
        }

        int count = 0;
        Node current = head;
        while (count < pos - 1) {
            current = current.next;
            count++;
        }

        current.next = current.next.next;
        current.next.prev = current;
    }

    public static void main(String[] args) {
        // TODO: Test

        DoublyLinkedList myList = new DoublyLinkedList();

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
//        myList.removeAtPos(2);

        myList.traversal();
        System.out.println("Length: " + myList.findLength());
    }
}
