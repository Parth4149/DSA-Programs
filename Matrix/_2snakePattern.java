package Matrix;

// Print a Matrix in Snake Pattern
public class _2snakePattern {
    public static void printPattern(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){ // even
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j]+" ");
                }
            } else{ // odd
                for(int j = arr[i].length - 1; j >= 0; j--){
                    System.out.print(arr[i][j]+" "); //
                }
            }
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(arr));
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printPattern(arr);
    }
}
