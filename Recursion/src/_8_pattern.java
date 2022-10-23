import java.util.Arrays;

public class _8_pattern {
    public static void triangle(int row, int col){
        if(row == 0){
            return;
        }
        if(row > col){
            System.out.print("*"); // this line execute before removing fun call from the stack memory
            triangle(row,col + 1);
        }
        else{
            System.out.println();
            triangle(row - 1,0);
        }
    }
    public static void triangle2(int row, int col){
        if(row == 0){
            return;
        }
        if(row > col){
            triangle2(row,col + 1);
            System.out.print("*");    // this line is only execute after remove fun call from the stack memory
        }
        else{
            triangle2(row - 1, 0);      // equal val of row and col execute in else statement e.g tri(3,3), tri(2,2)...
            System.out.println();               // and print '\n' after removing from the stack memory
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
//        triangle(5,0);
//        triangle2(4,0);
    }
}
