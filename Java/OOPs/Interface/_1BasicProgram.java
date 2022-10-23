package Java.OOPs.Interface;// IS-A relationship
/**
 * An interface is a blueprint of a class.
 * all the interface methods are implicitly public and abstract
 * all variables defined in an interface are public,static and final
 * it cannot be instantiated

 uses & advantages:
 * it is used to achieve multiple inheritance
 * achieve total abstraction
*/
interface Shape {
//     static final double PI;// Declaration of any instance variable is NOT allowed
    double PI = (double)22/7;// Initialization of variable is necessary
    double area();//Abstract method do not specify body
    double perimeter();//by default this method are public or Abstract
    default void print(){
        System.out.println(PI);// only default and static method can specify body
    }
    static void display(){
        System.out.println("i am in shape");
    }
}
// override means it depends upon object because runtime polymorphism
// static method cannot be overridden because static method does not depend on object
class Circle implements Shape {

    public int b=20;
    private final double r;
    Circle(double r){
        this.r=r;
    }
    @Override
    public double area() {
        return PI*r*r;
    }
    @Override
    public double perimeter() {
        return 2*PI*r;
    }
}
class Rectangle implements Shape {
    private final double length;
    private final double width;
    Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    @Override
    public double area() {
        return length*width;
    }

    @Override
    public double perimeter() {
        return 2*(length+width);
    }
}
class Geometry {
    public static void main(String[] args) {
        Circle c=new Circle(1.0);
        Rectangle r=new Rectangle(1.0,1.0);

        c.print();// obj of circle can call (interface)Shape's print method
//        c.display();//Static method may be invoked on containing interface class only
        Shape.display();//call via interface name

        Shape shape;
        shape=c;// The local variable shape may not have been initialized
//        System.out.println(shape.b);// we cannot access child(Circle)'s variables & methods
        display(shape.area(),shape.perimeter());

        shape=r;
        display(shape.area(),shape.perimeter());
    }
    static void display(double a,double p){
        System.out.println("Area : "+a+"\tPerimeter : "+p);
    }
}
