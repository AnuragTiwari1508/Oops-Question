// Question 10: Factorial Calculator
// Finds factorial of a number provided by user
// Factorial of n = n * (n-1) * (n-2) * ... * 1

import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("       FACTORIAL CALCULATOR");
        System.out.println("========================================\n");
        
        System.out.print("Enter a number to find factorial: ");
        int number = scanner.nextInt();
        
        // Handle negative numbers
        if (number < 0) {
            System.out.println("\nFactorial is not defined for negative numbers!");
            scanner.close();
            return;
        }
        
        // Calculate factorial
        long factorial = 1;
        String calculation = "";
        
        for (int i = number; i >= 1; i--) {
            factorial *= i;
            if (calculation.isEmpty()) {
                calculation = i + "";
            } else {
                calculation += " × " + i;
            }
        }
        
        System.out.println("\n========================================");
        System.out.println("RESULT:");
        System.out.println("========================================");
        System.out.println("Number: " + number);
        
        if (number == 0) {
            System.out.println("Calculation: 0! = 1 (by definition)");
        } else {
            System.out.println("Calculation: " + number + "! = " + calculation);
        }
        
        System.out.println("Factorial: " + factorial);
        System.out.println("========================================");
        
        scanner.close();
    }
}
