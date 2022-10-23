package Sliding_Window;
import java.util.HashMap;
import java.util.HashSet;

// Longest Substring with K Unique Characters (find length of the longest substring with k unique chars)
public class _8_LongestSubstring {
    public static int LongestSubstring(String str, int k) {
        if(str.length() < k){
            return 0;
        }
        int i = 0, j = 0, res = 0;
        HashMap<Character,Integer> m = new HashMap<>();
        //here map size indicate no. of unique chars
        while(j < str.length()) {
            // calculation
            if(!m.containsKey(str.charAt(j))) {
                m.put(str.charAt(j), 0);
            }
            m.put(str.charAt(j), m.get(str.charAt(j)) + 1);

            if(m.size() < k) {
                j++;
            }

            // m.size() hits the target(window size) then we update the res if curr window len > res
            else if(m.size() == k) {
                res = Math.max(res, (j - i + 1));
                j++;
            }

            else {  // m.size() > k
                // here size > k we have to remove element until size == k
                while(m.size() > k){
                    m.put(str.charAt(i), m.get(str.charAt(i)) - 1);  // decrement count
                    // At one position count will be zero then we remote it
                    if(m.get(str.charAt(i)) == 0){
                        m.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
            // we increment j in all cases
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(LongestSubstring("aabacbebebe", 3)); // 7 cbebebe
        System.out.println(LongestSubstring("abccbop", 3)); //5 abccb
        System.out.println(LongestSubstring("aaabb", 3)); //3
    }
}
