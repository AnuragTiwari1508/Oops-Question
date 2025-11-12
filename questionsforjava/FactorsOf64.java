public class FactorsOf64 {
    public static void main(String[] args) {
        int number = 64;
        System.out.println("==================================");
        System.out.println("    FACTORS OF " + number);
        System.out.println("==================================");
        
        System.out.print("Factors: ");
        int count = 0;
        
        // Find and print all factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        
        System.out.println("\n");
        System.out.println("Total number of factors: " + count);
        
        // Check if it's a perfect square
        int sqrt = (int) Math.sqrt(number);
        if (sqrt * sqrt == number) {
            System.out.println(number + " is a perfect square (√" + number + " = " + sqrt + ")");
        }
        
        // Show factor pairs
        System.out.println("\nFactor pairs:");
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                int pair = number / i;
                if (i == pair) {
                    System.out.println(i + " × " + pair + " = " + number + " (perfect square pair)");
                } else {
                    System.out.println(i + " × " + pair + " = " + number);
                }
            }
        }
        
        System.out.println("==================================");
    }
}