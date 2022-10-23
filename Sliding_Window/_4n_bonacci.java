package Sliding_Window;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// print m n-bonacci number
public class _4n_bonacci {
//    public static void nBonacci(int n, int m){ // TC : O(n * m) , SC : O(m)
//        int[] arr = new int[m];
//        // fist n-1 element will be 0 and nth element will be 1
//        arr[n - 1] = 1;
//        for(int i = n; i < m; i++){
//            for(int j = i - n; j < i; j++){
//                // we add sum of n numbers in i'th position
//                arr[i] += arr[j];
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }

    public static void nBonacci(int n, int m) { // TC : O(m) , SC : O(m)
        // Assuming m > n.
        int[] arr = new int[m];
        // by default all the elements are 0
        arr[n - 1] = 1;
        arr[n] = 1;
        int sum = 1;
        for(int i = n; i < m - 1; i++){
            // here I double the sum of curr window and subtract sum of prev window in it
            sum = ((2 * arr[i]) - arr[i - n]);
            // here we calculate for next element
            arr[i + 1] = sum;
        }
        System.out.println(Arrays.toString(arr));
    }

//    public static void nBonacci(int n, int m){
//        List<Integer> list = new ArrayList<>();
//        // we compute first n+1 element
//        for(int i = 0; i < n - 1; i++){ // first add n - 1  0's in the list
//            list.add(0);
//        }
//        list.add(1);
//        list.add(1);
//
//        int sum = 1;
//
//        // n+1 to m
//        for(int i = n; i < m - 1; i++){
//            sum += (list.get(i) - list.get(i - n));
//            list.add(sum);
//        }
//        System.out.println(list);
//    }
    public static void main(String[] args) {
        nBonacci(3,8);//    [0, 0, 1, 1, 2, 4, 7, 13]
//        nBonacci(4,10);//   [0, 0, 0, 1, 1, 2, 4, 8, 15, 29]
    }
}
