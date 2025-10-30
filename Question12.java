// Question 12: Circle Class with Circumference and Arc Length
// Computes circumference and arc length for given radius and angle
// Formula: Circumference = 2πr, Arc Length = (angle/360) × 2πr

class Circle {
    double radius;
    final double PI = 3.14159;
    
    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }
    
    // Method to compute circumference
    double circumCircle() {
        return 2 * PI * radius;
    }
    
    // Method to compute arc length for given angle
    double arcLength(double angle) {
        return (angle / 360.0) * 2 * PI * radius;
    }
    
    // Method to display results
    void display(double angle) {
        System.out.println("========================================");
        System.out.println("         CIRCLE CALCULATIONS");
        System.out.println("========================================");
        System.out.println("Radius: " + radius + " units");
        System.out.println("Angle: " + angle + " degrees");
        System.out.println("----------------------------------------");
        System.out.printf("Circumference: %.4f units\n", circumCircle());
        System.out.printf("Arc Length: %.4f units\n", arcLength(angle));
        System.out.println("========================================");
    }
}

public class Question12 {
    public static void main(String[] args) {
        // Create circle with radius 10
        Circle circle = new Circle(10);
        
        // Compute and display for angle 37 degrees
        circle.display(37);
        
        System.out.println("\n--- Additional Examples ---\n");
        
        // Example with 90 degrees
        System.out.println("For 90 degrees angle:");
        System.out.printf("Arc Length: %.4f units\n", circle.arcLength(90));
        
        // Example with 180 degrees (semicircle)
        System.out.println("\nFor 180 degrees angle:");
        System.out.printf("Arc Length: %.4f units\n", circle.arcLength(180));
    }
}
