package Matrix;

public class _3MatrixBoundaryTraversal {
    public static void matrixBoundaryTraversal(int[][] arr) { // TC : theta(r + c)
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) { // top row
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j]+" ");
                }
            }
            else if(i == arr.length - 1) { // bottom row & left column
                for(int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j]+" ");
                }
                // print first column at the end
                for(int j = arr.length - 2; j >= 1; j--) { // second last element to second element
                    if(arr[j].length > 1) {
                        System.out.print(arr[j][0]+" ");
                    }
                }
            }
            else { // right column
                System.out.print(arr[i][arr[i].length - 1]+" "); // last element of the row
            }
        }
    }

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
    public static void matrixBoundaryTraversal2(int[][] arr){ // TC : theta(r + c)
        int r = arr.length, c = arr[0].length;
        int top = 0, bottom = r - 1, left = 0, right = c - 1;

        // top row
        for(int i = left; i <= right; i++){
            System.out.print(arr[top][i]+" ");
        }
        top++;

        // right column
        for(int i = top; i <= bottom ; i++){
            System.out.print(arr[i][right]+" ");
        }
        right--;

        // bottom row
        for(int i = right; i >= left && top <= bottom; i--){
            System.out.print(arr[bottom][i]+" ");
        }
        bottom--;

        // left column
        for(int i = bottom; i >= top && left <= right; i--){
            System.out.print(arr[i][left]+" ");
        }
        left++;

    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] arr = {{1, 2, 3, 4}}; // only 1 row
//        int[][] arr = {{1},{2},{3},{4}}; // only 1 column
//        int[][] arr = {{1,2},{3,4},{5,6}};

        matrixBoundaryTraversal(arr);
        System.out.println();
        matrixBoundaryTraversal2(arr);
    }
}
