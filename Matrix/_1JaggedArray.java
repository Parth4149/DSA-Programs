package Matrix;
/**
 * When you create m*n matrix, element might not store in contiguous memory
 * In java Matrix is an array of array, where individual arrays are objects
 * this arrays hold the reference of the object
 */

import java.util.Arrays;

// Jagged array of user specified size
public class _1JaggedArray {
    public static void main(String[] args) {
        int arr[][] = new int[3][];
        // main object is arr, individual objects are arr[i].  arr[i] length and find the length of the objects
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // Arrays.deepToString(arr) is used to print Multidimensional array
        System.out.println(Arrays.deepToString(arr));
    }
}
