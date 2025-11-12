/*
 * Q.1: Hierarchical Inheritance - Surface Area Calculation
 * 
 * THEORY:
 * Hierarchical Inheritance is a type of inheritance where multiple derived classes
 * inherit from a single base class. It forms a tree-like structure where one parent
 * class has multiple child classes.
 * 
 * In this program:
 * - Shape (base class) - contains common properties and methods
 * - Cylinder (derived class) - inherits from Shape
 * - Rectangle (derived class) - inherits from Shape
 * 
 * This demonstrates the "IS-A" relationship:
 * - Cylinder IS-A Shape
 * - Rectangle IS-A Shape
 */

// Base class (Parent class)
class Shape {
    protected String shapeName;
    protected double dimension1, dimension2;
    
    // Constructor
    public Shape(String name) {
        this.shapeName = name;
        System.out.println("Shape constructor called for: " + name);
    }
    
    // Method to set dimensions
    public void setDimensions(double d1, double d2) {
        this.dimension1 = d1;
        this.dimension2 = d2;
    }
    
    // Virtual method to calculate surface area (to be overridden)
    public double calculateSurfaceArea() {
        System.out.println("Base class method - should be overridden");
        return 0;
    }
    
    // Method to display shape information
    public void displayInfo() {
        System.out.println("\n--- Shape Information ---");
        System.out.println("Shape Type: " + shapeName);
        System.out.println("Dimension 1: " + dimension1);
        System.out.println("Dimension 2: " + dimension2);
    }
}

// Derived class 1 - Cylinder
class Cylinder extends Shape {
    private double height;
    
    // Constructor
    public Cylinder(double radius, double height) {
        super("Cylinder");  // Call parent constructor
        this.dimension1 = radius;  // radius
        this.height = height;
        System.out.println("Cylinder constructor called");
    }
    
    // Override method to calculate surface area of cylinder
    // Surface Area = 2πr² + 2πrh = 2πr(r + h)
    @Override
    public double calculateSurfaceArea() {
        double radius = dimension1;
        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        return surfaceArea;
    }
    
    // Method specific to Cylinder
    public void displayCylinderDetails() {
        displayInfo();
        System.out.println("Height: " + height);
        System.out.println("Surface Area: " + String.format("%.2f", calculateSurfaceArea()) + " square units");
        System.out.println("Formula Used: 2πr(r + h) where r=" + dimension1 + ", h=" + height);
    }
}

// Derived class 2 - Rectangle
class Rectangle extends Shape {
    private double length, width;
    
    // Constructor
    public Rectangle(double length, double width) {
        super("Rectangle");  // Call parent constructor
        this.length = length;
        this.width = width;
        this.dimension1 = length;
        this.dimension2 = width;
        System.out.println("Rectangle constructor called");
    }
    
    // Override method to calculate surface area of rectangle
    // Surface Area = length × width
    @Override
    public double calculateSurfaceArea() {
        return length * width;
    }
    
    // Method specific to Rectangle
    public void displayRectangleDetails() {
        displayInfo();
        System.out.println("Surface Area: " + String.format("%.2f", calculateSurfaceArea()) + " square units");
        System.out.println("Formula Used: length × width = " + length + " × " + width);
    }
    
    // Additional method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Main class to demonstrate hierarchical inheritance
public class Q1_HierarchicalInheritance {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("    HIERARCHICAL INHERITANCE - SURFACE AREA CALCULATOR");
        System.out.println("==========================================================\n");
        
        // Create Cylinder object
        System.out.println("Creating Cylinder object:");
        System.out.println("-------------------------");
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        cylinder.displayCylinderDetails();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Create Rectangle object
        System.out.println("Creating Rectangle object:");
        System.out.println("--------------------------");
        Rectangle rectangle = new Rectangle(8.0, 6.0);
        rectangle.displayRectangleDetails();
        System.out.println("Perimeter: " + String.format("%.2f", rectangle.calculatePerimeter()) + " units");
        
        System.out.println("\n" + "=".repeat(60));
        
        // Demonstrate polymorphism with hierarchical inheritance
        System.out.println("\nDemonstrating Polymorphism:");
        System.out.println("---------------------------");
        
        Shape[] shapes = {
            new Cylinder(3.0, 7.0),
            new Rectangle(12.0, 4.0)
        };
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\nShape " + (i + 1) + ":");
            System.out.println("Type: " + shapes[i].shapeName);
            System.out.println("Surface Area: " + String.format("%.2f", shapes[i].calculateSurfaceArea()));
        }
        
        System.out.println("\n==========================================================");
        System.out.println("                    CONCEPT EXPLANATION");
        System.out.println("==========================================================");
        System.out.println("1. HIERARCHICAL INHERITANCE:");
        System.out.println("   - Multiple classes inherit from single parent class");
        System.out.println("   - Forms tree-like structure: Shape -> {Cylinder, Rectangle}");
        System.out.println("\n2. KEY FEATURES DEMONSTRATED:");
        System.out.println("   - Constructor chaining (super() call)");
        System.out.println("   - Method overriding (@Override annotation)");
        System.out.println("   - Polymorphism (same method, different behavior)");
        System.out.println("   - Access modifiers (protected in parent class)");
        System.out.println("\n3. BENEFITS:");
        System.out.println("   - Code reusability");
        System.out.println("   - Common interface for different shapes");
        System.out.println("   - Easy to extend (add more shapes)");
        System.out.println("   - Maintains IS-A relationship");
        System.out.println("==========================================================");
    }
}