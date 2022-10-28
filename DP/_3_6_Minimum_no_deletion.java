package DP;

import static DP._3_5_Longest_Palindromic_Subsequence.LPS;

// Minimum no. of deletion in a string to make it palindrome
public class _3_6_Minimum_no_deletion {

    public static int minimumDeletion(String s) {
        return s.length() - LPS(s);
    }

    public static void main(String[] args) {
        String s = "agbcba";
        int result = minimumDeletion(s);
        System.out.println(result);
    }
}
