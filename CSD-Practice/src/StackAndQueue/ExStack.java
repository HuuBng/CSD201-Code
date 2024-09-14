package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class ExStack {

    /*
     Problem 1: Check parenthesis
     {[( )]} --> true
     {[( ])} --> false
     {[( )] --> false
    */
    public static boolean isValidParenthesis(String character) {
        String[] array = character.trim().replaceAll("[\\w\\s]+", "").split("");

        if (array.length == 1 || array.length == 0) {
            return true;
        }

        Stack<String> tmp = new Stack<>();
        for (String x : array) {
            if (x.equals("{") || x.equals("[") || x.equals("(")) {
                tmp.push(x);
            } else {
                if (tmp.isEmpty()) {
                    return false;
                } else {
                    if (x.equals(")") && tmp.peek().equals("(")
                            || x.equals("]") && tmp.peek().equals("[")
                            || x.equals("}") && tmp.peek().equals("{")) {
                        tmp.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return tmp.isEmpty();
    }

    /*
    Problem 2: reverse string using stack
     */
    public static String reverseString(String str) {
        String[] arr = str.trim().split("");

        Stack<String> tmp = new Stack<>();
        for (String x : arr) {
            tmp.push(x);
        }

        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str2.append(tmp.pop());
        }
        return str2.toString();
    }

    public static void main(String[] args) {
        String str = "{[(  )]}";
        String str2 = "{[(  ])}";
        String str3 = "{[(  )]} [()]";

        String str4 = "Hello";

        System.out.println(str + " - " + isValidParenthesis(str));
        System.out.println(str2 + " - " + isValidParenthesis(str2));
        System.out.println(str3 + " - " + isValidParenthesis(str3));

        System.out.println(str4 + " - " + reverseString(str4));
    }
}
