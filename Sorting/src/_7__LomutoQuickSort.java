import java.util.Arrays;

public class _7__LomutoQuickSort {
    //   Partition return correct index of pivot(last element)
    public static int lPartition(int[] arr, int l, int r) { // Lomuto Partition     // time : O(n)      space : O(1)
        int pivot = arr[r];   // take last element as pivot
        int i = l;
        // traverse the loop
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i; // position of last element
    }

    //    Implementation of QuickSort using the first element as a pivot:

    public static void quickSort(int[] arr, int l, int r) {   // time : O(n^2) worst case ,  average case : O(nlogn)
        if (l < r) {
            int p = lPartition(arr, l, r);      // return the index of pivot
            quickSort(arr, l, p - 1);    // left    // here both sides sorted independently
            quickSort(arr, p + 1, r);    // right
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {3,15,6,9,12,11,8};
        int[] arr = {3, 15, 6, 12, 5, 8};
//        int[] arr = {10,7,5,3,2};
//        int[] arr = {10,20,25,30,35};
        quickSort(arr, 0, arr.length - 1);
//        lPartition(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
