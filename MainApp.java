// Importing necessary files to be used in the program
import java.util.*;
import java.lang.*;
import java.text.*;

class MainApp {
   public static void main(String args[]) {
      
      // Creating Scanner object for input and Decimal Format object to format the output
      Scanner input = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("0.00");
      
      // Creating an array of Polynomials
      Polynomial[] array = new Polynomial[6];
      
      // Filling up the array
      array[0] = new Polynomial(1, 2, -8);
      array[1] = new Polynomial(3.3, 5.5, 2.2);   
      array[2] = new Polynomial(1.0, 2.0, 3.0);  
      array[3] = new Polynomial(-4.4, -2.1, 8);
      array[4] = new Polynomial(2.5, -2.5, -2.5);
      array[5] = new Polynomial(-9, 1, 14.3);
      
      // Declaring and Initializing variables
      boolean flag = true;
      int choice = 0;
      
      // While loop for menu-driven program
      while(flag) {
         
         // Printing out the menu to the user and taking input
         System.out.println("1. View All Polynomials\n2. Edit a Polynomial\n3. Solve using quadratic formula\n4. Add two polynomials\n5. Find the derivative of all polynomials\n6. Delete a polynomial\n7. Exit");
         System.out.println();
         choice = input.nextInt();
         
         System.out.println();
         
         // Printing out all the polynomials
         if(choice == 1) {
            for(int i = 0; i <= array.length - 1; i++) {
               if(array[i] != null) {
                  System.out.println(array[i].toString());
               }
            }
            System.out.println();
         }
         
         // Asking the user for editing any of the polynonmials and acting accordingly
         else if(choice == 2) {
         
            // Printing out the output and taking input
            double entera, enterb, enterc;
            double newa, newb, newc;
            System.out.println("You must enter the coefficients of the polynomial you want to edit.");
            System.out.print("Enter A: ");
            entera = input.nextDouble();
            System.out.print("\nEnter B: ");
            enterb = input.nextDouble();
            System.out.print("\nEnter C: ");
            enterc = input.nextDouble();
            
            int[] checkArray = new int[6];
            
            // Taking the new coefficients and altering the polynomial
            for(int n = 0; n <= array.length - 1; n++) {
               if((array[n].getA() == entera) && (array[n].getB() == enterb) && (array[n].getC() == enterc)) {
                  System.out.println("Found it! You must now enter the new coefficients for A, B, and C.");
                  System.out.print("Enter A: ");
                  newa = input.nextDouble();
                  System.out.print("\nEnter B: ");
                  newb = input.nextDouble();
                  System.out.print("\nEnter C: ");
                  newc = input.nextDouble();
                  array[n].setA(newa);
                  array[n].setB(newb);
                  array[n].setC(newc);
                  System.out.println("Successfully updated!");
                  checkArray[n] = 0;
               }
               else {
                  checkArray[n] = 1;
               }
            }
            int add = 0;
            
            for(int z = 0; z <= checkArray.length - 1; z++) {
               add += checkArray[z];
            }      
            
            // Printing out the following message if the polynomial does not exist
            if(add == 6) {
               System.out.println("Sorry. That polynomial does not exist.");
            }   
            
            System.out.println();
         }
         
         // Solving a polynomial through the quadratic formula
         else if(choice == 3) {
         
            // Asking the user for input on which polynomial to solve
            char choose;
            choose = ' ';
            
            System.out.println("Which polynomial would you like to solve? (Enter a letter )");
            System.out.println();
            System.out.print("a: ");
            System.out.println(array[0].toString());
            System.out.print("b: ");
            System.out.println(array[1].toString());
            System.out.print("c: ");
            System.out.println(array[2].toString());
            System.out.print("d: ");
            System.out.println(array[3].toString());
            System.out.print("e: ");
            System.out.println(array[4].toString());
            System.out.print("f: ");
            System.out.println(array[5].toString());
            System.out.println();
            
            choose = input.next().charAt(0);
            
            // Declaring and Initializing variables to be used in the loop
            double disc;
            disc = 0.0;
            double[] array1 = new double[2];
            
            // Acting according to the choice entered. If the discriminant comes out to be negative, printing a message. If positive,
            // printing out the answers
            if((choose == 'a') || (choose == 'A')) {
               disc = array[0].findDisc();
               if(disc < 0) {
                  System.out.println("No real answers to this polynomial");
               }
               else {
                  array1 = array[0].solveQuad();
                  System.out.println("Positive Answer: " + df.format(array1[0]));
                  System.out.println("Negative Answer: " + df.format(array1[1]));
               }
            }
            else if((choose == 'b') || (choose == 'B')) {
               disc = array[1].findDisc();
               if(disc < 0) {
                  System.out.println("No real answers to this polynomial");
               }
               else {
                  array1 = array[1].solveQuad();
                  System.out.println("Positive Answer: " + df.format(array1[0]));
                  System.out.println("Negative Answer: " + df.format(array1[1]));
               }
            }
            else if((choose == 'c') || (choose == 'C')) {
               disc = array[2].findDisc();
               if(disc < 0.0) {
                  System.out.println("No real answers to this polynomial");
               }
               else {
                  array1 = array[2].solveQuad();
                  System.out.println("Positive Answer: " + df.format(array1[0]));
                  System.out.println("Negative Answer: " + df.format(array1[1]));
               }
            }
            else if((choose == 'd') || (choose == 'D')) {
               disc = array[3].findDisc();
               if(disc < 0) {
                  System.out.println("No real answers to this polynomial");
               }
               else {
                  array1 = array[3].solveQuad();
                  System.out.println("Positive Answer: " + df.format(array1[0]));
                  System.out.println("Negative Answer: " + df.format(array1[1]));
               }
            }
            else if((choose == 'e') || (choose == 'E')) {
               disc = array[4].findDisc();
               if(disc < 0) {
                  System.out.println("No real answers to this polynomial");
               }
               else {
                  array1 = array[4].solveQuad();
                  System.out.println("Positive Answer: " + df.format(array1[0]));
                  System.out.println("Negative Answer: " + df.format(array1[1]));
               }
            }
            else if((choose == 'f') || (choose == 'F')) {
               disc = array[5].findDisc();
               if(disc < 0) {
                  System.out.println("No real answers to this polynomial");
               }
               else {
                  array1 = array[5].solveQuad();
                  System.out.println("Positive Answer: " + df.format(array1[0]));
                  System.out.println("Negative Answer: " + df.format(array1[1]));
               }
            }
            
            // The following line is printed if an invalid option is selected
            else {
               System.out.println("Not an option");
            }
            System.out.println();
         }
         
         // Asking the user for two polynomials from the list and adding them together and displaying the result
         else if(choice == 4) {
            System.out.println("Select two polynomials to add together.");
            System.out.println();
            System.out.print("1) ");
            System.out.println(array[0].toString());
            System.out.print("2) ");
            System.out.println(array[1].toString());
            System.out.print("3) ");
            System.out.println(array[2].toString());
            System.out.print("4) ");
            System.out.println(array[3].toString());
            System.out.print("5) ");
            System.out.println(array[4].toString());
            System.out.print("6) ");
            System.out.println(array[5].toString());
            System.out.println();
            
            int num1, num2;
            
            System.out.println("Enter the number of the first polynomial: ");
            num1 = input.nextInt();
            System.out.println("Enter the number of the second polynomial: ");
            num2 = input.nextInt();
            
            if(((num1 >= 1) && (num1 <= 6)) && ((num2 >= 1) && (num2 <= 6))) {
               num1--;
               num2--;
               Polynomial obj = new Polynomial();
               obj = array[num1].add(array[num2]);
               System.out.println("The sum is: " + obj.toString());
            }
            
            // If the input is out of bounds, this message is printed
            else {
               System.out.println("Not a valid option. Both inputs must be between 1 and 6.");  
            }
            System.out.println();
         }
         
         // Printing the derivatives of all the polynomials
         else if(choice == 5) {
            System.out.println("Viewing all polynomials and their derivatives: ");
            for(int m = 0; m <= array.length - 1; m++) {
               System.out.println(array[m].toString() + " --> " + array[m].derivative());
            }
            System.out.println();
         }
         
         // Asking the user for input on which polynomial to delete and deleting that polynomial
         else if(choice == 6) {
            int delete;
            delete = 0;
            
            System.out.println("Select the polynomial you want to delete.");
            System.out.print("1) ");
            System.out.println(array[0].toString());
            System.out.print("2) ");
            System.out.println(array[1].toString());
            System.out.print("3) ");
            System.out.println(array[2].toString());
            System.out.print("4) ");
            System.out.println(array[3].toString());
            System.out.print("5) ");
            System.out.println(array[4].toString());
            System.out.print("6) ");
            System.out.println(array[5].toString());
            System.out.println();
            
            delete = input.nextInt();
            System.out.println();
            array[delete - 1] = null;
            System.out.println("Deleted Successfully.");
            System.out.println();
            
         }
         
         // If the user chooses this option, the program exits
         else if(choice == 7) {
            System.out.println("Exiting... Goodbye.");
            flag = false;
         }
         
         // This block of code represents an invalid choice from the menu
         else {
            System.out.println("Invalid choice. Choose again.");
            System.out.println();
         }
      }
      
   }
}
