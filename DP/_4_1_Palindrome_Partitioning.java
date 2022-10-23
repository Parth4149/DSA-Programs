package DP;

// Find the minimum no. of partition

//    Create a recursive function that takes i and j as parameters that determines the range of a group.
//  * Iterate from k = i to j to partition the given range into two groups.
//  * Call the recursive function for these groups.
//  * Return the minimum value among all the partitions

import java.util.Arrays;

public class _4_1_Palindrome_Partitioning {
    // Recursive    TC : O(2^n) , SC : O(h) where h is  the height of the recursion stack
/*
    public static int minPalPartition(String s, int i, int j) {
        // base condition
        // if there is only 1 char in string, i don't need to partition becoz empty str & 1 char are already palindrome
        if(i >= j) {
            return 0;
        }

        // if string is already palindrome, i don't need to partition str
        if(isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // Iterating from i to j - 1
        for(int k = i; k <= j - 1; k++) {
            int tempAns = 1 + minPalPartition(s, i , k) + minPalPartition(s, k + 1, j);
            min = Math.min(min, tempAns);
        }
        return min;
    }
*/
    public static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int t[][];
/*
    public static int minPalPartition(String s, int i, int j) {
        // base condition
        // if there is only 1 char in string, i don't need to partition becoz empty str & 1 char are already palindrome
        if(i >= j) {
            return 0;
        }

        // if string is already palindrome, i don't need to partition str
        if(isPalindrome(s, i, j)) {
            return 0;
        }

        if(t[i][j] != -1) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;
        // Iterating from i to j - 1
        for(int k = i; k <= j - 1; k++) {
            int tempAns = 1 + minPalPartition(s, i , k) + minPalPartition(s, k + 1, j);
            min = Math.min(min, tempAns);
        }
        t[i][j] = min;
        return t[i][j];
    }
*/
    // Optimized
    public static int minPalPartition(String s, int i, int j) {
        // base condition
        // if there is only 1 char in string, i don't need to partition becoz empty str & 1 char are already palindrome
        if(i >= j) {
            return 0;
        }

        // if string is already palindrome, i don't need to partition str
        if(isPalindrome(s, i, j)) {
            return 0;
        }

        if(t[i][j] != -1) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;
        // Iterating from i to j - 1
        for(int k = i; k <= j - 1; k++) {
            int left, right;

            if(t[i][k] != -1) {
                left = t[i][k];
            } else {
                left = minPalPartition(s, i, k);
                t[i][j] = left;
            }

            if(t[k + 1][j] != -1) {
                right = t[i][k];
            } else {
                right = minPalPartition(s, k + 1, j);
                t[i][j] = right;
            }

            int tempAns = 1 + left + right;
            min = Math.min(min, tempAns);
        }
        t[i][j] = min;
        return t[i][j];
    }

    public static void main(String[] args) {
//        String s = "nitin"; // 0    already palindrome
        String s = "aaabba"; // 1     a | aabaa
        int i = 0, j = s.length() - 1;
        int n = s.length();
        t = new int[n][n];
        //  initialize all the cells(elements) -1
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
//        for(int[] row: t) {
//            Arrays.fill(row, -1);
//        }

        int result = minPalPartition(s, i, j);
        System.out.println(result);
    }
/*
Input : str = “geek”
Output : 2
We need to make minimum 2 cuts, i.e., “g ee k”

Input : str = “abcba”
Output : 0
The string is already a palindrome.
*/
}
