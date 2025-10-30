// Question 16: Matrix Addition and Subtraction
// Finds and displays addition and subtraction of two 3x3 matrices

import java.util.Scanner;

public class Question16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("  MATRIX ADDITION & SUBTRACTION (3×3)");
        System.out.println("========================================\n");
        
        // Declare 3x3 matrices
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        int[][] sum = new int[3][3];
        int[][] difference = new int[3][3];
        
        // Input first matrix
        System.out.println("Enter elements of first 3×3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element [" + (i+1) + "][" + (j+1) + "]: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }
        
        // Input second matrix
        System.out.println("\nEnter elements of second 3×3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element [" + (i+1) + "][" + (j+1) + "]: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }
        
        // Calculate sum and difference
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
                difference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        // Display results
        System.out.println("\n========================================");
        System.out.println("First Matrix:");
        System.out.println("========================================");
        displayMatrix(matrix1);
        
        System.out.println("\n========================================");
        System.out.println("Second Matrix:");
        System.out.println("========================================");
        displayMatrix(matrix2);
        
        System.out.println("\n========================================");
        System.out.println("Sum (Matrix1 + Matrix2):");
        System.out.println("========================================");
        displayMatrix(sum);
        
        System.out.println("\n========================================");
        System.out.println("Difference (Matrix1 - Matrix2):");
        System.out.println("========================================");
        displayMatrix(difference);
        
        scanner.close();
    }
    
    // Helper method to display matrix
    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
