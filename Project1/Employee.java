package cmsc256;
import java.time.LocalDate;

/*
Name: Anne Szarek
Course and Section: CMSC 256, Section 902
Project Name: Project 1
Purpose: Implement multiple Java classes using inheritance and Java composition
* */

public class Employee extends Person {
    //initializing instance variables
    private String office;
    private int salary;
    private LocalDate hireDate;

    public Employee() {
        //default constructor
        //setting instance vars to default values
        this.office = "Unassigned";
        this.salary = 0;
        this.hireDate = null;
    }

    public Employee(String firstName, String middleName, String lastName,
                    Address homeAddress, String phoneNumber,
                    String email, String office, int salary, int month, int day,
                    int year){
        //parameterized constructor
        super(firstName, middleName, lastName, homeAddress, phoneNumber, email);

        //check to make sure salary is a valid value - greater than 0
        try{
            if(salary > 0){
                this.salary = salary;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException ex){
            throw new IllegalArgumentException();
        }
        this.office = office;

        //checking validity of date values - none of values can be 0
        if(year > 0 && month > 0 && day > 0) {
            LocalDate newDate = LocalDate.of(year, month, day);
            this.hireDate = newDate;
        }
    }
    //getters and setters
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String toString (boolean addHeader){
        String hireDateString = "Unknown";
        String header = "Employee: \n";

        //checking to make sure hireDate isn't null
        if (hireDate != null){
            hireDateString = hireDate.getMonthValue() + "/" +
                    hireDate.getDayOfMonth() + "/" + hireDate.getYear();
        }

        //should not show header if staff or faulty is calling Employee super.toString
        if (addHeader == false) {
            header = "";
        }

        return header
                + super.toString()
                + "ID: " + getId() + "\n"
                + "Office: " + getOffice() + "\n"
                + "Salary: $" + getSalary() + "\n"
                + "Date Hired: " + hireDateString + "\n";
    }
}


