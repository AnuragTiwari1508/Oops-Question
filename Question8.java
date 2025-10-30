// Question 8: Compare Two Numbers
// Takes two numbers from user, compares them, and displays result

import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("       NUMBER COMPARISON");
        System.out.println("========================================\n");
        
        // Input first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        // Input second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.println("\n========================================");
        System.out.println("COMPARISON RESULTS:");
        System.out.println("========================================");
        
        // Comparison operations
        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);
        System.out.println();
        
        // Equal to
        System.out.println("num1 == num2: " + (num1 == num2));
        
        // Not equal to
        System.out.println("num1 != num2: " + (num1 != num2));
        
        // Greater than
        System.out.println("num1 > num2: " + (num1 > num2));
        
        // Less than
        System.out.println("num1 < num2: " + (num1 < num2));
        
        // Greater than or equal to
        System.out.println("num1 >= num2: " + (num1 >= num2));
        
        // Less than or equal to
        System.out.println("num1 <= num2: " + (num1 <= num2));
        
        System.out.println("\n========================================");
        System.out.println("FINAL RESULT:");
        System.out.println("========================================");
        
        // Display comparison result
        if (num1 > num2) {
            System.out.println(num1 + " is GREATER than " + num2);
            System.out.println("Difference: " + (num1 - num2));
        } else if (num1 < num2) {
            System.out.println(num1 + " is LESS than " + num2);
            System.out.println("Difference: " + (num2 - num1));
        } else {
            System.out.println(num1 + " is EQUAL to " + num2);
        }
        
        System.out.println("========================================");
        
        scanner.close();
    }
}
