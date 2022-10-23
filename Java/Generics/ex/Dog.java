package Java.Generics.ex;

public class Dog extends Animal{
    private String name;
    public Dog(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(name+" is eating");
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
