import java.util.HashMap;

/**
 * Given an unsorted array and target, we need to find if there is a pair in the array with sum equal to target.
 */
// Unsorted Array
public class _9__2Sum {
    public static boolean pairSum(int[] arr, int target) { // time : O(n) , space : O(n) for hash table
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
//            if (!m.containsKey(arr[i])){    // initializing value to 0, if key not found
//                m.put(arr[i], 0);
//            }
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] != target - arr[i]) && m.containsKey(target - arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 2, 8, 10, 11};
        System.out.println(pairSum(arr, 6));// false
        System.out.println(pairSum(arr, 17));// true  9,8
    }
}