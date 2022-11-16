import java.util.Arrays;
public class _7__HoareQuickSort {   // Hoare's Partition  (two pointer approach)
/**
     * Quick sort algorithm
     * In-place
     * cache friendly
     * tail recursive
     * not stable

     * Recurrence relation
     general : T(n) = T(k) + T(n-k-1) + Θ(n)

     * Best Case:
     -> The best case occurs when the partition process always picks the middle element as pivot. (divide into equal half)
     -> T(n) = 2T(n/2) + cn = 2T(n/2) + Θ(n)
     -> TC : theta(nLogn). It can be solved using case 2 of Master Theorem.
     -> SC : theta(Logn) // for recursion call

     * Worst Case:
     -> The worst case occurs when the partition process always picks smallest or largest element as pivot.
     -> T(n) = T(n-1) + Θ(n)
     -> TC : theta(n^2)
     -> SC : theta(n) // it takes theta(n) space for recursion call in worst cast only)

     * Average Case:
     -> TC : O(nLogn)
     -> SC : theta(n) // for recursion call

     * Overall
     -> TC : theta(n^2)
     -> SC : theta(n)


     * Hoare's Partition is much faster than lomuto partition
     * Quick sort is not a stable algorithm (only naive partition approach is stable, but it takes O(n) auxiliary space)
        - because swap operation during partitioning disturbs original order

     * Although the worst case TC of QuickSort is theta(n^2) which is more than many other sorting algorithms
        like Merge Sort and Heap Sort,
     ** merge sort is generally considered better when data is huge and stored in external storage.
     */

    /**
    * java uses Quick sort for primitive data type and Merge sort for non-primitive
    * java & python uses Tim sort algorithm (it is a variation of Merge sort)
    * Quick is the fastest algorithm if stability is not require
    * if you need stability then Merge sort is preferred
    */

    public static int hPartition(int[] arr, int l, int r) { // pivot element is not fixed
        // we assign left element as pivot
        int pivot = arr[l];
        int i = l, j = r;
        // iterate the array
        while (true) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }
            if (i >= j) {
                return j;               // return index of left subArray
            }
            swap(arr,i, j);
        }
    }
    // time : theta(n^2) worst case ,  average case : theta(nlogn)
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = hPartition(arr, l, r); // it returns index of prev ele of pivot , smaller element moves left side and greater right side
            quickSort(arr, l, p);
            quickSort(arr,p + 1, r);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {3,15,6,9,12,11,8};
        int[] arr = {7,15,6,12,5,8};
//        int[] arr = {2,1,6,5,4,3};
//        int[] arr = {10,20,25,30,35};

//        hPartition(arr, 0, arr.length - 1);
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
