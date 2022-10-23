package Java.Collection.ArrayList.Challenge__2;

public class Main {
    public static void main(String[] args) {
        Bank bank=new Bank("SBI");

        bank.addBranch("ANAND");

        bank.addCustomer("ANAND","Parth",1000);
        bank.addCustomer("anand","nirav",2000);
        bank.addCustomer("ANAND","raj",3000);

        bank.addCustomerTransaction("anand","parth",10000);
        bank.addCustomerTransaction("ANAND","PARTH",5000);
        bank.addCustomerTransaction("ANAND","PARTH",1500);

        bank.listCustomers("ANAND",true);

    }
}
