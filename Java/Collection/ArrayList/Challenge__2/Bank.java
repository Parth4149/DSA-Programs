package Java.Collection.ArrayList.Challenge__2;

import java.util.ArrayList;

public class Bank {
    private String name;
    ArrayList<Branch> branch;

    public Bank(String name) {
        name=name.toUpperCase();
        this.name = name;
        this.branch = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        int index=findBranch(branchName);
        if(index<0){
            this.branch.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branch,String customerName,double initialAmount){
        int index=findBranch(branch);// index of branch
        if(index>=0){
            return this.branch.get(index).newCustomer(customerName,initialAmount);// return true
        } else{
            System.out.println(branch+" was not found");
        }
        return false;
    }
    public boolean addCustomerTransaction(String branch,String customerName,double amount){
        customerName=customerName.toUpperCase();
        int index=findBranch(branch);
        if(index>=0){
            return this.branch.get(index).addCustomerTransaction(customerName,amount);// return true
        }
        return false;
    }
    private int findBranch(String branchName) {
        branchName=branchName.toUpperCase();
        for(int i=0; i<branch.size(); i++){
            if(this.branch.get(i).getName().equals(branchName)){
                return i;
            }
        }
        return -1;
    }
    public boolean listCustomers(String branchName,boolean showTransaction){
        int index=findBranch(branchName);
        if(index>=0){
            System.out.println("Customer details for branch "+branch.get(index).getName());
            ArrayList<Customer> branchCustomers;
            branchCustomers=this.branch.get(index).getCustomers();
            for(int i=0; i<branchCustomers.size(); i++){
                Customer branchCustomer=branchCustomers.get(i);// this branchCustomer and branchCustomers both are different
                System.out.println("Customer <"+i+"> : "+branchCustomer.getName());
                if(showTransaction){
                    ArrayList<Double> transactions=branchCustomer.getTransaction();
                    for(int j=0; j<transactions.size(); j++){
                        System.out.println("\t["+(j+1)+"] Amount : "+transactions.get(j));
                    }
                }
            }
            return true;
        } else{
            System.out.println(branch+" was not found");
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
