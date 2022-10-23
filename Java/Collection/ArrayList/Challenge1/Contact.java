package Java.Collection.ArrayList.Challenge1;

public class Contact {
    private String name;
    private String phone_number;

    public Contact(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public static Contact createContact(String name, String phone_number){
        return new Contact(name,phone_number);
    }
}
