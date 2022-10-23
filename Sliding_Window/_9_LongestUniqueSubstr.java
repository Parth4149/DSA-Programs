package Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;

// Longest Unique Substring (without repeating chars)
public class _9_LongestUniqueSubstr {
/**
    // Using HashSet
    public static int longestUniqueSub(String s){  // TC : O(n) , SC : O(res)
        int i = 0, j = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(set.contains(s.charAt(j))){
                res = Math.max(res, set.size());
                set.removeAll(set);
            }
            set.add(s.charAt(j));
            j++;
        }
        return res;
    }
*/
    // Using HashMap
    public static int longestUniqueSub(String s){ // TC : O(n) , SC : O(m), m is no. of unique chars
        int i = 0, j = 0, res = 0;
        HashMap<Character,Integer> m = new HashMap<>();
        while(j < s.length()){
            // Calculation
//            if(!m.containsKey(s.charAt(j))){
//                m.put(s.charAt(j), 0);
//            }
            m.putIfAbsent(s.charAt(j), 0);
            m.put(s.charAt(j), m.get(s.charAt(j)) + 1); // increment count

            // in this case m.size never > curr window size
            // m.size < window size then we can say duplicate char exist in map
            if(m.size() < (j - i + 1)){
              // after each pass it reduces the curr window size
                while(m.size() < (j - i + 1)){
                    m.put(s.charAt(i), m.get(s.charAt(i)) - 1);
                    if(m.get(s.charAt(i)) == 0){
                        m.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
            else if(m.size() == (j - i + 1)){
                res = Math.max(res, (j - i + 1));
                j++;
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++) {
            // here we make false all previous elements if j'th char exist in arr
            while(exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max( maxLen, (j - i + 1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueSub("abbcaeef"));// 4 bcae
        System.out.println(longestUniqueSub("abcbamnmn"));// 5


//        System.out.println(lengthOfLongestSubstring("thequickbrownfoxjumpsoverthelazydog"));
//        System.out.println(lengthOfLongestSubstring("abcbamnmn"));
        System.out.println(lengthOfLongestSubstring("abbcaeef"));//4
    }

}
