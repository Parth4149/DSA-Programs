package Sliding_Window;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// count distinct elements in every window of size k

public class _5CountDistinctElement {
//    public static void countDistinct(int[] arr, int k){
//        HashSet<Integer> set = new HashSet<>();
//        for(int i = 0; i < arr.length + 1 - k; i++){
//            int count = 1;
//            set.clear();
//            // HashSet<Integer> set = new HashSet<>();
//            for(int j = 0; j < k; j++){
//                set.add(arr[i + j]);
//            }
//            System.out.print(set.size()+" ");
//        }
//    }

    public static void countDistinct(int[] arr, int k){ // TC : O(n) , SC : O(k)
        HashMap<Integer,Integer> m = new HashMap<>();
        int i = 0, j = 0;
        while(j < arr.length) {
            // calculation
            if(!m.containsKey(arr[j])) {
                m.put(arr[j], 0);
            }
            m.put(arr[j], m.get(arr[j]) + 1); // increment count

            // window size < k
            if((j - i + 1) < k) {
                j++;
            }

            else {
                System.out.print(m.size()+" ");
                // slide the window
                m.put(arr[i], m.get(arr[i]) - 1);   // decrement count

                // At one point, count of arr[j] will be 0 then we remove it
                if(m.get(arr[i]) == 0){
                    m.remove(arr[i]);
                }
                i++; j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,3,3};// 3 4 3 2
        countDistinct(arr,4);

    }
}
