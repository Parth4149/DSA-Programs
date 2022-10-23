import java.util.Arrays;

// External MergeSort
// -> Prerequisite : Heap Data structure
// https://stackoverflow.com/questions/20802396/how-external-merge-sort-algorithm-works
// https://www.geeksforgeeks.org/external-sorting/

public class _4__MergeSort {
//     It is in place algorithm
//     1. Find the middle point to divide the array into two half: m = l + (r - l)/2
//     2. Call mergeSort for first half: mergeSort(arr, l, m)
//     3. Call mergeSort for second half: mergeSort(arr, m+1, r)
//     4. Merge the two half sorted in step 2 and 3: merge(arr, l, m, r)

    /**
     * first we divide array into two parts (actually we don't divide array, first we count first half and second half)
     * get both half sorted via recursion
     * merge two sorted parts
     */

    // if left half finishes its execution then it will be removed from the recursion stack
    // then space will be free, we utilize these space to call right half (right half don't use separate extra space)

//    public static void mergeSort(int[] arr, int l, int r){
//        if(l >= r) {
//            return;
//        }
//        int m = l + (r - l) / 2;
//        mergeSort(arr, l, m);
//        mergeSort(arr, m + 1, r);
//        merge(arr, l, m, r);
//    }

/**
    * Recurrence relation : T(n) = 2T(n/2) + n
    * time : theta(logn) * theta(n) = theta(nlogn)
    * space : theta(n)
    * no of levels(passes) : logn (base2)    e.g.    if there are 8 element  log8 (base2) = 3
*/
    public static void mergeSort(int[] arr, int l, int r){  // I see this algorithm as post-order
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    // here this algorithm takes extra space for store element (not sorted element)
    private static void merge(int[] arr, int l, int m, int r) { // time : theta(n1 + n2)    space : theta(n/2) + theta(n/2) = theta(n)
        // first we divide the array
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];  // left half stores in array left
        int[] right = new int[n2];  // right half stores in array right
        for(int i = 0; i < n1; i++){
            left[i] = arr[i];
        }
        for(int i = 0; i < n2; i++){
            right[i] = arr[i + n1];
        }
        int i = 0, j = 0;
        // if one of array finishes execution, then we have to come out from the loop
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[i + j] = left[i++];
            } else{
                arr[i + j] = right[j++];
            }
        }
        // handling remaining array (it may be possible one of the array is not complete)
        while(i < left.length){
            arr[i + j] = left[i++];
        }
        while(j < right.length){
            arr[i + j] = right[j++];
        }
    }

    public static void main(String[] args) {
//        int[] arr = {7, 2, 5, 15, 3};
        int[] arr = {18,25,2,5,15,7,12};
        mergeSort(arr,0,arr.length - 1);
//        merge(arr,0,2,4);
        System.out.println(Arrays.toString(arr));
//        int[] res = mergeSort(arr,0,4);
//        System.out.println(Arrays.toString(res));
    }
}
