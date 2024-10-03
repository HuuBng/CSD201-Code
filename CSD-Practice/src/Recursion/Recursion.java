package Recursion;

import java.util.Arrays;

class Recursion {

    // Sample 1:
    public static void sayHi(int count) {
        if (count < 5) {
            System.out.println(count + "-Hi");
            sayHi(count + 1);
        }
    }

    // Ex 1: num^pow
    public static double power(double num, double pow) {
        if (pow >= 1) {
            return power(num, pow - 1.0) * num;
        } else if (pow == 0) {
            return 1;
        }
        return 1 / power(num, pow * (-1.0));
    }

    // Ex 2: Factorial
    // n! = 1 * 2 * ... * n-1 * n
    public static int factorial(int num) {
        if (num > 0) {
            return factorial(num - 1) * num;
        } else if (num == 0) {
            return 1;
        } else
            return 0;
    }

    // Ex 3: Find sum of digits of a number
    // 756 -> 7 + 5 + 6 = 18
    public static int sumOfDigits(int number) {
        if (number > 0) {
            return number % 10 + sumOfDigits(number / 10);
        } else {
            return 0;
        }
    }

    // Ex 4 / Hw 01: Find max number of an array
    // Return int
    // DO NOT USE do...while(), for() or while() loop
    public static int findMaxNumArray(int[] arr, int index) {
        if (index < arr.length) {
            return Math.max(arr[index], findMaxNumArray(arr, index + 1));
        } else return 0;
    }

    // Hw 02: Check palindrome
    // Return true / false
    public static boolean isPalindrome(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            return true;
        }
        String result;
        result = reverse(input);
        return input.equalsIgnoreCase(result);
    }

    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    // Hw 03: Fibonacci at n
    // Value start at 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Index start at 0, 1, 2, 3, 4, 5, 6, 7, 8
    public static int fibo(int n) {
        return n < 2 ? n : fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(" ====== Sample 1 ======");
        sayHi(0);

        System.out.println(" ====== Ex 1 ======");
        System.out.println("2^3 = " + power(2, 3));

        System.out.println(" ====== Ex 2 ======");
        System.out.println("5! = " + factorial(5));

        System.out.println(" ====== Ex 3 ======");
        System.out.println("Sum digits of 518 -> " + sumOfDigits(518));

        System.out.println(" ====== Hw 1 ======");
        int[] arr = {5, 3, 2, 8, 9, 3, 5, 77, 43};
        System.out.println("Find max num of an array");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Max: " + findMaxNumArray(arr, 0));

        System.out.println(" ====== Hw 2 ======");
        System.out.println("Check palindrome ");
        System.out.println("madam -> " + isPalindrome("madam"));
        System.out.println("test -> " + isPalindrome("test"));
        System.out.println("hello -> " + isPalindrome("hello"));
        System.out.println("racecar -> " + isPalindrome("racecar"));

        System.out.println(" ====== Hw 03 ======");
        System.out.println("Find fibonacci value at n");
        System.out.println("n = 8 -> " + fibo(8));
    }
}
