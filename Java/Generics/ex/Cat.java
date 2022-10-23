package Java.Generics.ex;

public class Cat extends Animal{
    private String name;
    public Cat(String name){
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
