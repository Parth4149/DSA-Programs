import java.util.Arrays;

/**
  // in short
 *  select an element and put it at correct position(index)
 *  we find min and put it at first position(index), second and so on...

 *  Selecting the smallest element again and again, and importing it in proper place


 * It is in place (no extra space required)
 * Selection sort is not stable it is not maintain the original order

  e.g. Array [90,80,90,25]

    i = 0    [90,80,90,25]
    i = 1    [25,80,90,90]   // here the array is sorted
    i = 2    [25,80,90,90]   // even though the array is sorted. it compares min for all remaining element
    i = 3    [25,80,90,90]   // therefore time complexity for all cases are same (worst, best, average)

 // extra
 * The algorithm maintains two subArrays in a given array
 * The subArray which is already sorted
 * Remaining subArray which is unsorted

 // usage
 * it is used when memory space is limited
 */

public class _2_SelectionSort {
    //
    public static void sort(int[] arr){     // time : theta(n^2) for all cases
        for(int i = 0; i < arr.length; i++){       // OR we can use i < n-1
            // find the min item in rest of the array and swap with i'th ele
            int min = i;// update
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

/**   Another way using max
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            // find the max item in the remaining array and swap with correct index
            int last = (arr.length - 1) - i;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int last){
        int max = start;
        for(int i = start + 1; i <= last; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
*/
    // [5,2,10,7,15,6]
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
//        int[] arr = {20,10,40,50,30};
        int[] arr = {5,2,10,7,15,6};
        System.out.println(Arrays.toString(arr));
//        sort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
