package Java.Collection.map;

import java.util.HashMap;
import java.util.Map;

public class _2_1HashMap { // time complexity : O(1) most of all operation in HashMap
    public static void main(String[] args) {
        HashMap<String,Integer> m=new HashMap<>();//
        m.put("gfg",10);
        m.put("udemy",20);
        m.put("youtube",40);
        m.put("courcera",30);
        System.out.println(m);
        System.out.println(m.size());
        for(Map.Entry<String,Integer> e: m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        System.out.println("\n");
        for(HashMap.Entry<String,Integer> i: m.entrySet()){
            System.out.println(i);
        }
    }
}
