package Java.OOPs.Abstract_class.Program1;

public class Main {
    public static void main(String[] args) {
        Son s=new Son(19);
        s.print();
        s.career();
        System.out.println();

        Parent p=new Son(20);
        p.print();
        p.career();
        System.out.println();

        p.display();// if display is non-static method then we can invoke this method using p.display();
//        Parent.display();// if display is static method then we can invoke this method using Parent.display();
    }
}
