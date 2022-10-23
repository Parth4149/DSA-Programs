package Java.Generics;
public class GenericsMethod {
    public static <T, V> void shout(T thingToShout, V otherThingToShout){
        System.out.println(thingToShout+"\t"+otherThingToShout);
    }
    public static <T> T shout(T thingToShout){
        System.out.println(thingToShout);
        return thingToShout;                        // return generics type
    }
    public static void main(String[] args) {
        shout("Parth",124);
        shout("Software Engineer",12.33);

        shout("I am fire");

    }
}
