import java.util.Arrays;

public class _3__InsertionSort {
    /**
     // current element is insert in correct(original position)

     // note
     * It is in place (no extra space required)
     * Insertion sort is stable algorithm

     // usage
     * Insertion sort is mostly used in small size array

     // Insertion Sort Algorithm:
     * we traverse the array
     * assign arr[i] as key and initialize j = i-1
     * if arr[j] > key, we allocate space for key so that key can place at correct position
     * then set arr[j+1] = key
     */
    // Best case : O(n)
    // Average case : O(n^2)
    // Worst case : O(n^2)
    public static void Insertion(int[] arr) {    // TC : O(n^2)  , SC : O(1)
        //we traverse an array
        for(int i = 0; i < arr.length; i++) {
            // assign arr[i] as key and initialize j = i-1
            int key = arr[i];
            int j = i - 1;
            // if arr[j] > key, we have to allocate space for key so that key can place on original position
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,7,2,6};
//        int[] arr = {1,1,0,1,0,0,1,1};
//        int[] arr = {2,5,7,12,15};
        System.out.println(Arrays.toString(arr));
        Insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

}
