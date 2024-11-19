package re;

//A java program to check if a number is prime
import java.util.Scanner;

public class PrimeChecker {

// A method that returns true if n is prime, false otherwise
public static boolean isPrime(int n) {
 // If n is less than 2, it is not prime
 if (n < 2) {
   return false;
 }
 // Check if n is divisible by any number from 2 to the square root of n
 int limit = (int) Math.sqrt(n);
 for (int i = 2; i <= limit; i++) {
   if (n % i == 0) {
     // n is divisible by i, so it is not prime
     return false;
   }
 }
 // n is not divisible by any number from 2 to the square root of n, so it is prime
 return true;
}

// A main method that tests the isPrime method
public static void main(String[] args) {
 // Create a scanner object to read user input
 Scanner sc = new Scanner(System.in);
 // Prompt the user to enter a number
 System.out.print("Enter a number: ");
 // Read the number as an integer
 int number = sc.nextInt();
 // Close the scanner
 sc.close();
 // Check if the number is prime using the isPrime method
 boolean result = isPrime(number);
 // Print the result
 System.out.println(number + " is " + (result ? "prime" : "not prime"));
}
}