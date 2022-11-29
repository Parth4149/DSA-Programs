package Matrix;

import java.util.Arrays;
import java.util.Collections;

// Median of row-wise sorted Matrix
public class _8_median {
    // Brute Force Solution
//    public static double median(int[][] matrix){ // TC : O(N*M*log(N*M) , SC : O(N*M)
//        int N = matrix.length, M = matrix[0].length;
//        int[] tempArr = new int[N * M];
//        int desired_index = ((1 + N * M) / 2 ) - 1;
//        int index = 0;
//        for(int i = 0; i<N; i++) {
//            for(int j = 0; j<M; j++) {
//                tempArr[index++] = matrix[i][j];
//            }
//        }
//        Arrays.sort(tempArr);
//        return tempArr[desired_index];
//    }

    /**
     * First, we need to find the min and max elements from the matrix.
        The min and max can be easily found since the rows are sorted, so we need to compare with the first element of
        each row for minimum and last element of each row for maximum.

     * After finding our min and max, we can use(apply) binary search on this range.The middle-element can be calculated and
       number of elements smaller or equal to mid can be calculated, we have used upper_bound() function for this.

     * Based on the value of our counter, the min and max can be adjusted accordingly based on what we do for binary search.
     */

    // upper_bound:logC , row:r , binary search:log(max - min)
    public static int median(int[][] matrix) { // TC : theta( log(max-min) * (r*logC) ) , SC : theta(1)
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int r = matrix.length, c = matrix[0].length;
        int desired_counter = (r * c + 1) / 2;

        // find min and max from given matrix
        for (int i = 0; i < r; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][c - 1]);
        }

        // binary search
        while (min < max) {
            int counter = 0;
            int middle = (min + max) / 2;
            for (int i = 0; i < r; i++) {
                counter += upper_bound(matrix[i], middle); //  it returns an index ele. which is >= (least greater ele) target
            }
            System.out.println();
            if (counter < desired_counter) {
                min = middle + 1;
            } else {
                max = middle; // middle - 1
            }
        }
        // here both min and max are equal so we can return any one of them
        return min;
    }

    public static int upper_bound(int[] arr, int target) {
        // Initialise starting index and ending index
        int left = 0, right = arr.length - 1;
        // Till left is less than right
        while (left < right && left != arr.length) {
            // Find the index of the middle element
            int mid = left + (right - left) / 2;

            // If arr[mid] <= target, then find in right subarray
            if (arr[mid] <= target) {
                left = mid + 1;
            }

            // If arr[mid] > target then find in left subarray
            else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1,10,20},{15,25,35},{5,30,40}}; // 20 (count : 5)
//        [1, 5, 10, 15, 20, 25, 30, 35, 40]

//        int[][] arr = {{2,4,6,8,10},{1,3,5,7,9},{100,200,400,500,800}}; // 8 (count : 9)
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 400, 500, 800]

//        int[][] arr = {{1,2,5},{2,6,9},{3,6,9}}; // 5 (count : 3)
//        [1, 2, 2, 3, 5, 6, 6, 9, 9]

        int[][] arr = {{5, 10, 20, 30, 40}, {1, 2, 3, 4, 6}, {11, 13, 15, 17, 19}}; // 11 (count : 4)
//        [1, 2, 3, 4, 5, 6, 10, 11, 13, 15, 17, 19, 20, 30, 40]

        System.out.println(median(arr));

    }
}
