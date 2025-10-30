// Question 23: User-Defined Package
// This program demonstrates package creation and import

// Define a package
package mypackage;

// Class 1 in the package
class MathOperations {
    // Method to find square
    public int square(int n) {
        return n * n;
    }
    
    // Method to find cube
    public int cube(int n) {
        return n * n * n;
    }
    
    // Method to check if number is prime
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // Method to find factorial
    public long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

// Class 2 in the package
class StringOperations {
    // Method to reverse a string
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Method to check if string is palindrome
    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }
    
    // Method to count vowels
    public int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}

// Main application class that uses the package
// Import the package (this would normally be in a separate file)
// import mypackage.*;

public class Question23 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   USER-DEFINED PACKAGE DEMONSTRATION");
        System.out.println("========================================");
        
        // Create objects from the package
        MathOperations math = new MathOperations();
        StringOperations str = new StringOperations();
        
        // Test MathOperations
        System.out.println("\n--- Math Operations ---");
        System.out.println("========================================");
        
        int num = 5;
        System.out.println("Number: " + num);
        System.out.println("Square: " + math.square(num));
        System.out.println("Cube: " + math.cube(num));
        System.out.println("Is Prime? " + math.isPrime(num));
        System.out.println("Factorial: " + math.factorial(num));
        
        System.out.println("\nChecking prime numbers from 1 to 20:");
        for (int i = 1; i <= 20; i++) {
            if (math.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Test StringOperations
        System.out.println("\n--- String Operations ---");
        System.out.println("========================================");
        
        String text = "RADAR";
        System.out.println("Original String: " + text);
        System.out.println("Reversed String: " + str.reverse(text));
        System.out.println("Is Palindrome? " + str.isPalindrome(text));
        System.out.println("Vowel Count: " + str.countVowels(text));
        
        System.out.println();
        
        String text2 = "Java Programming";
        System.out.println("Original String: " + text2);
        System.out.println("Reversed String: " + str.reverse(text2));
        System.out.println("Is Palindrome? " + str.isPalindrome(text2));
        System.out.println("Vowel Count: " + str.countVowels(text2));
        
        // Additional demonstrations
        System.out.println("\n--- Additional Tests ---");
        System.out.println("========================================");
        
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Squares and Cubes:");
        for (int n : numbers) {
            System.out.printf("n=%d: square=%d, cube=%d\n", n, math.square(n), math.cube(n));
        }
        
        String[] words = {"hello", "level", "world", "madam", "java"};
        System.out.println("\nPalindrome Check:");
        for (String word : words) {
            System.out.printf("'%s' is %s palindrome\n", 
                word, str.isPalindrome(word) ? "a" : "not a");
        }
        
        System.out.println("\n========================================");
        System.out.println("Package Information:");
        System.out.println("========================================");
        System.out.println("Package Name: mypackage");
        System.out.println("Classes in Package:");
        System.out.println("  1. MathOperations");
        System.out.println("     - square(int)");
        System.out.println("     - cube(int)");
        System.out.println("     - isPrime(int)");
        System.out.println("     - factorial(int)");
        System.out.println("  2. StringOperations");
        System.out.println("     - reverse(String)");
        System.out.println("     - isPalindrome(String)");
        System.out.println("     - countVowels(String)");
        System.out.println("========================================");
        
        System.out.println("\nNote: In a real project, package classes would be in");
        System.out.println("separate files in a 'mypackage' directory.");
        System.out.println("This demo combines everything for easy execution.");
        System.out.println("========================================");
    }
}
