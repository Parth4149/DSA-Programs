package Java.Generics.ex;

public class Main {
    public static void main(String[] args) {
        Printer<Cat> catPrinter = new Printer<>(new Cat("Sheru"));
        catPrinter.print();

        Printer<Dog> dogPrinter = new Printer<>(new Dog("Jonny"));
        dogPrinter.print();

//        Printer<Animal> animalPrinter = new Printer<>(new Animal());
//        animalPrinter.print();
    }
}
