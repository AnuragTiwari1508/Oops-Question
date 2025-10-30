// Question 11: Fibonacci Series using do-while loop
// Sequence: 1 1 2 3 5 8 13 21...
// Each number is sum of previous two numbers

import java.util.Scanner;

public class Question11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("       FIBONACCI SERIES");
        System.out.println("========================================\n");
        
        System.out.print("Enter how many Fibonacci numbers to display (m): ");
        int m = scanner.nextInt();
        
        System.out.println("\n========================================");
        System.out.println("First " + m + " Fibonacci Numbers:");
        System.out.println("========================================");
        
        if (m <= 0) {
            System.out.println("Please enter a positive number!");
        } else {
            int first = 1, second = 1;
            int count = 0;
            
            // Using do-while loop as per requirement
            do {
                if (count == 0) {
                    System.out.print(first + " ");
                    count++;
                } else if (count == 1) {
                    System.out.print(second + " ");
                    count++;
                } else {
                    int next = first + second;
                    System.out.print(next + " ");
                    first = second;
                    second = next;
                    count++;
                }
            } while (count < m);
            
            System.out.println("\n========================================");
        }
        
        scanner.close();
    }
}
