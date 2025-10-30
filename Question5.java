// Question 5: Calculate Square, Cube, and Fourth Power
// Reads a number and displays its square, cube, and fourth power

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("  POWER CALCULATOR");
        System.out.println("========================================\n");
        
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();
        
        // Calculate powers
        double square = Math.pow(number, 2);
        double cube = Math.pow(number, 3);
        double fourthPower = Math.pow(number, 4);
        
        System.out.println("\n========================================");
        System.out.println("RESULTS:");
        System.out.println("========================================");
        System.out.println("Number: " + number);
        System.out.println("Square (n²): " + square);
        System.out.println("Cube (n³): " + cube);
        System.out.println("Fourth Power (n⁴): " + fourthPower);
        System.out.println("========================================");
        
        scanner.close();
    }
}
