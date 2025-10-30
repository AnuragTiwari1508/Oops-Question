// Question 15: Pattern Printing
// Displays two different number patterns

public class Question15 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       PATTERN PRINTING");
        System.out.println("========================================\n");
        
        // Pattern 1: Increasing odd numbers
        System.out.println("Pattern 1:");
        System.out.println("----------");
        
        for (int i = 1; i <= 5; i++) {
            // Print i, (2*i-1) times
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        
        // Pattern 2: Palindrome numbers
        System.out.println("\n========================================");
        System.out.println("Pattern 2:");
        System.out.println("----------");
        
        for (int i = 1; i <= 5; i++) {
            // Print spaces for alignment
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            
            // Print decreasing numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            
            // Print increasing numbers
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            
            System.out.println();
        }
        
        System.out.println("\n========================================");
        System.out.println("Additional Patterns:");
        System.out.println("========================================\n");
        
        // Bonus Pattern 3: Right-aligned triangle
        System.out.println("Pattern 3 (Right Triangle):");
        System.out.println("----------");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        // Bonus Pattern 4: Diamond pattern
        System.out.println("\nPattern 4 (Number Diamond):");
        System.out.println("----------");
        int n = 5;
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        System.out.println("========================================");
    }
}
