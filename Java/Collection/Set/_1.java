package Java.Collection.Set;
import java.util.HashSet;

//A java_.Collection.Set is a Collection that cannot contain duplicate elements.
public class _1 {
    public static void main(String[] args) {
        HashSet<Integer> s=new HashSet<>();
        s.add(10);
        s.add(10);
        s.add(20);
        s.add(15);
        System.out.println(s);
        System.out.println(s.contains(20));
    }
}
