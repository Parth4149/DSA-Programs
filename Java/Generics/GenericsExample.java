package Java.Generics;

public class GenericsExample implements Comparable<GenericsExample>{
    String name;
    int marks;
    public GenericsExample(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(GenericsExample o) {
        return (int)(this.marks - o.marks);
    }

    public static void main(String[] args) {
        GenericsExample s1 = new GenericsExample("Parth",8);
        GenericsExample s2 = new GenericsExample("Nirav",10);

        if(s1.compareTo(s2) < 0){
//            System.out.println(s1.compareTo(s2));
            System.out.println("Nirav has more marks");
        }

    }
}
