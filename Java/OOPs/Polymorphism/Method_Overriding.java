package Java.OOPs.Polymorphism;
/**

  Method Overriding (Runtime polymorphism OR Dynamic method dispatch):
 * A method can be overridden
 * data members cannot be overridden, so runtime polymorphism can't be achieved by data members.
 * override means it depends upon the object because runtime polymorphism
 * static method cannot be overridden because static method does not depend on object

 --------------------------------------------------------------------------------------------------------------
  What is Compile time and Runtime:
 * Compile time is the period when the programming code is converted into the machine code
 * Runtime is the period of time when a program is running and generally occurs after compile time
 */
class Parent {
    void Print(){
        System.out.println("parent class");
    }
    public void display() {
        System.out.println("This is parent class");
    }
}

class Child1 extends Parent {
    void Print() {
        System.out.println("subclass1");
    }
}

class Child2 extends Parent {
    void Print() {
        System.out.println("subclass2");
    }
}

class GFG {
    public static void main(String[] args) {
        Parent a;
        a = new Child1();// if subclass not having Print() method then it considers parent class's Print() method
        a.Print();
/* In the above program, The 'a' is a reference of Parent type and refers to an object of child class.
In Java, functions are virtual by default. So the run time polymorphism happens and derived fun() is called. */

        a = new Child2();
        a.Print();

        Child1 s1=new Child1();
        s1.display();// child class can access members of parent class but parent class can not access members of child class

//        subclass1 s1=new Parent();
//        error : Incompatible types. Found: 'Parent', required: 'subclass1'
//        Parent cannot be converted to subclass1
    }
}
