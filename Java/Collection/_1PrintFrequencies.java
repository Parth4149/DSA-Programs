package Java.Collection;

import java.util.LinkedHashMap;
import java.util.Map;
public class _1PrintFrequencies {
    public static void printFrequencies(int[] arr){// time : theta(n), space : O(n)
        LinkedHashMap<Integer,Integer> m=new LinkedHashMap<>();
        for(int i=0; i<arr.length; i++){
            m.put(arr[i], m.getOrDefault(arr[i],0)+1);// if key is not present then it returns default value 0
        }                                                        // otherwise it returns value
        for(Map.Entry<Integer,Integer> x: m.entrySet()){
            System.out.println(x.getKey()+"  "+x.getValue());
        }
    }
    public static void main(String[] args) {
        int[] arr={20,10,5,20,5,20};
        printFrequencies(arr);
    }
}
