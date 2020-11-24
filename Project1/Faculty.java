package cmsc256;

/*
Name: Anne Szarek
Course and Section: CMSC 256, Section 902
Project Name: Project 1
Purpose: Implement multiple Java classes using inheritance and Java composition
* */

public class Faculty extends Employee{
    //initializing instance var
    String rank;

    public Faculty(){
        //default constructor
        //setting default value
        this.rank = "Instructor";
    }

    public Faculty(String firstName, String middleName, String lastName, Address homeAddress,
                   String phoneNumber, String email, String office, int salary, int month,
                   int day, int year, String rank){
        //parameterized constructor
        super(firstName, middleName, lastName, homeAddress, phoneNumber, email,
                office, salary, month, day, year);

        //checking validity of rank
        if (isValidRank(rank) == true) {
            this.rank = rank;
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    private boolean isValidRank(String rank){
        boolean a = false;


        if (rank.equals("Adjunct") || rank.equals("Instructor") || rank.equals("Assistant Professor")
        || rank.equals("Associate Professor") || rank.equals("Professor")) {
            a = true;
        }

        return a;
    }
    //getters and setters
    public String getRank(){
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString(){

        return  "Faculty: \n"
                + super.toString(false)
                + "Rank: " + getRank() + "\n";
    }

}
