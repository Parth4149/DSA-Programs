package Java.Mini_Projects._1OOP;

public class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private double healthyExtra1Price;

    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(double price) {
        super("Healthy","Brown rye",price);
    }

    public void addhealthyExtra1(String healthyExtra1Name,double healthyExtra1Price){
        this.healthyExtra1Name=healthyExtra1Name;
        this.healthyExtra1Price=healthyExtra1Price;
    }
    public void addhealthyExtra2(String healthyExtra2Name,double healthyExtra2Price){
        this.healthyExtra2Name=healthyExtra2Name;
        this.healthyExtra2Price=healthyExtra2Price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice=super.itemizeHamburger();
        if(this.healthyExtra1Name!=null){
            hamburgerPrice+=healthyExtra1Price;
            System.out.println("Added "+this.healthyExtra1Name+" for extra "+this.healthyExtra1Price);
        }
        if(this.healthyExtra2Name!=null){
            hamburgerPrice+=healthyExtra2Price;
            System.out.println("Added "+this.healthyExtra1Name+" for extra "+this.healthyExtra1Price);
        }
        return hamburgerPrice;
    }
}
