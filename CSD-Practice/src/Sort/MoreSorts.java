package Sort;

import java.util.Arrays;

public class MoreSorts {
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int r = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[r] = arr1[i++];
            } else {
                result[r] = arr2[j++];
            }
            r++;
        }

        // Append remaining element
        while (i < arr1.length) {
            result[r] = arr1[i++];
            r++;
        }

        while (j < arr2.length) {
            result[r] = arr2[j++];
            r++;
        }

        return result;
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Length of arr1
        int n2 = right - mid; // Length of arr2

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0;
        int j = 0;
        int r = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arr[r] = leftArray[i++];
            } else {
                arr[r] = rightArray[j++];
            }
            r++;
        }

        // Append remaining element
        while (i < leftArray.length) {
            arr[r] = leftArray[i++];
            r++;
        }

        while (j < rightArray.length) {
            arr[r] = rightArray[j++];
            r++;
        }
    }

    // Time comp: O(n1 log n)
    // Divide: log n
    // Sort: n1
    public static void mergeSort(int[] arr, int left, int right) {
        // Has 2 or more elements
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid); // Left array
            mergeSort(arr, mid + 1, right); // Right array

            merge(arr, left, mid, right);
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int j = left - 1;
        for (int i = left; i <= right; i++) {
            if (arr[i] <= pivot) {
                j++;
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return j;
    }

    // Time comp: O(n log n)
    public static void quickSort(int[] arr, int left, int right) {
        // Has 2 or more elements
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1); // Left of pivot
            quickSort(arr, pivotIndex + 1, right); // Right of pivot
        }
    }

    // Heap Sort
    // Time comp: o(n log n)


    // Packet Sort
    // Time comp: O(n)

    // Radix Sort
    // Time comp: O(n)

    public static void main(String[] args) {
//        int[] arr1 = {1, 3, 5, 6, 7};
//        int[] arr2 = {0, 2, 4, 8, 9};
//        int[] result = merge(arr1, arr2);
//        printArray(result);


        int[] arr3 = {2, 7, 5, 4, 6, 3, 0, 8, 9};
//        mergeSort(arr3, 0, arr3.length - 1);
        quickSort(arr3, 0, arr3.length - 1);
        printArray(arr3);
    }
}
