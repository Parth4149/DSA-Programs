package Java.Collection.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap time complexity
 * get() : O(1)
 * put() : O(1)
 * size() : O(1)
 * isEmpty() : O(1)
 * containsKey() : O(1)
 * containsValue() : O(n)
 **/
public class _3_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> m=new LinkedHashMap<>(2,1,true);
        m.put(20,"gfg");
        m.put(10,"udemy");
        System.out.println(m);
        m.put(30,"courcera");
        System.out.println(m);
    }
}
