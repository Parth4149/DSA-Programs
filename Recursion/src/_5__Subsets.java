import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Subset: Same as subsequence except it has empty set  i.e. However, Subset it does not have to maintain order
 * Substrings are consecutive parts of a string, while subsequences need not be.
 * Consider strings “geeksforgeeks” and “gks”.
 -> “gks” is a subsequence of “geeksforgeeks” but not a substring.
 -> “geeks” is both a subsequence and subArray.

 *** SubArray/subString = n*(n+1)/2
 *** Subseqeunce = (2^n) -1 (non-empty subsequences)
 *** Subset(Power-set) = 2^n
 */
public class _5__Subsets {
    public static void subsets(String str, String curr, int i) {   // TC : theta(2^n)     SC : theta(h)
        if(i == str.length()) {                                                            // where h is height of recursion tree
            System.out.println(curr);
            return;
        }
        subsets(str, curr,i + 1);         // here there are 2 choices ignore or take i'th char
        subsets(str,curr + str.charAt(i),i + 1);
    }

    // Another method
    public static ArrayList<String> subString(String str, String curr) {
        if(str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(curr);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subString(str.substring(1),curr);
        ArrayList<String> right = subString(str.substring(1),curr + ch);
        System.out.println(left+" "+right);
        left.addAll(right);// merging
        return left;
    }

    // Another method (this takes more time compare to above solution)
    public static void subsets(String curr, String str) {// here there are 2 choices ignore or take
        if(str.isEmpty()) {
            System.out.println(curr);
            return;
        }
        char ch = str.charAt(0);
        subsets(curr, str.substring(1)); // ignore
        subsets(curr + ch, str.substring(1));// take (add)
    }


    public static void main(String[] args) {
//        subsets("ABC","",0);//
//        subsets("","ABC");
//        subString("ABC","");
        System.out.println(subsets2("ABC","")); // [, C, B, BC, A, AC, AB, ABC]
    }
    private static ArrayList<String> subsets2(String str, String curr) {
        return subsets2(str, curr, new ArrayList<>());
    }

    private static ArrayList<String> subsets2(String str, String curr, ArrayList<String> list) {
        if(str.isEmpty()) {
            list.add(curr);
            return list;
        }
        char ch = str.charAt(0);
        subsets2(str.substring(1), curr, list);
        subsets2(str.substring(1), curr + ch, list);
        return list;
    }

    // method 2
//    public static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index) {
//        // Base Condition
//        if (index == nums.size()) {
//            subset.add(output);
//            return;
//        }
//
//        // Not Including Value which is at Index
//        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
//
//        // Including Value which is at Index
//        output.add(nums.get(index));
//        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
//    }


/*

           O
        ↙     ↘
      1         1
    ↙   ↘      ↙   ↘
  2      2    2      2
 ↙ ↘    ↙ ↘  ↙  ↘   ↙  ↘
3  3   3  3  3  3  3   3

*/
}
