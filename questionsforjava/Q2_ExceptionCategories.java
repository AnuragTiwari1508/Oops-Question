/*
 * Q.2: Exception Handling and Categories in Java
 * 
 * THEORY: WHAT IS AN EXCEPTION?
 * 
 * An exception is an unwanted or unexpected event that occurs during the execution
 * of a program at runtime that disrupts the normal flow of the program's instructions.
 * 
 * Key Points:
 * 1. Exceptions are runtime errors
 * 2. They can be handled using try-catch blocks
 * 3. Java has a rich hierarchy of exception classes
 * 4. Proper exception handling makes programs robust and user-friendly
 * 
 * EXCEPTION HIERARCHY:
 * 
 *                    Throwable
 *                   /         \
 *              Error           Exception
 *                             /         \
 *                    IOException      RuntimeException
 *                                    (Unchecked)      (Checked)
 */

import java.io.*;
import java.util.Scanner;

public class Q2_ExceptionCategories {
    
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("           EXCEPTION HANDLING AND CATEGORIES");
        System.out.println("==========================================================\n");
        
        ExceptionDemo demo = new ExceptionDemo();
        
        // Demonstrate different categories of exceptions
        demo.demonstrateCheckedExceptions();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateUncheckedException();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateCustomException();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateMultipleCatch();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateFinallyBlock();
        
        // Print theory and explanation
        demo.printExceptionTheory();
    }
}

class ExceptionDemo {
    
    // 1. CHECKED EXCEPTIONS
    // These are exceptions that must be handled at compile time
    public void demonstrateCheckedExceptions() {
        System.out.println("1. CHECKED EXCEPTIONS DEMONSTRATION:");
        System.out.println("------------------------------------");
        
        // FileNotFoundException (Checked Exception)
        try {
            System.out.println("Attempting to read a non-existent file...");
            FileReader file = new FileReader("nonexistent.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            System.out.println("File content: " + line);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("✗ FileNotFoundException caught: " + e.getMessage());
            System.out.println("  This is a CHECKED exception - must be handled at compile time");
        } catch (IOException e) {
            System.out.println("✗ IOException caught: " + e.getMessage());
        }
        
        // ClassNotFoundException example
        try {
            System.out.println("\nAttempting to load a non-existent class...");
            Class.forName("com.nonexistent.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("✗ ClassNotFoundException caught: " + e.getMessage());
            System.out.println("  This is also a CHECKED exception");
        }
    }
    
    // 2. UNCHECKED EXCEPTIONS (Runtime Exceptions)
    // These occur during runtime and don't need to be declared
    public void demonstrateUncheckedException() {
        System.out.println("2. UNCHECKED EXCEPTIONS DEMONSTRATION:");
        System.out.println("--------------------------------------");
        
        // ArithmeticException
        try {
            System.out.println("Attempting division by zero...");
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("✗ ArithmeticException caught: " + e.getMessage());
            System.out.println("  This is an UNCHECKED exception (RuntimeException)");
        }
        
        // ArrayIndexOutOfBoundsException
        try {
            System.out.println("\nAttempting to access invalid array index...");
            int[] arr = {1, 2, 3};
            System.out.println("Element at index 5: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✗ ArrayIndexOutOfBoundsException caught: " + e.getMessage());
            System.out.println("  Another UNCHECKED exception");
        }
        
        // NullPointerException
        try {
            System.out.println("\nAttempting to use null reference...");
            String str = null;
            int length = str.length();
            System.out.println("String length: " + length);
        } catch (NullPointerException e) {
            System.out.println("✗ NullPointerException caught: " + e.getMessage());
            System.out.println("  Most common UNCHECKED exception");
        }
        
        // NumberFormatException
        try {
            System.out.println("\nAttempting to parse invalid number...");
            int number = Integer.parseInt("abc123");
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("✗ NumberFormatException caught: " + e.getMessage());
            System.out.println("  UNCHECKED exception for invalid number format");
        }
    }
    
    // 3. CUSTOM EXCEPTIONS
    public void demonstrateCustomException() {
        System.out.println("3. CUSTOM EXCEPTIONS DEMONSTRATION:");
        System.out.println("-----------------------------------");
        
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("✗ Custom Exception caught: " + e.getMessage());
            System.out.println("  This is a user-defined exception");
        }
        
        try {
            validateBankBalance(500, 1000);
        } catch (InsufficientFundsException e) {
            System.out.println("✗ Custom Exception caught: " + e.getMessage());
            System.out.println("  Another user-defined exception for banking operations");
        }
    }
    
    // 4. MULTIPLE CATCH BLOCKS
    public void demonstrateMultipleCatch() {
        System.out.println("4. MULTIPLE CATCH BLOCKS DEMONSTRATION:");
        System.out.println("---------------------------------------");
        
        try {
            String[] data = {"10", "20", "abc", "40"};
            
            for (int i = 0; i <= data.length; i++) {
                int number = Integer.parseInt(data[i]);
                int result = 100 / number;
                System.out.println("Processing: " + data[i] + " -> Result: " + result);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✗ Array index out of bounds: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid number format: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("✗ Arithmetic error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ General exception: " + e.getMessage());
        }
        
        System.out.println("Program continues after exception handling...");
    }
    
    // 5. FINALLY BLOCK
    public void demonstrateFinallyBlock() {
        System.out.println("5. FINALLY BLOCK DEMONSTRATION:");
        System.out.println("-------------------------------");
        
        FileWriter writer = null;
        try {
            System.out.println("Opening file for writing...");
            writer = new FileWriter("temp.txt");
            writer.write("Hello, Exception Handling!");
            
            // Simulate an exception
            int result = 10 / 0;
            
        } catch (IOException e) {
            System.out.println("✗ IOException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("✗ ArithmeticException in finally demo: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - cleaning up resources...");
            try {
                if (writer != null) {
                    writer.close();
                    System.out.println("File writer closed successfully");
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
        
        System.out.println("Program execution completed.");
    }
    
    // Helper methods for custom exceptions
    private void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        }
        System.out.println("Valid age: " + age);
    }
    
    private void validateBankBalance(double balance, double withdrawAmount) throws InsufficientFundsException {
        if (withdrawAmount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds. Balance: " + balance + ", Requested: " + withdrawAmount
            );
        }
        System.out.println("Transaction successful. Remaining balance: " + (balance - withdrawAmount));
    }
    
    // Method to print comprehensive theory
    public void printExceptionTheory() {
        System.out.println("==========================================================");
        System.out.println("                   EXCEPTION THEORY");
        System.out.println("==========================================================");
        
        System.out.println("\nCATEGORIES OF EXCEPTIONS:");
        System.out.println("-------------------------");
        
        System.out.println("\n1. CHECKED EXCEPTIONS:");
        System.out.println("   • Must be handled at compile time");
        System.out.println("   • Compiler forces you to handle them");
        System.out.println("   • Examples: IOException, FileNotFoundException, ClassNotFoundException");
        System.out.println("   • Use try-catch or throws keyword");
        
        System.out.println("\n2. UNCHECKED EXCEPTIONS (Runtime Exceptions):");
        System.out.println("   • Occur during program execution");
        System.out.println("   • Not mandatory to handle at compile time");
        System.out.println("   • Usually due to programming errors");
        System.out.println("   • Examples: NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException");
        
        System.out.println("\n3. ERRORS:");
        System.out.println("   • Serious problems that applications shouldn't handle");
        System.out.println("   • Usually related to JVM or system issues");
        System.out.println("   • Examples: OutOfMemoryError, StackOverflowError");
        
        System.out.println("\nEXCEPTION HANDLING KEYWORDS:");
        System.out.println("----------------------------");
        System.out.println("• try      : Contains code that may throw exception");
        System.out.println("• catch    : Handles specific exceptions");
        System.out.println("• finally  : Always executed (cleanup code)");
        System.out.println("• throw    : Manually throw an exception");
        System.out.println("• throws   : Declare exceptions a method might throw");
        
        System.out.println("\nBEST PRACTICES:");
        System.out.println("---------------");
        System.out.println("• Handle specific exceptions before general ones");
        System.out.println("• Use finally block for cleanup operations");
        System.out.println("• Create meaningful custom exceptions");
        System.out.println("• Don't ignore exceptions (empty catch blocks)");
        System.out.println("• Use try-with-resources for automatic resource management");
        
        System.out.println("\n==========================================================");
    }
}

// Custom Exception Classes
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}