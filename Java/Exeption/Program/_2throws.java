package Java.Exeption.Program;
/**
 * if we want to throw an Exception in method then we can use either throws OR try-catch block
 */
class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String s){
        super(s);
    }
}
class Bank {
    double balance;
    public Bank(double balance){
        this.balance=balance;
    }
    public void Deposit (double x){
        System.out.println("Old Balance : "+balance);
        balance += x;
        System.out.println("Current Balance : "+balance);
    }
    public void Withdraw(double x) throws NotEnoughMoneyException,ArithmeticException{
        System.out.println("Old Balance : " + balance);
        if(balance < 500){
            throw new NotEnoughMoneyException("Your balance is less than 500");
        }
        if(x > balance) {
            throw new ArithmeticException("Your balance is less than "+x+" so you cannot withdraw.");
        }
        balance -= x;
        System.out.println("Current Balance : "+balance);
    }
    public static void main(String[] args) {
        Bank bank = new Bank(100);
        try{
            bank.Deposit(200);
            bank.Withdraw(250);
        }
        catch(NotEnoughMoneyException | ArithmeticException e){
            System.out.println(e.getMessage());// it prints only string which we have passed
            System.out.println(e);
        }
    }
}
/**
 * if your balance less than 500 then it throws NotEnoughMoneyException
 * if your balance less than withdrawal amount then it throws ArithmeticException
 */




