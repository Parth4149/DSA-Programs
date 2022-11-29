package Matrix;

import java.util.Arrays;

public class _4transpose {
    public static void transpose(int[][] arr) { // one traversal
        int r = arr.length, c = arr[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) { // j = i + 1
                int swap = arr[i][j]; //swap
                arr[i][j] = arr[j][i];
                arr[j][i] = swap;
            }
        }
        // print an array
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(arr));
        transpose(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
