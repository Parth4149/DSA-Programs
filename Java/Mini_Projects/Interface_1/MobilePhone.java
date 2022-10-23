package Java.Mini_Projects.Interface_1;

public class MobilePhone implements ITelephone  {
    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn=true;
        System.out.println("Mobile is powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("Now ringing "+phoneNumber+" on mobile phone.");
        } else{
            System.out.println("Phone is switched off");
        }
    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering the mobile phone");
            isRinging=false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(myNumber==phoneNumber && isOn){
            isRinging=true;
            System.out.println("iphone ringtone ring");
        } else{
            if(!isOn){
                System.out.println("Phone is switched off");
            }
            if(myNumber!=phoneNumber){
                System.out.println("Wrong number");
            }
            isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
