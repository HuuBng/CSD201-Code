package Sort;

import java.util.Arrays;

class Sorts {
    // time comp: O(n^2)
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapCount++;
                }
            }
            if (swapCount == 0) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // time comp: O(n^2)
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

    // time comp: O(n^2)
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] myArray = {10, 7, 20, 30, 38, 16, 18, 2, 40};

//        bubbleSort(myArray);
//        insertionSort(myArray);
        selectionSort(myArray);
        printArray(myArray);
    }
}
