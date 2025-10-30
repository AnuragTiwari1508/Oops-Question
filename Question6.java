// Question 6: Combinational Arithmetic Operators
// Demonstrates various arithmetic operations and combined operations

public class Question6 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  COMBINATIONAL ARITHMETIC OPERATORS");
        System.out.println("========================================\n");
        
        int a = 20;
        int b = 10;
        int c = 5;
        
        System.out.println("Initial Values:");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("\n========================================");
        
        // Basic arithmetic operators
        System.out.println("\nBasic Arithmetic Operations:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        
        // Compound assignment operators
        System.out.println("\nCompound Assignment Operators:");
        int x = 10;
        System.out.println("x = " + x);
        
        x += 5;  // x = x + 5
        System.out.println("After x += 5: " + x);
        
        x -= 3;  // x = x - 3
        System.out.println("After x -= 3: " + x);
        
        x *= 2;  // x = x * 2
        System.out.println("After x *= 2: " + x);
        
        x /= 4;  // x = x / 4
        System.out.println("After x /= 4: " + x);
        
        x %= 3;  // x = x % 3
        System.out.println("After x %= 3: " + x);
        
        // Increment and Decrement operators
        System.out.println("\nIncrement/Decrement Operators:");
        int y = 10;
        System.out.println("y = " + y);
        System.out.println("y++ (post-increment): " + y++);
        System.out.println("After post-increment, y = " + y);
        System.out.println("++y (pre-increment): " + ++y);
        System.out.println("y-- (post-decrement): " + y--);
        System.out.println("After post-decrement, y = " + y);
        System.out.println("--y (pre-decrement): " + --y);
        
        // Complex expressions
        System.out.println("\nComplex Arithmetic Expressions:");
        int result1 = (a + b) * c;
        System.out.println("(a + b) * c = " + result1);
        
        int result2 = a + b * c;
        System.out.println("a + b * c = " + result2);
        
        int result3 = (a - b) / c + a * b;
        System.out.println("(a - b) / c + a * b = " + result3);
        
        double result4 = (double)(a + b) / (c - 2);
        System.out.println("(a + b) / (c - 2) = " + result4);
        
        System.out.println("\n========================================");
    }
}
