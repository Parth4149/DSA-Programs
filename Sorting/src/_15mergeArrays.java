import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15mergeArrays {
    public static void mergeSortedArrays(int[][] matrix){
        List<Integer> resList = merge(matrix[0], matrix[1]);
        // ArrayList to Array Conversion
        int[] resArray = resList.stream().mapToInt(i -> i).toArray();
        for(int i = 2; i < matrix.length; i++){
            resList = merge(resArray, matrix[i]);
            // ArrayList to Array Conversion
            resArray = resList.stream().mapToInt(j -> j).toArray();
        }
        System.out.println(Arrays.toString(resArray));
    }
    public static List<Integer> merge(int[] n1, int[] n2){
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < n1.length && j < n2.length){
            if(n1[i] <= n2[j]){
                list.add(n1[i++]);
            } else{
                list.add(n2[j++]);
            }
        }
        // it may possible one of array is not completed, now we handle rest of array
        while(i < n1.length){
            list.add(n1[i++]);
        }
        while(j < n2.length){
            list.add(n2[j++]);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1,10,20},{15,25,35},{5,30,40}}; // 20
//        [1, 5, 10, 15, 20, 25, 30, 35, 40]

        int[][] arr = {{2,4,6,8,10},{1,3,5,7,9},{100,200,400,500,800}}; // 8
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 400, 500, 800]
        mergeSortedArrays(arr);
    }
}
