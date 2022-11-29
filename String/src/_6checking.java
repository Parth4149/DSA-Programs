import java.util.Scanner;

// checking P anagram
// if all the alphabets(26) are present in Input String then it will print "yes"
public class _6checking {
    static boolean isPentagram(String str) {
        if (str.length() < 26) {
            return false;
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x >= 'a' && x <= 'z') {
                visited[x - 'a'] = true;//
            }
            if (x >= 'A' && x <= 'Z') {
                visited[x - 'A'] = true;//
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "the quick brown fox jumps over the lazy dog";
//        String s = "Abcba";
        if (isPentagram(s)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}