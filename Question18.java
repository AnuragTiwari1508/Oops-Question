// Question 18: Hierarchical Inheritance
// Parent class Shape, child classes Circle and Rectangle
// Calculate area, perimeter, and fencing cost

import java.util.Scanner;

// Parent class
class Shape {
    double costPerUnit;
    
    void setCostPerUnit(double cost) {
        this.costPerUnit = cost;
    }
    
    void displayCost(double perimeter) {
        double totalCost = perimeter * costPerUnit;
        System.out.printf("Cost per unit: Rs.%.2f\n", costPerUnit);
        System.out.printf("Total Fencing Cost: Rs.%.2f\n", totalCost);
    }
}

// Child class - Circle
class Circle extends Shape {
    double radius;
    final double PI = 3.14159;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    double calculateArea() {
        return PI * radius * radius;
    }
    
    double calculatePerimeter() {
        return 2 * PI * radius;
    }
    
    void display() {
        System.out.println("========================================");
        System.out.println("         CIRCLE DETAILS");
        System.out.println("========================================");
        System.out.println("Radius: " + radius + " units");
        System.out.printf("Area: %.2f square units\n", calculateArea());
        System.out.printf("Perimeter (Circumference): %.2f units\n", calculatePerimeter());
        displayCost(calculatePerimeter());
        System.out.println("========================================");
    }
}

// Child class - Rectangle
class Rectangle extends Shape {
    double length;
    double breadth;
    
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    
    double calculateArea() {
        return length * breadth;
    }
    
    double calculatePerimeter() {
        return 2 * (length + breadth);
    }
    
    void display() {
        System.out.println("========================================");
        System.out.println("        RECTANGLE DETAILS");
        System.out.println("========================================");
        System.out.println("Length: " + length + " units");
        System.out.println("Breadth: " + breadth + " units");
        System.out.printf("Area: %.2f square units\n", calculateArea());
        System.out.printf("Perimeter: %.2f units\n", calculatePerimeter());
        displayCost(calculatePerimeter());
        System.out.println("========================================");
    }
}

public class Question18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   HIERARCHICAL INHERITANCE DEMO");
        System.out.println("   (Shape -> Circle & Rectangle)");
        System.out.println("========================================\n");
        
        // Circle calculations
        System.out.println("--- CIRCULAR PLOT ---");
        System.out.print("Enter radius of circle: ");
        double radius = scanner.nextDouble();
        
        System.out.print("Enter cost per unit for fencing: Rs.");
        double circleCost = scanner.nextDouble();
        
        Circle circle = new Circle(radius);
        circle.setCostPerUnit(circleCost);
        System.out.println();
        circle.display();
        
        // Rectangle calculations
        System.out.println("\n--- RECTANGULAR PLOT ---");
        System.out.print("Enter length of rectangle: ");
        double length = scanner.nextDouble();
        
        System.out.print("Enter breadth of rectangle: ");
        double breadth = scanner.nextDouble();
        
        System.out.print("Enter cost per unit for fencing: Rs.");
        double rectCost = scanner.nextDouble();
        
        Rectangle rectangle = new Rectangle(length, breadth);
        rectangle.setCostPerUnit(rectCost);
        System.out.println();
        rectangle.display();
        
        // Comparison
        System.out.println("\n========================================");
        System.out.println("           COMPARISON");
        System.out.println("========================================");
        System.out.printf("Circle Area: %.2f sq units\n", circle.calculateArea());
        System.out.printf("Rectangle Area: %.2f sq units\n", rectangle.calculateArea());
        
        if (circle.calculateArea() > rectangle.calculateArea()) {
            System.out.println("Circle has larger area!");
        } else if (circle.calculateArea() < rectangle.calculateArea()) {
            System.out.println("Rectangle has larger area!");
        } else {
            System.out.println("Both have equal area!");
        }
        System.out.println("========================================");
        
        scanner.close();
    }
}
