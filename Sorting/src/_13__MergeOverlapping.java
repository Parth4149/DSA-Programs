import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Merge Overlapping Intervals
public class _13__MergeOverlapping {
    public static int[][] mergeIntervals(int[][] intervals) {
        final int start = 0, end = 1;
        int n = intervals.length;

        List<int[]> res = new ArrayList<>();

        // sort an array
//        Arrays.stream(intervals).forEach(interval -> Arrays.sort(interval));
//        Arrays.stream(intervals).forEach(Arrays::sort);

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));// OR  (a, b) -> a[0] - b[0])
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));// OR  (a, b) -> a[0] - b[0])
        System.out.println(Arrays.deepToString(intervals));
        // now i run the loop using index i
        for(int i = 0; i < n; i++) {
            // initialize curr interval's start & end
            int min = intervals[i][start], max = intervals[i][end];
            // run the inner loop to handle multiple interval
            // here i compare next itvl's start and curr itvl's end
            while(i < n - 1 && intervals[i + 1][start] <= max) {
                min = Math.min(min, intervals[i + 1][0]);
                max = Math.max(max, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{min, max});
        }
        return res.toArray(new int[res.size()][]); // List to 2D array
    }

    public static void InsertionSort(int[][] arr){
        //we traverse the loop
        for(int i = 1; i < arr.length; i++){
            // assign i'th row as key and initialize j = i-1
            int[] key = arr[i];
            int j = i - 1;
            // if arr[j] > key, we allocate space for key so that key can place on original position
            while(j >= 0 && arr[j][0] > key[0]){ // compare first elements
                arr[j + 1] = arr[j]; // move right
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,3},{2,4},{5,7},{6,8}};
//        int[][] nums = {{7,9},{6,10},{4,5},{1,3},{2,4}};
//        int[][] nums = {{1,3},{2,4},{4,5},{6,10},{7,9}};
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        int[][] res = mergeIntervals(nums);
        System.out.println(Arrays.deepToString(res));

    }

//    public static void mergeSort(int[][] arr, int l, int r) {
//        if(l >= r) {
//            return;
//        }
//        int mid = l + (r - l) / 2;
//        mergeSort(arr, l, mid);
//        mergeSort(arr, mid + 1, r);
//        merge(arr,l ,mid,r);
//    }
//    public static void merge(int[][] arr, int l, int m, int r) {
//        int n1 = m - l + 1, n2 = r - m;
//        // store left half into array left & right half into array right
//        int[][] left = new int[n1][];
//        int[][] right = new int[n2][];
//        for(int i = 0; i < n1; i++) {
//            left[i] = arr[i];
//        }
//        for(int i = 0; i < n2; i++) {
//            right[i] = arr[i + n1];
//        }
//        int i = 0 , j = 0;
//        while(i < left.length && j < right.length) {
//            if(left[i][0] <= right[j][0]) {
//                arr[i + j] = left[i++];
//            } else {
//                arr[i + j] = right[j++];
//            }
//        }
//        // to handle rest of the array
//        while(i < left.length) {
//            arr[i + j] = left[i++];
//        }
//        while(j < right.length) {
//            arr[i + j] = right[j++];
//        }
//    }

//     public static void InsertionSort(int[][] arr) {
//         for(int i = 1; i < arr.length; i++) {
//             int[] key = arr[i];
//             int j = i - 1;
//             while(j >= 0 && arr[j][0] > key[0]) {
//                 arr[j + 1] = arr[j];
//                 j--;
//             }
//             arr[j + 1] = key;
//         }
//     }
}

