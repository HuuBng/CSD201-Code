package ex24_09_07;

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
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
    }

    public void insertAtPos(int value, int pos) {
        if (pos == 1) {
            insertAtHead(value);
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
        ListNode current = head;
        while (current.next != null) {
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

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        ListNode first = new ListNode(10);
        myList.head = first;

        ListNode second = new ListNode(20);
        ListNode third = new ListNode(23);
        ListNode fourth = new ListNode(12);

        first.next = second;
        second.next = third;
        third.next = fourth;

        myList.insertAtHead(2);
        myList.insertAtEnd(57);
        myList.insertAtPos(18, 4);

        myList.traversal();
        System.out.println("Length: " + myList.findLength());
    }

}
