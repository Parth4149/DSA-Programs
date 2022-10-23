package Sliding_Window;

// find all Max element of all subarrays
import java.util.*;

public class _6_MaxOfAllSubarrays {

//    public static void maxOfAllSubarrays(int[] arr, int k) { // TC : O(m * k) where m = n - k
//        for(int i = 0; i < (arr.length - k + 1); i++) {
//            int max = arr[i];
//            for(int j = 0; j < k; j++) {
//                max = Math.max(max, arr[i + j]);
//            }
//            System.out.print(max+" ");
//        }
//    }

    // n : no. of players , k : no. of previous season
    public static List<Integer> maxOfAllSubarrays(int[] arr, int k) {
        int i = 0, j = 0;
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        // here i is starting of the window and j is ending of the window
        while (j < arr.length) {
            // calculation
            while(!q.isEmpty() && q.getLast() < arr[j]) {
                q.removeLast();
            }

            if(q.isEmpty() || arr[j] > q.getFirst()) {
                q.addFirst(arr[j]);
            } else {
                q.addLast(arr[j]);
            }

            // if the window size <= k
            if ((j - i + 1) < k) {    // window size (j - i + 1)
                j++;
            }

            // hits window size
            else {
//                System.out.println(q);
                list.add(q.getFirst());
                // slide the window
                if(q.getFirst() == arr[i]) {
                    q.removeFirst();
                }
                i++;j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] arr = {3, -1, 2, 6, 9, -5, 5, 2, 3, 3, 2, 4};  // 3 6 9 9 9 5 5 3 3 4
//        int[] arr = {3,-1,2,6,9,-5,5};  //3 6 9 9 9
//        int[] arr = {3,-1,2,6,6,7,9};   //3 6 6 7 9
        int[] arr = {4,5,-1,2,1,3,9}; //5 5 2 3 9
        System.out.println(maxOfAllSubarrays(arr,3));
    }
}
