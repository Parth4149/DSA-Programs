package Java.Collection.ArrayList;

import java.util.ArrayList;

class sample {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("Parth");
        a.add("Nirav");
        a.add("Raj");
        System.out.println(a);

        a.set(1,"Patel");// modify an element
        remove(a,"Parth");
        System.out.println(a);

    }

    static void remove(ArrayList<String> arr,String s){
        int position=arr.indexOf(s);
        if(position>=0){
            arr.remove(position);
        }
    }
}