package Java.Mini_Projects.Interface_1;

public class Main {
    public static void main(String[] args) {
        ITelephone myPhone;
        myPhone=new MobilePhone(1234);
        myPhone.powerOn();
        myPhone.callPhone(1234);
        myPhone.answer();
    }
}
