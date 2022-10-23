package Java.Lambda;

import java.util.Arrays;

public class _2DArray {
    public static void main(String[] args) {
        int[][] arr = {{5,10},{2,25},{25,7},{1,13},{7,22}};

        // increasing(ascending) order
//        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
//        Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0])); // OR

        //decreasing(descending) order
//        Arrays.sort(arr, (a, b) -> Integer.compare(b[0],a[0]));

        System.out.println(Arrays.deepToString(arr));

//        [[1, 13], [2, 25], [5, 10], [7, 22], [25, 7]]
//        [[25, 7], [7, 22], [5, 10], [2, 25], [1, 13]]
    }
}
