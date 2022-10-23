package Java.Collection.map;
import java.util.LinkedHashMap;

/**
 * Use java_.Collection.Set: If you need group of unique elements.
 * Use List: If get operations are higher than any other operation.
 * Use Map: If objects contains the key and value pair.

 ---------------------------------------------------
 * LinkedHashMap -> maintain insertion order
 * TreeMap -> maintain ascending order
 * HashMap -> maintain any order(randomly)
 ---------------------------------------------------
 **/
//    Map(interface) <-- Hashmap(class) <-- LinkedHashMap(class)
public class _1basic {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> m=new LinkedHashMap<>();
        m.put(200,"Prajapati");
        m.put(100,"Jay");
        m.put(150,"Parth");
        m.put(250,"Yash");
        m.put(250,"Yash Prajapati");//

        m.remove(100);

        System.out.println(m);

        System.out.println(m.get(150));// if key is not present int java_.Collection.map than it returns null
        System.out.println(m.get(123));
    }
}
