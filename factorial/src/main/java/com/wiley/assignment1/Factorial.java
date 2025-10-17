package com.wiley.assignment1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Factorial {

    private Scanner scanner;
    private PrintStream printStream;
    private int num;


    public Factorial(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public int isInputNumberValid() {
		/*
		- Update this method to accept a number from the user and store the value in an instance variable `num`. 
			- Use an instance variable `scanner` to accept the input from the user.
		
		- If the input value is valid, return the number input by the user (NOT the factorial of the number).
		
		- In case of invalid input:
			- Print the following message to the console: "Invalid entry. Please enter an integer between 1 and 10, inclusive."
			    - Use `this.printStream.print()` and NOT `System.out.println()` to print to the console.
			- Return -1
			
		- All code should be inside the placeholders below.
		*/
        // User is always asked for a value between 1 & 10
        int min = 1;
        int max = 10;
        //YOUR CODE STARTS HERE
        this.printStream.println("Enter a value between 1 & 10: \n");

        if (this.scanner.hasNextInt()) {
            //num holds the user input
            num = this.scanner.nextInt();
            if (min <= num && num <= max) {
                //valid user input :D
                return num;
            }
            //User's input was outside the requested bounds
            else {
                this.printStream.print("Invalid entry. Please enter an integer between 1 and 10, inclusive.");
            }
        }
        //User's input was not a valid integer value
        else {
            this.printStream.print("Invalid entry. Please enter an integer between 1 and 10, inclusive.");
        }

        //Denotes any invalid user entry
        return -1;
        //YOUR CODE ENDS HERE

    }


    private void calculateFactorial(int num) {
		
		  /*
		  Use this method to calculate the factorial of the number input by the user.
		  
		  - All code should be inside the placeholders below.
		*/

        int result = 1;
        //YOUR CODE STARTS HERE

        /*
        Factorial formulae: n! = n * (n-1) * (n-2) ... 1
           - Multiply n by 1
           - Store result
           - Decrement n
           - Multiply result by n - 1
           - Loop until n = 1
         */

        //Reverse iterate until num reaches 1
        while (num > 1) {
            //Multiply result by current num
            result = num * result;
            // Decrement num
            num--;
        }

        /* Recursive version:
        int getFactorial(num){

            if(num==1) {
            return num;
            }
            return num*getFactorial(num--);
        }

        result = getFactorial(num);
         */

        //YOUR CODE ENDS HERE
        this.printStream.print("The Factorial is: " + result);

    }

    public void calculateFactorial() {
		 /*
		 Do not change this method.
		 */
		 	
		 int input = this.isInputNumberValid();
		 if(input != -1)
		 {
			 calculateFactorial(input);
		 }
		 
	 }
	

    public static void main(String[] args) {
		/*
		 Do not change this method.
		 */
        Factorial fact = new Factorial(System.in, System.out);
        System.out.println("Enter an integer between 1 and 10, inclusive.");
        fact.calculateFactorial();
    }


}
