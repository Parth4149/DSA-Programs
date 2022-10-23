package Java.OOPs.Abstract_class;
/**
 // Encapsulation is data hiding(information hiding) while Abstraction is detailed hiding(implementation hiding).

  Abstraction:
 * Abstraction is a process of hiding the implementation details and showing only functionality to the user
 * Another way, it shows only essential(relevant) things to the user and hides the internal details
 * e.g. I send email to my friend,then I cannot see the internal processing about the email delivery


  Abstract Class:
 * it can have abstract and non-abstract method (abstract,public,static,final)
 * it can have public, final, non-final, static and non-static variables
 * it can have constructor, but it cannot be instantiated
 * Abstract class can provides implementation of Interface but Interface cannot provide implementation of Abstract class

  Advantages:
 * increases reusability
 * increases security of an application or program (as only important details are provided to the user)
 **/
abstract class A {
    public int a = 20;
    public void print() {
        System.out.println("abstract class A : "+a);
    }
    public abstract void display();
}
class B extends A {
    @Override
    public void display() {
        System.out.println(a);
    }
}
class Main1 {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();
        obj.display();
    }
}