package DP;

// Minimum number of deletions and insertions to transform(convert) one string into another
public class _3_4_Minimum_no_of_Insertion_Deletion {
    public static void printMinDelAndInsert(String X, String Y) { // TC : O(m*n) , SC : O(m*n) , Optimized : O(n)
        // No. of deletion = length of X - lcs
        // No. of insertion = length of Y - lcs

        int m = X.length(), n = Y.length();
        int l = lcs(X,Y,m,n);

        System.out.println("Minimum number of deletion : "+(m - l));
        System.out.println("Minimum number of insertion : "+(n - l));
    }
    public static int lcs(String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for(int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for(int i = 0; i <= m; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return t[m][n];
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
