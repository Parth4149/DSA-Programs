package Java.Static;

/**
 * The static keyword is mainly used for memory management
 * It is used for a constant variable or a method that is the same for every instance of a class.

 * A static method can be invoked without instance(object) of a class.
 * static method can access static data member (and can change the value of it.)

 * static methods can be overloaded
 * static method cannot be overridden because static method does not depend on object

 Java static block:
 * Is used to initialize the static data member.
 * It is executed before main method

 * */


// Java program to demonstrate execution of static blocks and variables
public class Static{
    static int a = m1();    // static variable

    // static block
    static{
        System.out.println("Inside static block");
    }
    static int m1(){     // static method
        System.out.println("from m1");
        return 20;
    }

    // static method(main !!)
    public static void main(String[] args) {
        System.out.println("Value of a : "+a);
    }
}
/*
  from m1
  Inside static block
  Value of a : 20
 */