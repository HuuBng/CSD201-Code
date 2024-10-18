
package Search;

import java.util.Arrays;

public class Search {

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {5, 10, 7, 14, 21, 20, 68, 70, 65};
        int[] sortedArray = {5, 10, 12, 15, 20, 26, 30, 51};

        int target = 22;

        int result1 = linearSearch(array, target);
        if (result1 != -1) {
            System.out.println("Number " + target + " found at position " + result1);
        } else {
            System.out.println("Number " + target + " NOT found");
        }

        int result2 = binarySearch(sortedArray, target);
        if (result2 != -1) {
            System.out.println("Number " + target + " found at position " + result2);
        } else {
            System.out.println("Number " + target + " NOT found");
        }

        int result3 = searchInsert(sortedArray, target);
        System.out.println("Index for " + target + " is at position " + result3);
    }
}
