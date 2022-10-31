import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _5LeadersInArray {
    public static List<Integer> leaders(int[] arr) {// time : theta(n)
        if (arr.length == 1) {
            System.out.println(arr[0]);
        }
        List<Integer> list = new ArrayList<>();
        int curr_leader = arr[arr.length - 1]; // last element
        list.add(curr_leader);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > curr_leader) {
                curr_leader = arr[i];
                list.add(curr_leader);
            }
        }
        // reverse the list
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 6, 5, 2}; // 10 6 5 2
        System.out.println(leaders(arr));
    }
}
