package DP;
import static DP._3_5_Longest_Palindromic_Subsequence.LPS;

// Minimum number of insertion in a String to make it palindrome
// [note]  no. of deletion = no. of insertion
public class _3_9_Minimum_no_of_insertion {

    public static int minInsertion(String s) {
        return s.length() - LPS(s);
    }
    public static void main(String[] args) {
        String s = "aebcbda"; // a e(d) bcb d(e) a   // () inserted chars
        int result = minInsertion(s);
        System.out.println(result);
    }
}
