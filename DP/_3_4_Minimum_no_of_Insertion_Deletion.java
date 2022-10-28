package DP;

import static DP._3_0_LCS.lcs;

// Minimum number of deletions and insertions to transform(convert) one string into another
public class _3_4_Minimum_no_of_Insertion_Deletion {
    public static void printMinDelAndInsert(String X, String Y) { // TC : O(m*n) , SC : O(m*n) , Optimized : O(n)
        // No. of deletion = length of X - lcs
        // No. of insertion = length of Y - lcs

        int m = X.length(), n = Y.length();
        int l = lcs(X,Y,m,n);

        System.out.println("Minimum number of deletion : " + (m - l));
        System.out.println("Minimum number of insertion : " + (n - l));
    }

    public static void main(String[] args) {
        // convert X -> Y , find out how many minimum number of insertion & deletion required
//        String X = "heap";
//        String Y = "pea";
        String X = "geeksforgeeks";
        String Y = "geeks";
        printMinDelAndInsert(X,Y);
    }

/*

->  I/P : str1 = "heap", str2 = "pea"
    O/P : Minimum Deletion = 2 and Minimum Insertion = 1

    Explanation:
    p and h deleted from heapThen, p is inserted at the beginning One thing to note, though p was required yet
    it was removed/deleted first from its position, and then it is inserted to some other position.
    Thus, p contributes one to the deletion_count and one to the insertion_count.

->  I/P  : str1 = "geeksforgeeks", str2 = "geeks"
    O/P : Minimum Deletion = 8
          Minimum Insertion = 0
*/
}
