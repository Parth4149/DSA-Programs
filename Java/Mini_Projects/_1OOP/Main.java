package Java.Mini_Projects._1OOP;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger=new Hamburger("Maharaja","White",2.5);
        hamburger.addHamburgerAddition1("lettuce",3);
        hamburger.addHamburgerAddition2("tomato",2);
        hamburger.addHamburgerAddition3("carrot",2.5);
        hamburger.addHamburgerAddition4("tiki",4);

        System.out.println("Total Burger price : "+hamburger.itemizeHamburger()+"\n");

        HealthyBurger healthyBurger=new HealthyBurger(4);
        healthyBurger.addhealthyExtra1("Butter",3);
        healthyBurger.addhealthyExtra2("Cheese",3);
        System.out.println("Total Healthy Hamburger price : "+healthyBurger.itemizeHamburger()+"\n");

        DeluxeHamberger deluxeHamberger=new DeluxeHamberger(5);
        deluxeHamberger.addDeluxExtra1("Mionise",3);
        deluxeHamberger.addDeluxExtra2("Double Cheese",5);
        System.out.println("Total Healthy Hamburger price : "+deluxeHamberger.itemizeHamburger());
    }
}
