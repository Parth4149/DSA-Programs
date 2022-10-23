package Java.Mini_Projects.List;

import java.util.LinkedList;
import java.util.ListIterator;

public class _1basic {
    public static void main(String[] args) {
        LinkedList<String> ll=new LinkedList<>();
        ll.add("parth");
        ll.add("jeet");
        ll.add("videy");
        ll.add("ayush");
//        for(int i=0; i<ll.size(); i++){
//            System.out.println(ll.get(i));
//        }
//        for(String i: ll){ // another way
//            System.out.println(i);
//        }
        printList(ll); // another way
    }
    private static void printList(LinkedList<String> ll){
//        Iterator<String> it=ll.iterator();// it works like a singly linked list
        ListIterator<String> it=ll.listIterator();//it works like a doubly linked list
        while(it.hasNext()){
        System.out.println(it.next());// it++
        }
        System.out.println();
//        for(String i:ll){
//            System.out.println(i);
//        }
    }
}
