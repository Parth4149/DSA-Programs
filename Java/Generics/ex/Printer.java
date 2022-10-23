package Java.Generics.ex;

public class Printer <T extends Animal> {
    T thingToPrint;
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    public void print(){
        thingToPrint.eat();
//        System.out.println(thingToPrint);
    }
}
