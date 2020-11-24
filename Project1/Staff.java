package cmsc256;

/*
Name: Anne Szarek
Course and Section: CMSC 256, Section 902
Project Name: Project 1
Purpose: Implement multiple Java classes using inheritance and Java composition
* */

public class Staff extends Employee {
    //initializing instance vars
    String title;

    public Staff(){
        //default constuctor
        //setting instance vars equal to defaults
        this.title = "None given";
    }

    public Staff(String firstName, String middleName, String lastName,
                 Address homeAddress, String phoneNumber, String email, String office,
                 int salary, int month, int day, int year, String title){
        //parameterized constructor
        super(firstName, middleName, lastName, homeAddress, phoneNumber, email,
                office, salary, month, day, year);
        this.title = title;
    }
    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return "Staff:\n"
                + super.toString(false)
                + "Title: " + title + "\n";
    }
}
