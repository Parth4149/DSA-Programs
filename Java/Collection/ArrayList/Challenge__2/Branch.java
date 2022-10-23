package Java.Collection.ArrayList.Challenge__2;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers=new ArrayList<>();

    public Branch(String name) {
        this.name = name;
        this.customers=new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        int index=findCustomer(customerName);
        if(index<0){
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        } else{
            System.out.println(customerName+" is already exist.");
        }
        return false;
    }
    public boolean addCustomerTransaction(String customerName,double initialAmount){
        int index=findCustomer(customerName);
        if(index>=0){
            this.customers.get(index).AddTransaction(initialAmount);
            return true;
        } else{
            System.out.println(customerName+" is not found");
        }
        return false;
    }
    private int findCustomer(String customerName) {
        customerName=customerName.toUpperCase();
        for(int i=0; i<customers.size(); i++){
            String name=this.customers.get(i).getName();
            if(name.equals(customerName)){// name == customerName
                return i;
            }
        }
        return -1;
    }
}

