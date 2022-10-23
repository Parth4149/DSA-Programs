package Java.Collection.ArrayList.Challenge__2;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transaction;

    public Customer(String name,double initialTransaction){
        name=name.toUpperCase();
        this.name=name;
        transaction=new ArrayList<Double>();
        AddTransaction(initialTransaction);
    }

    public void AddTransaction(double amount){
        this.transaction.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }
}
