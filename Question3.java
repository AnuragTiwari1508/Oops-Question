// Question 3: Display numbers 1 to 10 with their square roots
// Program calculates and displays square root of each number

public class Question3 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  NUMBERS AND THEIR SQUARE ROOTS");
        System.out.println("========================================\n");
        
        System.out.println("Number\t\tSquare Root");
        System.out.println("------\t\t-----------");
        
        // Loop from 1 to 10
        for (int i = 1; i <= 10; i++) {
            double squareRoot = Math.sqrt(i);
            System.out.printf("%d\t\t%.4f\n", i, squareRoot);
        }
        
        System.out.println("\n========================================");
    }
}
