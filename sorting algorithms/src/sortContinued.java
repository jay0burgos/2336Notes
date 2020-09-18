import java.text.*;
import java.math.*;
import java.util.regex.*;

public class sortContinued {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    /*
    Notes:
        Divide and conque algo
        not adaptive will always perform the same way, nlog(n)
        and it is stable
     */
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        System.out.print("Printing left");
        printArray(L);

        System.out.print("Printing Right");
        printArray(R);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged sub array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {

        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves recursive sort
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
            System.out.print("printing new array");
            printArray(arr);

        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    /*public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7, 26, 31, 56, 20, 32};

        System.out.println("Given Array");
        printArray(arr);

        sortContinued ob = new sortContinued();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }*/

}

class QuickSort {
/*
       This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot

       Notes: nlogn
              worst case it becomes a o(n^2)

*/
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}


class quicksortSolution{
    public static  void quicksort(int[] array){
        quicksort(array, 0, array.length-1);
    }
    public static void quicksort(int[] array, int left, int right){
        if(left >= right){
            return; //if left marker passes or equals the right marker dont do anything
        }
        int pivot = array[left+(right - left)/2]; //picks center of array, this way of doing it is immune to overflow
                                                  //its mathematically equivalent but immune to overflow as "right > left"
                                                  // is an invariant that always holds and if "right" is representable then, "left" is also
                                                  // representable the result will never overflow. as it will be less than "right".
        int index = partition(array, left, right, pivot); //this is the dividing point from left to right
        quicksort(array, left, index -1);
        quicksort(array,index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        //move pointers towards each other
        while (left <= right){
            while(array[left] < pivot){
                left++;
            }
            while (array[right]> pivot){
                right--;
            }
            if (left <= right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void swap(int [] array, int left, int right){
        int temp =0;
        temp= array[right];
        array[right]= array[left];
        array[left]= temp;
    }
}