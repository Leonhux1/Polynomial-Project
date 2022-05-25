// Importing necessary files to be used in the program
import java.util.*;
import java.lang.*;
import java.text.*;

class Polynomial {
   
   // Creating private data members
   private double a;
   private double b;
   private double c;
   
   // Default constructor
   public Polynomial() {
      a = 0.0;
      b = 0.0;
      c = 0.0;
   }
   
   // Custom constructor
   public Polynomial(double constructa, double constructb, double constructc) {
      a = constructa;
      b = constructb;
      c = constructc;
   }
   
   // Getters
   public double getA() {
      return a;
   }
   
   public double getB() {
      return b;
   }
   
   public double getC() {
      return c;
   }
   
   // Setters
   public void setA(double valuea) {
      a = valuea;
   }
   
   public void setB(double valueb) {
      b = valueb;
   }
   
   public void setC(double valuec) {
      c = valuec;
   }
   
   // Method that prints out the polynomial in a nice formatted way
   public String toString() {
      if(b < 0 && c < 0) {
         return a + "x^2 " + b + "x " + c;
      }
      else if(b < 0) {
         return a + "x^2 " + b + "x + " + c;
      }
      else if(c < 0){
         return a + "x^2 + " + b + "x " + c;
      }
      else {
         return a + "x^2 + " + b + "x + " + c;
      }
   }
   
   // Method that finds the discriminant of a polynomial
   public double findDisc() {
      double toReturn;
      toReturn = ((Math.pow(b, 2)) - (4 * a * c));
      return toReturn;
   }
   
   // Method that calculates the positive and negative values of a polynomial using the quadratic formuala,
   // stores them in an array, and returns the array to the call-site
   public double[] solveQuad() {
      double[] array = new double[2];
      double quada, quadb, disc, negated;
      negated = -(b);
      disc = Math.sqrt(findDisc());
      quada = (negated + disc)/(2 * a);
      quadb = (negated - disc)/(2 * a);
      array[0] = quada;
      array[1] = quadb;
      return array; 
   }
   
   // Method that adds two polynomials and returns a new object back to the call-site
   public Polynomial add(Polynomial object) {
      Polynomial object1 = new Polynomial();
      object1.setA(this.getA() + object.getA());
      object1.setB(this.getB() + object.getB());
      object1.setC(this.getC() + object.getC());
      return object1;
   }
   
   // Method that checks whether two objects are equal
   public boolean equals(Polynomial object) {
      if((this.getA() == object.getA()) && (this.getB() == object.getB()) && (this.getC() == object.getC())) {
         return true;
      }
      else {
         return false;
      }
   }
   
   // Method that calculates the derivative of polynomials
   public String derivative() {
      double first, second;
      first = 2 * a;
      second = b;
      if(second < 0) {
         return first + "x " + second;
      }
      else {
         return first + "x + " + second;
      }    
   }
}

   
   
   
   
   