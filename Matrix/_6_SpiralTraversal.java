package Matrix;

public class _6_SpiralTraversal {
//    public static void spiralTraversal(int[][] matrix){
//        int n = matrix.length;// n x n matrix
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n - i; j++){
//                // top row (print elements from start to end)
//                if(j == i){
//                    for(int k = j; k < n - i; k++){
//                        System.out.print(matrix[j][k]+" ");
//                    }
//                }
//                else if(j == n - i - 1){
//                    // bottom row (reverse)
//                    for(int k = n - i - 1; k >= i; k--){
//                        System.out.print(matrix[j][k]+" ");
//                    }
//                    // left column (reverse)
//                    for(int k = n - i - 2; k >= i + 1; k--){
//                        System.out.print(matrix[k][i]+" ");
//                    }
//                }
//
//                // to handle right column
//                else{
//                    System.out.print(matrix[j][n - i - 1]+" ");
//                }
//            }
//        }
//    }

    /*
                          right
                            ⬇ ️
    top ➡  1   2   3   4   5
            6   7   8   9   10
            11  12  13  14  15
            16  17  18  19  20
            21  22  23  24  25 ⬅ bottom
            ⬆
           left
*/
    public static void spiralTraversal(int[][] matrix) { // TC : theta(r*c)
        int r = matrix.length, c = matrix[0].length;
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        // 4 pointers come towards the center
        while (top <= bottom && left <= right) {
            // top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;  // after printing first row we increment top so that it can not count again

            // right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // bottom row (reverse)
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;

            // left column (reverse)
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
        // when all pointers reach at the center, i come out from the loop
        // this loop will terminate  after  all pointers reach at the center
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j]+" ");
                System.out.printf("%-3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printMatrix(arr);
        spiralTraversal(arr);
    }
}
