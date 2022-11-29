package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Rotate the matrix by 90' Anticlockwise
public class _5RotateMatrix {
    // 1st reverse all row and 2nd transpose matrix
    // OR  1st transpose and 2nd reverse all column

    public static void rotateBy90(int[][] matrix) {  // TC : theta(r*c) OR theta(n^2)
        reverseAllRow(matrix);
        transposeMatrix(matrix);
    }

    public static void reverseAllRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            reverseRow(matrix, i);
        }
    }

    public static void reverseRow(int[][] matrix, int row) {
        int l = 0, r = matrix[row].length - 1;
        while (l < r) {
            int swap = matrix[row][l];
            matrix[row][l] = matrix[row][r];
            matrix[row][r] = swap;
            l++;
            r--;
        }
    }

    public static void transposeMatrix(int[][] matrix) { // one traversal
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {     // upper diagonal
            for (int j = i + 1; j < c; j++) { // j = i + 1, we do not swap diagonal ele becoz both index of d. ele. are equal
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        System.out.println(Arrays.deepToString(arr));
        rotateBy90(arr);
//        printMatrix(arr);

//        int[][] arr2 = {{1,2,3},{4,5,6}};
//        int[][] result = rotate2(arr2);
//        printMatrix(result);
    }

    // row & column are not equal
    public static int[][] rotate2(int[][] matrix) {  // TC : O(r*c) , SC : O(r*c)
        int r = matrix.length, c = matrix[0].length;
        // initialize no. of old rows as new col size and no. of old cols as new row size
        int[][] result = new int[c][r]; //

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[j][r - i - 1] = matrix[i][j];
            }
        }
        return result;
    }
}
