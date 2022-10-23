package Java.Mini_Projects._1OOP;

public class DeluxeHamberger extends Hamburger {
    private String DeluxExtra1Name;
    private double DeluxExtra1Price;

    private String DeluxExtra2Name;
    private double DeluxExtra2Price;
    public DeluxeHamberger( double price) {
        super("Deluxe", "Black rye", price);
    }
    public void addDeluxExtra1(String DeluxExtra1Name,double DeluxExtra1Price){
        this.DeluxExtra1Name =DeluxExtra1Name;
        this.DeluxExtra1Price =DeluxExtra1Price;
    }
    public void addDeluxExtra2(String DeluxExtra2Name,double DeluxExtra2Price){
        this.DeluxExtra2Name =DeluxExtra2Name;
        this.DeluxExtra2Price =DeluxExtra2Price;
    }
    @Override
    public double itemizeHamburger() {
        double hamburgerPrice=super.itemizeHamburger();
        if(this.DeluxExtra1Name!=null){
            hamburgerPrice+=DeluxExtra1Price;
            System.out.println("Added "+this.DeluxExtra1Name+" for extra "+this.DeluxExtra1Price);
        }
        if(this.DeluxExtra2Name!=null){
            hamburgerPrice+=DeluxExtra2Price;
            System.out.println("Added "+this.DeluxExtra1Name+" for extra "+this.DeluxExtra1Price);
        }
        return hamburgerPrice;
    }
}
