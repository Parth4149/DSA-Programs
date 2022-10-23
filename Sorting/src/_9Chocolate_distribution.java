import java.util.Arrays;

// Chocolate distribution problem (min diff between min and max element of group m)
public class _9Chocolate_distribution {
    public static int minDiff(int[] arr, int m){    // time : O(nlogn)
        if(m > arr.length){
            return -1;
        }
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
//        for(int i = 1; (i + m - 1) < arr.length; i++) {
//            res = Math.min(res, (arr[i + m - 1] - arr[i]));
//        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,9,9,12,56}; // 5
        int ans = minDiff(arr,4);
        System.out.println(ans);
    }
}
