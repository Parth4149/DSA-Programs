package Java.OOPs.Inheritance;

class A {
    String name;
    int number;
    A(int number,String name) {
        this.number = number;
        this.name = name;
    }
    void display() {
        System.out.println(number+" "+name);
    }
}
class B extends A{
    B(int number,String name) {
        super(number,name);
    }
}
class C extends A {
    C(int number,String name) {
        super(number,name);
    }
}
class Main{
    public static void main(String[] args) {
        B b = new B(10,"Amazon");
        C c = new C(20,"Google");
        b.display();
        c.display();
    }
}