package StackAndQueue;

import java.util.EmptyStackException;

class Stack {

    private Node top;
    private int length;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        int temp = top.data;
        top = top.next;
        length--;
        return temp;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

    }
}
