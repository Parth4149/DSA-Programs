import java.util.Arrays;

public class _4RopeCuttingProblem {
    // Recursion
/**
    public static int getMaxPieces(int n, int a, int b, int c) { // time : O(3^n)
        // base condition
        if(n == 0)
            return 0;
        if(n < 0)
            return Integer.MIN_VALUE;

        int x = getMaxPieces(n - a, a, b, c) + 1;
        int y = getMaxPieces(n - b, a, b, c) + 1;
        int z = getMaxPieces(n - c, a, b, c) + 1;

        return Math.max(x, Math.max(y, z)); // max(x,y,z)
    }
    public static int maxPieces(int n, int a, int b, int c) {
        int result = getMaxPieces(n,a,b,c);
        return result < 0 ? -1: result;
    }
*/
    // Top-down Memoization
/*
    private static int[] t;
    public static int getMaxPieces(int n, int a, int b, int c) {
        // base condition
        if(n == 0)
            return 0;
        if(n < 0)
            return Integer.MIN_VALUE;

        if(t[n] != -1) { // If already memoized
            return t[n];
        }

        int x = getMaxPieces(n - a, a, b, c) + 1;
        int y = getMaxPieces(n - b, a, b, c) + 1;
        int z = getMaxPieces(n - c, a, b, c) + 1;

        t[n] = Math.max(x, Math.max(y, z)); // max(x,y,z)
        return t[n];
    }
    public static int maxPieces(int n, int a, int b, int c) {
        // Initialize 1D array t
        t = new int[n + 1];

        // Initialize all the eles -1
        Arrays.fill(t, -1);

        int result = getMaxPieces(n,a,b,c);

        return result < 0 ? -1: result;
    }
*/

    // Bottom-up Tabulation   TC : O(n)  SC : O(n)
    public static int maxPieces(int n, int a, int b, int c) {
        int[] t = new int[n + 1];
        // Initialize base condition
        t[0] = 0;

        for(int i = 1; i <= n; i++) {
            int res = -1;
            if((i - a) >= 0) {
                res = Math.max(res, t[i - a] + 1);
            }
            if((i - b) >= 0) {
                res = Math.max(res, t[i - b] + 1);
            }
            if((i - c) >= 0) {
                res = Math.max(res, t[i - c] + 1);
            }
            t[i] = res;
        }
        return t[n];
    }


    public static void main(String[] args) {
//        System.out.println(maxPieces(5,2,1,5)); // 5
//        System.out.println(maxPieces(8,3,3,3));//
        System.out.println(maxPieces(8,2,3,5)); // 4
    }
}
