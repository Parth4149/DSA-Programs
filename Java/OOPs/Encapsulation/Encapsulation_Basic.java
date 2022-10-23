package Java.OOPs.Encapsulation;
/**
 // Encapsulation is data hiding(information hiding) while Abstraction is detailed hiding(implementation hiding).

 Encapsulation : Data hiding + Abstraction
 Data hiding : it prevents to access data members(Variables) directly from outside the class

 e.g. Bank Account, they declare balance variable as private for making your account safe so anyone cannot see your balance

 * It is considered good practice to declare your class attributes as private (as often as you can).
 * ensures better control of your data, because you (or others) can change one part of the code without affecting other parts
 * Increases security of data
 */

class Encapsulate {
    private String geekName;
    private int geekRoll;
    private int geekAge;

    public int getAge() {
        return geekAge;
    }
    public String getName() {
        return geekName;
    }
    public int getRoll() {
        return geekRoll;
    }
    public void setAge(int newAge) {
        geekAge = newAge;
    }
    public void setName(String newName) {
        geekName = newName;
    }
    public void setRoll(int newRoll) {
        geekRoll = newRoll;
    }
}

class TestEncapsulation {
    public static void main(String[] args) {
        Encapsulate obj = new Encapsulate();
        // setting values of the variables
        obj.setName("Harsh");
        obj.setAge(19);
        obj.setRoll(51);

        // Displaying values of the variables
        System.out.println("Geek's name: " + obj.getName());
        System.out.println("Geek's age: " + obj.getAge());
        System.out.println("Geek's roll: " + obj.getRoll());

        // Direct access of geekRoll is not possible due to encapsulation
    }
}
