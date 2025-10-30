// Question 14: Matrix Multiplication
// Multiplies two matrices and displays the result

import java.util.Scanner;

public class Question14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("      MATRIX MULTIPLICATION");
        System.out.println("========================================\n");
        
        // Input dimensions of first matrix
        System.out.print("Enter rows of first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter columns of first matrix: ");
        int cols1 = scanner.nextInt();
        
        // Input dimensions of second matrix
        System.out.print("Enter rows of second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter columns of second matrix: ");
        int cols2 = scanner.nextInt();
        
        // Check if multiplication is possible
        if (cols1 != rows2) {
            System.out.println("\nMatrix multiplication not possible!");
            System.out.println("Columns of first matrix must equal rows of second matrix.");
            scanner.close();
            return;
        }
        
        // Declare matrices
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] result = new int[rows1][cols2];
        
        // Input first matrix
        System.out.println("\nEnter elements of first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }
        
        // Input second matrix
        System.out.println("\nEnter elements of second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }
        
        // Multiply matrices
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
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
        System.out.println("Result (Matrix1 × Matrix2):");
        System.out.println("========================================");
        displayMatrix(result);
        
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
