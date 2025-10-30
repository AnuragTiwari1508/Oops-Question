// Question 19: Method Overriding
// Parent class calculates sum of first 10 natural numbers
// Child class overrides to calculate product of first 10 natural numbers

// Parent class
class Calculator {
    void calculate() {
        int sum = 0;
        System.out.print("First 10 natural numbers: ");
        
        for (int i = 1; i <= 10; i++) {
            sum += i;
            System.out.print(i + " ");
        }
        
        System.out.println("\nSum of first 10 natural numbers: " + sum);
    }
    
    void display() {
        System.out.println("\n========================================");
        System.out.println("Parent Class Method - Sum Calculation");
        System.out.println("========================================");
        calculate();
        System.out.println("========================================");
    }
}

// Child class
class AdvancedCalculator extends Calculator {
    @Override
    void calculate() {
        long product = 1;
        System.out.print("First 10 natural numbers: ");
        
        for (int i = 1; i <= 10; i++) {
            product *= i;
            System.out.print(i + " ");
        }
        
        System.out.println("\nProduct of first 10 natural numbers: " + product);
        System.out.println("(This is also 10! = Factorial of 10)");
    }
    
    @Override
    void display() {
        System.out.println("\n========================================");
        System.out.println("Child Class Method - Product Calculation");
        System.out.println("========================================");
        calculate();
        System.out.println("========================================");
    }
    
    // Additional method in child class
    void calculateBoth() {
        System.out.println("\n========================================");
        System.out.println("Calculating Both Sum and Product");
        System.out.println("========================================");
        
        int sum = 0;
        long product = 1;
        
        System.out.print("Numbers: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            sum += i;
            product *= i;
        }
        
        System.out.println("\n\nSum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Average: " + (sum / 10.0));
        System.out.println("========================================");
    }
}

public class Question19 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     METHOD OVERRIDING DEMONSTRATION");
        System.out.println("========================================");
        
        // Create parent class object
        Calculator calc1 = new Calculator();
        calc1.display();
        
        // Create child class object
        AdvancedCalculator calc2 = new AdvancedCalculator();
        calc2.display();
        
        // Additional functionality
        calc2.calculateBoth();
        
        // Runtime polymorphism
        System.out.println("\n========================================");
        System.out.println("Runtime Polymorphism Demonstration");
        System.out.println("========================================");
        
        Calculator calc3 = new AdvancedCalculator(); // Parent reference, child object
        System.out.println("\nUsing parent reference to child object:");
        calc3.calculate(); // Calls child class method (overridden)
        
        System.out.println("\n========================================");
    }
}
