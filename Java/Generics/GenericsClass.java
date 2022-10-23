package Java.Generics;

/**
 * Generics is a concept in java where you can enable a class, interface and method accept all(reference) type as parameter
 * in other word, it is the concept which enables the users to choose the reference type that a method, dynamically.
 */

class Printer <T> { // generics class
    T thingToPrint;
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    public void print(){
        System.out.println(thingToPrint);
    }
    static void display(){
        System.out.println(124);
    }
}

class Main {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(124);
        printer.print();

        Printer<String> printer2 = new Printer<>("Parth");
        printer2.print();
    }
}
