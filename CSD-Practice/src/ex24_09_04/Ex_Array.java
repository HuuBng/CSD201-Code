package ex24_09_04;

import java.util.Arrays;

public class Ex_Array {

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
    public static int findSecMin(int[] arr) {
        int min = findMin(arr);

        int secMin = Integer.MAX_VALUE;

        for(int i : arr) {
            if (i > min && i < secMin) {
                secMin = i;
            }
        }

        return secMin;
    }

    public static int findSecMax(int[] arr) {
        int max = findMax(arr);

        int secMax = Integer.MIN_VALUE;

        for(int i : arr) {
            if (i < max && i > secMax) {
                secMax = i;
            }
        }

        return secMax;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 9, 3, 5, 77, 43};

        System.out.print("Array: ");
        printArray(arr);

        System.out.println("\n === Ex1 ===");
        System.out.print("Remove even: ");
        printArray(removeEven(arr));

        System.out.println("\n === Ex2 ===");
        System.out.print("Reverse array: ");
        printArray(reverseArray(arr));

        System.out.println("\n === Ex3 ===");
        System.out.println("Max: " + findMax(arr));
        System.out.println("Min: " + findMin(arr));

        System.out.println("\n === Ex4 ===");
        System.out.println("SecMin: " + findSecMin(arr));
        System.out.println("SecMax: " + findSecMax(arr));

    }

}
