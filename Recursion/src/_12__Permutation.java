import java.util.ArrayList;
import java.util.List;

//    https://media.geeksforgeeks.org/wp-content/cdn-uploads/NewPermutation.gif
public class _12__Permutation {
    // first we swap the char and perform operation after that we re-swap that char
    /** parent gives string to its child
     * after completing operation child return string to its parent
     * here given string = return string  (here we don't return anything it is for understanding)
     *  P(n,r) = n! / (n - r)!
     */

    /** [NOTE]
     * Permutation : used for the list of data (where the order of the data matters)
                     find total no. of possible  arrangements of a given set

     * Combination : used for a group of data (where the order of data doesn't matter)

     Types of Permutation:
     1. Permutation where repetition is allowed
     2. Permutation where repetition is not allowed
     */
//   file:///C:/Users/dell/Documents/Notes/7%20Examples%20of%20Permutations%20in%20Real%20Life%20Situation%20-%20The%20Boffins%20Portal.html


//    [Gaming, Search Engine, Antivirus, etc.]
//    RTO ensure all the cars have unique number (number plat)
//    GJ 23 A4149  ,  GJ(state) 23(district) A4149(combination of latter and digit)  (A-Z  26 ways),(0-9  10 ways)->4 times
//                                                                // 26 * 10 * 10 * 10 * 10 = 260000

    /**
     * Note: This solution prints duplicate permutations if there are repeating characters in the input string.
     * Please see the below link for a solution that prints only distinct permutations even if there are duplicates in input.
     */
//    https://www.geeksforgeeks.org/print-all-permutations-of-a-string-with-duplicates-allowed-in-input-string/

    public static void permute(String s, int i){   // TC : O(n*n!)
        if(i == (s.length() - 1)){
            System.out.println(s);
            return;
        }
        for(int j = i; j < s.length(); j++){
            s = swap(s, i, j);
            permute(s,i + 1);
            s = swap(s, i, j);
        }
    }
//    public static void permuteDistinct(String s, int i){   // TC : O(n*n!)
//        if(i == (s.length() - 1)){
//            System.out.println(s);
//            return;
//        }
//
//        for(int j = i; j < s.length(); j++){
//
//            s = swap(s, i, j);
////            if(j == 0 || (j > 0 && s.charAt(j - 1) != s.charAt(j))) {
//                permute(s,i + 1);
////            }
//            s = swap(s, i, j);
//        }
//    }
    public static int permutationCount(String s, int i){   // TC : O(n*n!)
        if(i == (s.length() - 1)){
            System.out.println(s);
            return 1;
        }
        int count = 0;
        for(int j = i; j < s.length(); j++){
            s = swap(s, i, j);
            count += permutationCount(s,i + 1);
            s = swap(s, i, j);
        }
        return count;
    }
    public static String swap(String s, int i, int j){
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
//        permute("ABC",0);
        List<String> res = permute2("ABC");
        System.out.println(res);
//        System.out.println(permutationCount("ABC",0)); // 6
//        permuteDistinct("ABB",0);
    }

    public static List<String> permute2(String s) {
        return permute2(s,0, new ArrayList<>());
    }
    private static List<String> permute2(String s, int i, List<String> list) {
        if(i == s.length() - 1) {
            list.add(s);
            return list;
        }
        for(int j = i; j < s.length(); j++) {
            s = swap(s, i, j); // here we disturb(change) the String so we have to fix it after completing operation
            permute2(s, i + 1, list);
            s = swap(s, i, j); // we re-swap the chars becoz it may disturb(change) original string
        }
        return list; // the local list should be return
    }
}
