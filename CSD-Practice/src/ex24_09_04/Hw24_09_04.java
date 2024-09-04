package ex24_09_04;

import java.util.Arrays;

public class Hw24_09_04 {

    // Hw 01: O(n) find second min / max
    public static int Hw_findSecMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i < min) {
                min = i;
            } else if (i < secMin) {
                secMin = i;
            }
        }

        System.out.println("Min: " + min);
        return secMin;
    }

    public static int Hw_findSecMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > max) {
                max = i;
            } else if (i > secMax) {
                secMax = i;
            }
        }

        System.out.println("Max: " + max);
        return secMax;
    }

    // Hw 02: Check if a String is a Palindrome or not
    public static void Hw_isPalindrome(String str) {
        String[] str_arr = str.split("");
        String[] result = new String[str_arr.length];

        for (int i = 0; i < str_arr.length; i++) {
            result[i] = str_arr[str_arr.length - 1 - i];
        }

        if (Arrays.equals(result, str_arr)) {
            System.out.println(str + " is Palindrome");
        } else {
            System.out.println(str + " is NOT Palindrome");
        }
    }

    // Hw 03: Move all zero to the back of an array
    public static int[] Hw_moveAllZero(int[] arr) {
        int[] result = new int[arr.length];
        int index = 0;

        for (int j : arr) {
            if (j != 0) {
                result[index] = j;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("\n === Homework 01 ===");
        int[] arr = {5, 3, 2, 8, 9, 3, 5, 77, 43, 22, 68, 12};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("SecMin: " + Hw_findSecMin(arr));
        System.out.println("SecMax: " + Hw_findSecMax(arr));

        System.out.println("\n === Homework 02 ===");
        Hw_isPalindrome("madam");
        Hw_isPalindrome("test");
        Hw_isPalindrome("hello");

        System.out.println("\n === Homework 03 ===");
        int[] arr2 = {8, 0, 5, 0, 2, 0, 0};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("MoveAllZero: " + Arrays.toString(Hw_moveAllZero(arr2)));

    }

}
