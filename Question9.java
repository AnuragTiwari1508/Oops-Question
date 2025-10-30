// Question 9: Sum of Digits
// Reads an integer between 0 and 1000 and adds all digits
// Example: Input 675, Output 17 (6+7+5=18, correction: 6+7+5=18)

import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("       SUM OF DIGITS");
        System.out.println("========================================\n");
        
        System.out.print("Enter an integer (0-1000): ");
        int number = scanner.nextInt();
        
        // Store original number for display
        int originalNumber = number;
        int sum = 0;
        String digits = "";
        
        // Extract and add each digit
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            
            if (digits.isEmpty()) {
                digits = digit + "";
            } else {
                digits = digit + " + " + digits;
            }
            
            number = number / 10;
        }
        
        System.out.println("\n========================================");
        System.out.println("RESULT:");
        System.out.println("========================================");
        System.out.println("Original Number: " + originalNumber);
        System.out.println("Digit Breakdown: " + digits);
        System.out.println("Sum of Digits: " + sum);
        System.out.println("========================================");
        
        scanner.close();
    }
}
