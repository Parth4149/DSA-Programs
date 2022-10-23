package Matrix;
import java.util.Arrays;

//  Search an element from the matrix (Matrix is sorted row-wise and column-wise)
public class _7Search {

//    public static boolean search(int[][] matrix, int target){ // O(r * logC)
//        int r = matrix.length, c = matrix[0].length;
//        for(int i = 0; i < r; i++){
//            int ans = binarySearch(matrix, i, target);
//            if(ans >= 0){
//                System.out.println(i+" "+ans);
//                return true;
//            }
//        }
//        return false;
//    }
//    public static int binarySearch(int[][] matrix, int row, int target){
//        int l = 0, r = matrix[0].length - 1;
//        while(l <= r){
//            int m = l + (r - l) / 2;
//            if(target == matrix[row][m]){
//                return m;
//            }
//            else if(target < matrix[row][m]){
//                r = m - 1;
//            }
//            else{
//                l = m + 1;
//            }
//        }
//        return -1;
//    }


    public static boolean searchMatrix(int[][] matrix, int target) { // TC : O(m + n)
        int row = 0, col = matrix[0].length - 1;
        while(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if(target == matrix[row][col]) {
                return true;
            }
            // if target is < ele, i need clear fist row
            else if(target < matrix[row][col]) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
             System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    /*
I/P
10 20 30 40
15 26 35 45
27 29 37 45
32 33 39 50

O/P
1 2 3 4
2 3 4 5
4 4 5 5
6 6 6 7
 */

    public static void main(String[] args) {
//        int[][] arr = {{10,20,30,40},{15,26,35,45},{27,29,37,45},{32,33,39,50}};
//        int[][] arr = {{1, 4, 7, 11, 15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] arr = {{-1,3}};
//        int[][] arr = {{-1},{-3}};
//        System.out.println(search(arr,-2));
//        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] arr = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        System.out.println(searchMatrix(arr,13));
        System.out.println(searchMatrix(arr,12));
        System.out.println(searchMatrix(arr,19));

//        printMatrix(arr);
    }
}

