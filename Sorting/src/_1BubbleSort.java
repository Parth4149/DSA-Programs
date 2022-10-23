import java.util.Arrays;

/**
 * in place algorithm (no need to required extra space)
 * it is stable algorithm

 // usage
 * it is used for small set of elements , it is inefficient for large set of element

 (when original order is maintained for equal values. this is known as stable.)
 (when order is not maintained that is unstable.)
 */
public class _1BubbleSort {
/**
    public static void bubbleSort(int[] arr){   // time : O(n^2)     best case: O(n)    average case: O(nLogn)   worst case: O(n^2)
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < (arr.length-1) - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }
*/

    /**
     * Each element of the array is compared with its adjacent element
     * it swaps the element if the elements are not in their right position
     */
    public static void bubbleSort2(int[] arr){ // time : O(n^2)     best case: O(n)    average case: O(n^2)   worst case: O(n^2)
        // after first pass largest element will move at the end
        // after second pass second-largest element will move at second-last position
        for(int i = 0; i < arr.length; i++){ // keep repeating until all element is sorted
            // if any swapping not occur in inner loop then array is sorted, and we simply break the outer loop
            boolean swapped = false;
            // max element come at the last index ,similarly second max come at second last index
            for(int j = 0; j < (arr.length - 1) - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j,j + 1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

//  Recursive approach (like triangle pattern)
// * * * * *
// * * * *
// * * *
// * *
// *
public static void bubbleSort2(int[] arr, int i, int j, boolean swapped) {
    if(i == -1) {
        return;
    }
    // to handle best case
    if(j == i && !swapped) {
        return;
    }
    if(j < i) {
        if(arr[j] > arr[j + 1]){
            swap(arr, j, j + 1);
            swapped = true;
        }
        bubbleSort2(arr, i, j + 1, swapped);
    }
    else {
        bubbleSort2(arr, i - 1, 0, false);
    }
}

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,17,5,2,10};
//        int[] arr = {3,5,7,9,11};
//        bubbleSort(arr);
        bubbleSort2(arr,5,0,false);
        System.out.println(Arrays.toString(arr));
    }
}
