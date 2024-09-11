package LinkedList;

public class LinkedList {

    private ListNode head;

    public static class ListNode {

        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }

    }

    public void insertAtHead(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
    }

    public void insertAtPos(int value, int pos) {
        if (pos == 1) {
            this.insertAtHead(value);
            return;
        }
        if (pos > this.findLength() || pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        ListNode current = head;
        int count = 0;
        while (count < pos - 1) {
            current = current.next;
            count++;
        }
        ListNode newNode = new ListNode(value);
        newNode.next = current.next;
        current.next = newNode;

    }

    public void traversal() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ----> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int findLength() {
        int count = 0;
        ListNode current = head;
        while (current.next != null) {
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
        head = head.next;
    }

    public void removeAtEnd() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
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
        int count = 1;
        ListNode current = head;
        while (count < pos - 1) {
            current = current.next;
            count++;
        }

        current.next = current.next.next;
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        ListNode first = new ListNode(10);
        myList.head = first;

        ListNode second = new ListNode(20);
        ListNode third = new ListNode(23);
        ListNode fourth = new ListNode(145);

        first.next = second;
        second.next = third;
        third.next = fourth;

        myList.insertAtHead(2);
        myList.insertAtEnd(57);
        myList.insertAtPos(18, 4);
        
        myList.traversal();
        System.out.println("Length: " + myList.findLength());

        myList.removeAtEnd();
        myList.removeAtPos(6);
        myList.traversal();
        /* TODO: Làm Circular linked list (1 chiều, last.next = head) và doubly linked list (có head và tail, đi 2 chiều) */

    }

}
