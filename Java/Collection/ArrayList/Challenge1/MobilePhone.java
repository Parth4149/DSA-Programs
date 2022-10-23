package Java.Collection.ArrayList.Challenge1;
import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private String myNumber;
    ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts=new ArrayList<Contact>();
    }

    public void input(MobilePhone mobilePhone){
        Scanner sc=new Scanner(System.in);
        int choice=-1;
        while(choice!=0){
            if(choice==6 || choice==-1){
                printInfo();
            }
            System.out.print("\nEnter your choice : ");
            choice=sc.nextInt();

            switch(choice){
                case 1:mobilePhone.add_new_contact(inputData());break;
                case 2:update();break;
                case 3:Remove(mobilePhone);break;
                case 4:SearchContact();break;
                case 5:printList();break;
                case 6:
                case 0:
                    break;
            }
        }
    }

    public void printInfo(){
        System.out.print("1. Add new contact\n2. Modify\n3. Remove\n4. Search Contact\n5. List of All Contact\n0. Exit");
    }

    public void Remove(MobilePhone mobilePhone){
        String oldName=inputName();
        int index=findContact(oldName);
        if(index>=0){
            this.myContacts.remove(index);
        } else{
            System.out.println("Not found!");
        }
    }

    public void SearchContact(){
        String oldName=inputName();
        int index=findContact(oldName);
        if(index>=0){
            System.out.println(this.myContacts.get(index).getName().toUpperCase()+" : "+
                                this.myContacts.get(index).getPhone_number());
        } else{
            System.out.println(this.myContacts.get(index).getName()+" was not found!");
        }
    }

    private void update(){
        String oldName=inputName();
        int index=findContact(oldName);
        if(index >= 0){
            System.out.println("Input New values :");
            Contact newContact=inputData();
            this.myContacts.set(index,newContact);
        } else{
            System.out.println(oldName+" was not found.");
        }
    }

    public boolean add_new_contact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<this.myContacts.size(); i++){
            Contact contact=this.myContacts.get(i);
//            if(Objects.equals(contact.getName(), contactName)){
            if(contactName.equalsIgnoreCase(contact.getName())){// contactName == contact.getName()
                return i;
            }
        }
        return -1;
    }

    private Contact inputData(){
        Scanner sc=new Scanner(System.in);
        System.out.println("input name :");
        String name=sc.nextLine();
        System.out.print("input mobile number :");
        String no=sc.nextLine();
        sc.close();
        return new Contact(name,no);
    }

    private String inputName(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Name :");
        String name=sc.nextLine();
        return name;
    }
    public void printList(){
        for(Contact j: this.myContacts){
            System.out.printf("%-15s -> %-10s\n",j.getName().toUpperCase(),j.getPhone_number());
        }
    }
}
