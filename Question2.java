// Question 2: Convert Inches to Centimeters
// User provides input in inches and program converts to centimeters
// Formula: 1 inch = 2.54 centimeters

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("  INCHES TO CENTIMETERS CONVERTER");
        System.out.println("========================================\n");
        
        System.out.print("Enter value in inches: ");
        double inches = scanner.nextDouble();
        
        // Conversion formula
        double centimeters = inches * 2.54;
        
        System.out.println("\n========================================");
        System.out.println("RESULT:");
        System.out.println("========================================");
        System.out.println(inches + " inches = " + centimeters + " centimeters");
        System.out.println("========================================");
        
        scanner.close();
    }
}
