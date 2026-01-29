package rohit_sawant.assignments;

import java.util.Scanner;

//Write your logic for class
public class Day3 {

 // Method to calculate result based on operator
 public static int calculate(int a, int b, char op) {

     // Calculator class to perform arithmetic operations
     class Calculator {

         // Add two numbers
         int add(int firstNumber, int secondNumber) {
             return firstNumber + secondNumber;
         }

         // Subtract second number from first
         int subtract(int firstNumber, int secondNumber) {
             return firstNumber - secondNumber;
         }

         // Multiply two numbers
         int multiply(int firstNumber, int secondNumber) {
             return firstNumber * secondNumber;
         }

         // Divide first number by second
         int divide(int firstNumber, int secondNumber) throws ArithmeticException {
             if (secondNumber == 0) {
                 throw new ArithmeticException("division by zero");
             }
             return firstNumber / secondNumber;
         }
     }

     Calculator calculator = new Calculator();

     // Perform operation based on operator
     switch (op) {
         case '+':
             return calculator.add(a, b);
         case '-':
             return calculator.subtract(a, b);
         case '*':
             return calculator.multiply(a, b);
         case '/':
             try {
                 return calculator.divide(a, b);
             } catch (ArithmeticException exception) {
                 System.out.println("Err: division by zero");
                 return 0;
             }
         default:
             // Invalid operator (not expected as per problem constraints)
             return 0;
     }
 }

 // Main method
 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     // Read two integers
     String[] inputs = sc.nextLine().split(" ");
     int a = Integer.parseInt(inputs[0]);
     int b = Integer.parseInt(inputs[1]);

     // Read operator safely (single token)
     char op = sc.next().charAt(0);

     int result = calculate(a, b, op);

     // Print result only if not division by zero
     if (op != '/' || b != 0) {
         System.out.println(result);
     }

     sc.close();
 }
}
