package Sliding_Window;
import java.util.HashMap;
import java.util.HashSet;

public class _11 {
    public static int minimumWindowSubstring(String s, String t){
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
        while(j < s.length()){
            // calculation
            if(!m1.containsKey(s.charAt(j))){
                m1.put(s.charAt(j), 0);
            }
            m1.put(s.charAt(j), m1.get(s.charAt(j)) + 1);

            if(m1.size() < t.length()){
                j++;
            }

            else if(m1.size() == t.length()){
                if(m1.keySet().equals(m2.keySet())){
                    res = Math.min(res, (j - i + 1));
                } else{
                    m1.put(s.charAt(i), m1.get(s.charAt(i)) - 1); // decrement count
                    // if the count of i'th char is 0 ,we can say i'th char is not exist in curr window and remove it
                    if(m1.get(s.charAt(i)) == 0){
                        m1.remove(s.charAt(i));
                    }
                    i++;
                }
            }

            else if(m1.size() > t.length()){
                while(m1.size() > t.length()){
                    m1.put(s.charAt(i), m1.get(s.charAt(i)) - 1); // decrement count
                    // if the count of i'th char is 0 ,we can say i'th char is not exist in curr window and remove it
                    if(m1.get(s.charAt(i)) == 0){
                        m1.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        System.out.println(res);
//        System.out.println(m1.keySet().equals(m2.keySet()));
        return res;
    }
    public static void main(String[] args) {
        minimumWindowSubstring("abbcdaaacdbdbac","abcd");
    }
}
