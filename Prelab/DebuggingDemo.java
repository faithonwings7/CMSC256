/*
 * This program is used to show how to find errors in your program
 */

/****************************************************************************************************
 * Name: Anne Szarek
 * Lab Section: Section 902
 * 
 * What lines contain syntax errors? Lines 25, 28
 * 
 ****************************************************************************************************/

import java.util.*;

public class DebuggingDemo{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare variables
        double number; // cannot convert double to int. Changed data type. 
        double average, value;
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
        int[] nums = {23, 3, 14, -5, 44, 78, 6, 98, 25};
        String myName = "Anne Szarek";
        value = 3.75; // added ";" as each line has to have a semi-colon to close the code on that line
        number = value;
        average = (3 + 5 + 8) / 0;
		System.out.println(" *** I am " + myName + " *** ");  // added a ) to close the print line area and a ";" as each line has to have a semi-colon to close the code on that line
        System.out.println("The first day of the week is: "+ daysOfTheWeek[1]);
        System.out.println("The last day of the week is: "+ daysOfTheWeek[6]); //changed last day of week from [7] to [6].
        average = 3 + 5 + 8 / 3.0;
        System.out.println("expected average is 5.33, actual average is: " + average);
        System.out.println("expected max is 98, actual max is: " + max(nums));

     }  

     // Returns the maximum value in the array parameter
     public static int max(int[] a) {
        int result = a[0];
        for(int i = 0; i < a.length; i++){
           if(a[i] < result) {
              result = a[i];
           }
         }
         return result;
     }

     // Returns true if all values in the parameter array fall with the
     // range define by parameters low and high
     public static boolean inRange (int[] array , int low , int high ) {
	      for (int i = 0 ; i < array.length ; i++) {
		      if (array[i] > low && array[i] < high) {
			      return true;
		      }
	      }
	      return false ;
      }
  }
