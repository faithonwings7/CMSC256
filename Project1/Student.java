package cmsc256;

/*
Name: Anne Szarek
Course and Section: CMSC 256, Section 902
Project Name: Project 1
Purpose: Implement multiple Java classes using inheritance and Java composition
* */

public class Student extends Person {
    private String level;

    public Student(){
        //default constructor
        //setting instance variable equal to default
        this.level = "Freshman";
    }

    public Student(String firstName, String middleName, String lastName,
                   Address homeAddress, String phoneNumber,
                   String email, String level){
        //parameterized constructor
        super (firstName, middleName, lastName, homeAddress, phoneNumber, email);

        //verifying validity of level value
        if (isValidLevel(level) == true) {
            this.level = level;
        }
        else throw new IllegalArgumentException();

    }

    private boolean isValidLevel(String level){
        //setting value of boolean value to T or F based on value of level
        boolean b = false;
        switch(level){
            case "Freshman":
                b = true;
                break;
            case "Sophmore":
                b = true;
                break;
            case "Junior":
                b = true;
                break;
            case "Senior":
                b = true;
                break;
            case "Graduate":
                b = true;
                break;
            }
        return b;
    }
    //getters and setters
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String toString() {
        return "Student: \n"
                + super.toString()
                + "ID: " + getId() + "\n"
                + "Student Level: " + getLevel() + "\n";
    }
}
