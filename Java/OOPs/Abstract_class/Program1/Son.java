package Java.OOPs.Abstract_class.Program1;

public class Son extends Parent{// child class cannot extend multiple Parent class

    public Son(int age) {
        super(age);
    }

    @Override
    void print() {
        System.out.println("I am "+super.age);
        System.out.println("I am a explorer");
//        super.display();// we can invoke Parent's display method using super keyword, we cannot invoke outside the method
    }

    @Override
    void career() {
        System.out.println("I am going to become Software Developer");
    }
}
