// Question 13: Multiplication Table
// Prompts user for a positive integer and displays its multiplication table

import java.util.Scanner;

public class Question13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("     MULTIPLICATION TABLE");
        System.out.println("========================================\n");
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("\nPlease enter a positive integer!");
        } else {
            System.out.println("\n========================================");
            System.out.println("Multiplication Table of " + number);
            System.out.println("========================================");
            
            for (int i = 1; i <= 10; i++) {
                int result = number * i;
                System.out.printf("%d × %d = %d\n", number, i, result);
            }
            
            System.out.println("========================================");
            
            // Extended table (optional - up to 20)
            System.out.println("\nExtended Table (up to 20):");
            System.out.println("========================================");
            
            for (int i = 11; i <= 20; i++) {
                int result = number * i;
                System.out.printf("%d × %d = %d\n", number, i, result);
            }
            
            System.out.println("========================================");
        }
        
        scanner.close();
    }
}
