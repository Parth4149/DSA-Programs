package Java.OOPs.Abstract_class.Program1;

public abstract class Parent {
    int age;
    public Parent(int age){// we cannot create abstract constructor
        this.age=age;
    }
    abstract void print();
    abstract void career();
    public void display(){// this method cannot be overridden by child class
        System.out.println("display : Parent class");
    }
}