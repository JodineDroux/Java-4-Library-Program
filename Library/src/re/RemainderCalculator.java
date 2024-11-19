package re;

// A java program to take two numbers, divide them and give the remainder
import java.util.Scanner;

public class RemainderCalculator {

  // A method that returns the remainder of dividing a by b
  public static int getRemainder(int a, int b) {
    // If b is zero, return -1 to indicate an error
    if (b == 0) {
      return -1;
    }
    // Use the modulo operator (%) to get the remainder
    return a % b;
  }

  // A main method that tests the getRemainder method
  public static void main(String[] args) {
    // Create a scanner object to read user input
    Scanner sc = new Scanner(System.in);
    // Prompt the user to enter two numbers
    System.out.print("Enter two numbers: ");
    // Read the numbers as integers
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    // Close the scanner
    sc.close();
    // Call the getRemainder method and store the result
    int result = getRemainder(num1, num2);
    // Check if the result is -1, which means an error
    if (result == -1) {
      // Print an error message
      System.out.println("Cannot divide by zero");
    } else {
      // Print the result
      System.out.println("The remainder of dividing " + num1 + " by " + num2 + " is " + result);
    }
  }
}
