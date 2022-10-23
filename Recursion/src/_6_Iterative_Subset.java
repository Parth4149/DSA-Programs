import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6_Iterative_Subset {
    // iterative
    public static List<List<Integer>> subset(int[] arr) { // TC : O(n * 2^n) , SC :  theta(2^n * n) , where 2^n is total subset &
        List<List<Integer>> outer = new ArrayList<>();                                             // n is space taken by each subset
        outer.add(new ArrayList<>()); // add an empty list so that size will becomes 1
        int n;
        for(int i = 0; i < arr.length; i++) {
            n = outer.size();// every time we double the length of outer list //if outer list size 2, so we have to create 2 new list and add in outer list now size will be 4
            for(int j = 0; j < n; j++) { // (n = 1, 2, 4)
                List<Integer> internal = new ArrayList<>(outer.get(j)); // copy of the outer j'th list and add num in it
                internal.add(arr[i]);
                outer.add(internal); // we save internal list in outer list
            }
        }
        return outer;
    }

    // similar to the above approach
    public static List<List<Integer>> subsetDuplicate(int[] arr) { // TC : O(n * 2^n) , SC :  theta(2^n * n) , where 2^n is total subset &
        // i need to sort an array so than i can find duplicate easily
        Arrays.sort(arr);
        // 1st I create the outer list & add an empty list
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); // add an empty list so that size will becomes 1
        int start = 0, end = 0; // for inner loop (here we compute n for starting point)
        for(int i = 0; i < arr.length; i++) {
            start = 0;
            if(i > 0 && arr[i - 1] == arr[i]) {
                start = end + 1;
            }
            end = outer.size();
            int n = outer.size();
            for(int j = start; j < n; j++) { // inner loop staring from start
                List<Integer> internal = new ArrayList<>(outer.get(j));
                outer.add(internal);
                internal.add(arr[i]);
            }
        }
        return outer;
    }

    /**  // the result of right lists is depends on left list
     *   // first we copy all the list in internal list and add num in it
     *   // if outer list size 2, so we have to create 2 new list and add in outer list now size will be 4

     *                         [[]]
     *                     [[],   [1]]
     *              [[], [1],     [2], [1, 2]]
     * [[], [1], [2], [1, 2],     [3], [1, 3], [2, 3], [1, 2, 3]]
     */
    public static void main(String[] args) {
//        int[] arr = {1,2,3};
        int[] arr = {1,2,2};
//        List<List<Integer>> res = subset(arr); // [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        List<List<Integer>> res = subsetDuplicate(arr); // [[], [1], [2], [1, 2], [1, 2, 2]]
        System.out.println(res);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.contains(2));
    }
}
