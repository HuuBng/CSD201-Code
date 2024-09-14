package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ExQueue {

    public static String[] printBinary(int n) {
        Queue<String> queue = new LinkedList<>();
        String[] result = new String[n];

        queue.offer("1"); //enqueue
        for (int i = 0; i < n; i++) {
            result[i] = queue.poll(); //dequeue
            String left = result[i] + "0";
            String right = result[i] + "1";
            queue.offer(left);
            queue.offer(right);
        }
        return result;
    }


    public static void main(String[] args) {
        String[] result = printBinary(7);
        for (String s : result) {
            System.out.println(s);
        }

    }
}
