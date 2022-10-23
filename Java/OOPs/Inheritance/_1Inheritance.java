package Java.OOPs.Inheritance;
/**
  Terms used in java_.OOPs.Inheritance:

 * Inheritance : The capability of a class to derive properties from another class is called
 * parent/superclass : the class whose members are inherited is called parent/base/superclass
 * child/subclass : the class which inherits the members of another class is called child/derived/subclass
 * Reusability : we can reuse the fields and method of the existing class


 * Inheriting Constructors: A (child)subclass inherits all the members (fields, methods, and nested classes) from its superclass.
   Constructors are not members, so they are not inherited by subclasses, 


  Why use inheritance in java
 * For Method Overriding (so runtime polymorphism can be achieved).
 * For Code Reusability.
 */
class Bicycle {
    public int gear;
    public int speed;
    public static void dis() {
        System.out.println("parent");
    }
    public Bicycle(int gear, int speed){
        this.gear=gear;
        this.speed=speed;
    }
    public void applyBrake(int decrement) {
        speed-=decrement;
    }
    public void speedUp(int increment) {
        speed+=increment;
    }
    public String PrintInfo() {
        return ("No of gears are :"+gear+"\nSpeed of Bicycle is :"+speed);
    }
}
class MountainBike extends Bicycle {
    public int seatHeight;
    public static void dis() {
        System.out.println("child");
    }
    public MountainBike(int gear, int speed, int Height) {
        // Keyword super refers to the parent constructor, method or member
        super(gear, speed);
        seatHeight=Height;
    }
    public void seatHeight(int h) {
        seatHeight=h;
    }

    //overriding printInfo()
    public String PrintInfo() {
        return (super.PrintInfo()+"\nHeight of seat is :"+seatHeight);
        //if we want to access superclass(base) method PrintInfo() then use super.PrintInfo()
    }
}
public class _1Inheritance {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(5, 100, 25);

        System.out.println(mb.PrintInfo()+"\n");
        mb.speedUp(20);
        mb.seatHeight(22);

        MountainBike.dis();
        Bicycle.dis();
    }
}