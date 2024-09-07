package ex24_09_04;

import java.util.Arrays;

public class Array {

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Ex 01: remove even number from array
    public static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                oddCount++;
            }
        }

        int[] result = new int[oddCount];
        int idx = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                result[idx] = i;
                idx++;
            }
        }

        return result;
    }

    // Ex 02: reverse array
    public static int[] reverseArray(int[] arr) {
        int[] arrR = new int[arr.length];

        int indexMax = arr.length - 1;

        for (int i = indexMax; i >= 0; i--) {
            arrR[i] = arr[indexMax - i];
        }

        return arrR;
    }

    // Ex 03: find min / max number in the array
    public static int findMin(int[] arr) {
        // Should use Integer.MAX_VALUE instead of arr[0]
        int min = Integer.MAX_VALUE;

        for(int i : arr) {
            if(i < min) {
                min = i;
            }
        }

        return min;
    }

    public static int findMax(int[] arr) {
        // Should use Integer.MIN_VALUE instead of arr[0]
        int max = Integer.MIN_VALUE;

        for(int i : arr) {
            if(i > max) {
                max = i;
            }
        }

        return max;
    }

    // Ex 04: find second min / max number from array
    // Homework: O(n) find second min / max
    public static int findSecondMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i < min) {
                secMin = min;
                min = i;
            } else if (i < secMin && i != min) {
                secMin = i;
            }
        }

        System.out.println("Min: " + min);
        return secMin;
    }

    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > max) {
                secMax = max;
                max = i;
            } else if (i > secMax && i != max) {
                secMax = i;
            }
        }

        System.out.println("Max: " + max);
        return secMax;
    }

    // Hw 02: Check if a String is a Palindrome or not
    public static void checkPalindrome(String str) {
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
    public static int[] moveAllZeroes(int[] arr) {
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
        int[] arr = {5, 3, 2, 8, 9, 3, 5, 77, 43};

        System.out.print("Array: ");
        printArray(arr);

        System.out.println("\n === Ex 01 ===");
        System.out.print("Remove even: ");
        printArray(removeEven(arr));

        System.out.println("\n === Ex 02 ===");
        System.out.print("Reverse array: ");
        printArray(reverseArray(arr));

        System.out.println("\n === Ex 03 ===");
        System.out.println("Max: " + findMax(arr));
        System.out.println("Min: " + findMin(arr));

        System.out.println("\n === Ex 04 / Homework 01 ===");
        System.out.println("SecMin: " + findSecondMin(arr));
        System.out.println("SecMax: " + findSecondMax(arr));

        System.out.println("\n === Homework 02 ===");
        checkPalindrome("madam");
        checkPalindrome("test");
        checkPalindrome("hello");
        checkPalindrome("racecar");

        System.out.println("\n === Homework 03 ===");
        int[] arr2 = {8, 0, 5, 0, 2, 0, 0};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("MoveAllZero: " + Arrays.toString(moveAllZeroes(arr2)));

    }

}
