package Java.Collection.map;

import java.util.HashMap;

public class _2_2 {
    public static void main(String[] args) {
        HashMap<String,Integer> m=new HashMap<>();//
        m.put("gfg",10);
        m.put("udemy",20);
        m.put("youtube",40);
        m.put("courcera",30);

        if(m.containsKey("youtube"))
            System.out.println("yes");
        else
            System.out.println("no");

        System.out.println(m.remove("youtube"));// it removes key and returns value
        System.out.println(m.size());

        if(m.containsValue(20))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
