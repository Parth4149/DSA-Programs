package Java.Generics;

import Java.Generics.ex.*;

import java.util.ArrayList;
import java.util.List;

public class WildCardExample {
    /**
     * with the help of wild card we can pass and accept any type of parameter
     * here printList can accept any type of Object or Wrapper class
     */
    public static void printList(List<?> myList){   // here ? is a wild card
        System.out.println(myList);
    }

    public static void printAnimalList(List<? extends Animal> myList){   // here ? accept only Animal and their child class
        for(Animal list : myList){
            list.eat();
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        printList(integerList);

        List<String> list = new ArrayList<>();
        list.add("Parth");
        list.add("Nirav");
        list.add("Nikhil");
        printList(list);


        List<Animal> animalList = new ArrayList<>();          // package ex
        animalList.add(new Cat("Sheru"));
        animalList.add(new Dog("Mox"));

        printAnimalList(animalList);

    }
}
