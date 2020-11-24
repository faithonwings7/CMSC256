package cmsc256;

/*
Name: Anne Szarek
Course and Section: CMSC 256, Section 902
Project Name: Project 1
Purpose: Implement multiple Java classes using inheritance and Java composition
* */

public class Person {
    //initializing instance variables
    private int id;
    private String phoneNumber;
    private String email;
    private static int recordNumber = 0;
    private Name name;
    private Address address;

    public Person(){
        //default constructor - setting default values
        this.name = new Name();
        this.address = new Address();
        this.id = this.recordNumber++;
        this.phoneNumber = "None given";
        this.email = "None given";
    }

    public Person(String firstName, String middleName, String lastName,
                  Address homeAddress, String phoneNumber,
                  String email){
        //parameterized constructor
        //creating new name object
        name = new Name(firstName, middleName, lastName);
        this.address = homeAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;

        //setting id to value of record number and post incrementing
        id = recordNumber;
        recordNumber++;


    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getRecordNumber() {
        return recordNumber;
    }

    public static void setRecordNumber(int recordNumber) {
        Person.recordNumber = recordNumber;
    }

    public String getName(){
        return name.toString();
    }

    public String toString(){
        String addressString = "Unknown";
        String nameString = "";

        if (address != null){
            addressString = address.toString();
        }

        //check to make sure name isn't null
        if (name != null){
            nameString = name.toString() + "\n";
        }

        return "---------------------------------------\n"
                + nameString
                + "---------------------------------------\n"
                + "Home Address: " + addressString + "\n"
                + "Phone Number: " + getPhoneNumber() + "\n"
                + "Email address: " + getEmail() + "\n";
    }

}

