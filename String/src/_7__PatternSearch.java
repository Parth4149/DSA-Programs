import java.util.Scanner;

/**
 * Pattern Searching Problem (Rabin-Karp Algorithm)
 */
public class _7__PatternSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input text : ");
        String txt = sc.nextLine();
        System.out.print("Input pattern : ");
        String pat = sc.nextLine();
        PattenSearch(txt, pat);
    }

    public static void PattenSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int h = 1, d = 100;
        for (int i = 0; i < m - 1; i++) {// compute : d^m-1
            h = h * d;
        }
        int p = 0, t = 0, q = 10000;
        for (int i = 0; i < m; i++) {// compute p and to
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }
        for (int i = 0; i <= m - n; i++) {
            if (p == t) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.print(i + " ");
                }
            }
            if (i < m - h) {
                t = (((t - txt.charAt(i)) * d) + txt.charAt(i + m)) % q;
            }
            if (t < 0) {
                t = t + q;
            }
        }
    }

}

