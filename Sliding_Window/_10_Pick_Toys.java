package Sliding_Window;

import java.util.HashMap;
/**
 // Problem:
 * Child and Parent are in a mall
 * child wants to purchase toys (child convinces to parent)
 * Then Parent agrees with child if and only if child follow 2 condition
    1. child pick toys in consecutive sequence
    2. child only takes two types of toys
        e.g.   [car,animal,car,ball,car,car,animal,ball]
        O/P : [car,ball,car,car] = 4
 * */
public class _10_Pick_Toys {
    // Similar to longest Substring
    public static int pickToys(String s){ //TC : O(n) + O(n) = O(2n) = O(n) , here second O(n) for while loop, TC : O(k+1) here k is 2
        int i = 0, j = 0, res = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        while(j < s.length()){
            // calculation
            if(!m.containsKey(s.charAt(j))){
                m.put(s.charAt(j), 0);
            }
            m.put(s.charAt(j), m.get(s.charAt(j)) + 1);

            if(m.size() < 2){ // here k is 2
                j++;
            }
            else if(m.size() == 2){
                res = Math.max(res, (j - i + 1));
                j++;
            }
            else { // m.size() > 2
                while(m.size() > 2){
                    m.put(s.charAt(i), m.get(s.charAt(i)) - 1);// decrement count
                    if(m.get(s.charAt(i)) == 0){
                        m.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
//        System.out.println(pickToys("abaccab"));// 4
    }
}
