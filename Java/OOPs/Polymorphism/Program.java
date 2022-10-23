package Java.OOPs.Polymorphism;

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot(){
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class ThreeIdiots extends Movie {
    public ThreeIdiots() {
        super("Three Idiots");
    }
    public String plot(){
        return "Story of an engineer";
    }
}
class Super30 extends Movie {
    public Super30() {
        super("Super 30");
    }
    public String plot(){
        return "Story of brilliant 30 students";
    }
}
class Uri extends Movie {
    public Uri() {
        super("Uri");
    }
    public String plot(){
        return "Surgical Strike";
    }
}
class Manji extends Movie {
    public Manji() {
        super("Manji");
    }
    public String plot(){
        return super.plot();
    }
}
class SocialNetwork extends Movie {
    public SocialNetwork() {
        super("Social Network");
    }
    public String plot(){
        return "Success of Facebook";
    }
}

public class Program {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            Movie movie=randomMovie();
//            assert movie != null;
            System.out.println("Movie #"+i+" : "+movie.getName()+"\nPlot : "+movie.plot()+"\n");
        }
    }
    public static Movie randomMovie(){
        int randomNumber = (int)(Math.random()*5 + 1);// it returns random number (1 to 5)
        System.out.println("Random number generated was : "+randomNumber);
        return switch (randomNumber) {
            case 1 -> new ThreeIdiots();// return new object (return type is Movie)
            case 2 -> new SocialNetwork();
            case 3 -> new Super30();
            case 4 -> new Uri();
            case 5 -> new Manji();
            default -> null;
        };
    }
}
