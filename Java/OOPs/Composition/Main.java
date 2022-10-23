package Java.OOPs.Composition;

public class Main {
    // constructor and Getter method
    // private members access through Getter method
    public static void main(String[] args) {
        Wall wall1=new Wall("North");
        Wall wall2=new Wall("South");
        Wall wall3=new Wall("East");
        Wall wall4=new Wall("West");

        Ceiling ceiling=new Ceiling(10,"Blue");

        Bed bed=new Bed("Modern",3,2);

        Lamp lamp=new Lamp("LED",false,4);

        Bedroom bedroom=new Bedroom("Parth",wall1,wall2,wall3,wall4,ceiling,bed,lamp);
        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }
}
