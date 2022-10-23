package Java.Lambda;

class Cat implements Printable{
    String name;
    @Override
    public void print(String prefix,String suffix){
        System.out.println("Meow");
    }
}

public class Exmple {
    public static void printThing(Printable print){
        print.print("@","#");
    }
    public static void main(String[] args) {
        Cat cat = new Cat();
        printThing(cat);  // Meow

        // -> lambda , here we can pass a method as argument
        printThing((p,s) -> System.out.println("I am Lambda")); // direct pass

        Printable lambdaPrintable = (pre,suf) -> System.out.println("I am Software Engineer");
        printThing(lambdaPrintable);

        Printable lambdaPrintable2 = (prefix,suffix) -> System.out.println(prefix+"DSA_and_Project"+suffix);
        printThing(lambdaPrintable2);

//        printThing(
//                () -> {
//                    System.out.println("I am Lambda");
//                }
//        );

    }
}
