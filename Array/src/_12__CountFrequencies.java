import java.util.Arrays;
import java.util.HashSet;

// Java program to print frequencies of all array
// elements in O(1) extra space and O(n) time
public class _12__CountFrequencies {
/**
 * Time Complexity: O(n).
   As a single traversal of array takes O(n) time.
 * Space Complexity: O(n).
   To store all the elements in a HashMap O(n) space is needed.

    public static void findCounts(int arr[], int n) {

        int hash[] = new int[n];                // Hashmap
        Arrays.fill(hash, 0);
                                                // Traverse all array elements
        int i = 0;
        while (i < n) {
            hash[arr[i] - 1]++;                  // Update the frequency of array[i]
            i++;
        }
        for(i = 0; i < n; i++)  {
            System.out.println((i + 1) + " -> " + hash[i]);
        }
    }
    */

    // Function to find counts of all elements present in arr[0..n-1]. The array elements must be range from 1 to n
    public static void findCounts(int[] arr, int n) {     // Time : theta(n)  // As a single traversal of the array takes O(n) time.
        int i = 0;                                        // Space : theta(1)  // Since no extra space is needed.
        while(i < n){   // Traverse the array
            // If this element is already processed,then nothing to do
            if(arr[i] <= 0) {
                i++;
                continue;  // this is important, if we  write continue then following statement won't be executed
            }

            // Find index corresponding to this element e.g, index for 5 is 4
            int elementIndex = arr[i] - 1;

            //first store that element to arr[i]  so that we don't lose anything. and make element -1  means it occurs first time
            if(arr[elementIndex] > 0){
                arr[i] = arr[elementIndex];

                //After storing arr[elementIndex], change it to -1' initial count (if it will come again, else statement will execute)
                arr[elementIndex] = -1;
            }
            else{
                // If this is NOT first occurrence, then decrement its count. (means it increased the count it is negative
                arr[elementIndex]--;                // then make it positive therefore we get count) e.g. make -2 to 2

                arr[i] = 0;// And initialize arr[i] as 0 means the element 'i+1' is not seen so far
                i++;
            }
            // here we count frequencies negatively then make it positive
        }

        System.out.println("Below are counts of all elements");
        for (int j = 0; j < n; j++){
            System.out.println(j+1 + "->" + Math.abs(arr[j]));  // make elements positive
        }
    }

    // return frequencies of all elements
    public static int[] findCounts(int[] arr) { // TC : theta(n)
        int i = 0;
        int[] res = new int[arr.length];
        // sort an array using cycle sort
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        // check if ele are place at its correct position , then make it -1 (we count frequency negatively)
        for(i = 0; i < arr.length; i++) {
            if((i + 1) == arr[i]) {
                arr[i] = -1;
            }
        }

        // count the duplicate numbers
        for(i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                int correct = arr[i] - 1;
                arr[correct] = arr[correct] - 1;
            }
        }

        // store answer into arr res
        for(i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                res[i] = Math.abs(arr[i]);
            } else {
                res[i] = 0;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 5};
//        findCounts(arr, arr.length);
        findCounts(arr);

//        int arr1[] = {1};
//        findCounts(arr1, arr1.length);

//        int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
//        findCounts(arr2, arr2.length);

//        int arr3[] = {4, 4, 4, 4};
//        findCounts(arr3, arr3.length);
//
//        int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
//        findCounts(arr4, arr4.length);
//
//        int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        findCounts(arr5, arr5.length);
//
//        int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        findCounts(arr6, arr6.length);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

