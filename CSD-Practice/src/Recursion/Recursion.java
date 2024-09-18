package Recursion;

public class Recursion {

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

    // Hw 02: Check palindrome
    // Return true / false

    // Hw 03: Fibonacci at n
    // Value start at 0, 1, 1, 2, 3, 5, 8, 13
    // Index start at 1, 2, 3, 4, 5, 6, 7, 8

    public static void main(String[] args) {
        System.out.println(" ====== Sample 1 ======");
        sayHi(0);

        System.out.println(" ====== Ex 1 ======");
        System.out.println("2^3 = " + power(2, 3));

        System.out.println(" ====== Ex 2 ======");
        System.out.println("5! = " + factorial(5));

        System.out.println(" ====== Ex 3 ======");
        System.out.println("Sum digits of 518 -> " + sumOfDigits(518));

    }
}
