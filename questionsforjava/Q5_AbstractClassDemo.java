/*
 * Q.5: Abstract Class - Fencing Cost Calculator
 * 
 * THEORY: ABSTRACT CLASSES IN JAVA
 * 
 * An abstract class is a class that cannot be instantiated directly and is meant
 * to be subclassed. It serves as a blueprint for other classes and can contain
 * both abstract and concrete methods.
 * 
 * KEY FEATURES:
 * 1. Cannot create objects directly (no instantiation)
 * 2. Can have abstract methods (without implementation)
 * 3. Can have concrete methods (with implementation)
 * 4. Can have constructors, fields, and static methods
 * 5. Must be extended by concrete classes
 * 6. Subclasses must implement all abstract methods
 * 
 * ABSTRACT vs INTERFACE:
 * • Abstract class: Can have both abstract and concrete methods
 * • Interface: All methods are abstract (before Java 8)
 * • Abstract class: Can have instance variables
 * • Interface: Only constants (public static final)
 * • Abstract class: Single inheritance
 * • Interface: Multiple inheritance
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// Abstract base class for fencing calculations
abstract class FencingCalculator {
    // Protected fields - accessible to subclasses
    protected double length;
    protected double width;
    protected double costPerUnit;
    protected String plotType;
    protected String ownerName;
    
    // Static field to track total plots calculated
    protected static int totalPlotsCalculated = 0;
    
    // Constructor
    public FencingCalculator(String plotType, String ownerName, double costPerUnit) {
        this.plotType = plotType;
        this.ownerName = ownerName;
        this.costPerUnit = costPerUnit;
        totalPlotsCalculated++;
        System.out.println("FencingCalculator created for " + plotType + " plot");
    }
    
    // Concrete method - common to all subclasses
    public void setDimensions(double length, double width) {
        this.length = length;
        this.width = width;
        System.out.println("Dimensions set: " + length + " x " + width + " units");
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculatePerimeter();
    
    // Abstract method for area calculation
    public abstract double calculateArea();
    
    // Concrete method that uses abstract method
    public final double calculateFencingCost() {
        double perimeter = calculatePerimeter();
        return perimeter * costPerUnit;
    }
    
    // Concrete method for validation
    public boolean validateDimensions() {
        if (length <= 0 || width <= 0) {
            System.out.println("❌ Invalid dimensions: Length and width must be positive");
            return false;
        }
        return true;
    }
    
    // Concrete method for displaying basic information
    public void displayBasicInfo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📋 PLOT INFORMATION");
        System.out.println("=".repeat(50));
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Plot Type: " + plotType);
        System.out.println("Length: " + length + " units");
        System.out.println("Width: " + width + " units");
        System.out.println("Cost per unit: $" + costPerUnit);
    }
    
    // Abstract method for detailed display
    public abstract void displayDetailedReport();
    
    // Static method
    public static int getTotalPlotsCalculated() {
        return totalPlotsCalculated;
    }
    
    // Concrete method with default implementation
    public String getFencingMaterial() {
        return "Standard Wire Fencing";
    }
}

// Concrete subclass for rectangular plots
class RectangularPlot extends FencingCalculator {
    private double gateWidth;
    private boolean hasCornerPosts;
    private int numberOfGates;
    
    // Constructor
    public RectangularPlot(String ownerName, double costPerUnit) {
        super("Rectangular", ownerName, costPerUnit);
        this.gateWidth = 0;
        this.hasCornerPosts = true;
        this.numberOfGates = 1;
    }
    
    // Constructor with additional parameters
    public RectangularPlot(String ownerName, double costPerUnit, double gateWidth, int numberOfGates) {
        super("Rectangular", ownerName, costPerUnit);
        this.gateWidth = gateWidth;
        this.numberOfGates = numberOfGates;
        this.hasCornerPosts = true;
    }
    
    // Implementation of abstract method
    @Override
    public double calculatePerimeter() {
        double perimeter = 2 * (length + width);
        // Subtract gate widths as they don't need fencing
        double totalGateWidth = gateWidth * numberOfGates;
        return Math.max(0, perimeter - totalGateWidth);
    }
    
    // Implementation of abstract method
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    // Override concrete method to provide specific implementation
    @Override
    public String getFencingMaterial() {
        if (calculateArea() > 1000) {
            return "Heavy Duty Chain Link Fencing";
        } else {
            return "Standard Wire Fencing";
        }
    }
    
    // Implementation of abstract method
    @Override
    public void displayDetailedReport() {
        displayBasicInfo();
        
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("\n📊 CALCULATIONS");
        System.out.println("=".repeat(50));
        System.out.println("Area: " + df.format(calculateArea()) + " square units");
        System.out.println("Full Perimeter: " + df.format(2 * (length + width)) + " units");
        System.out.println("Number of Gates: " + numberOfGates);
        System.out.println("Gate Width (each): " + gateWidth + " units");
        System.out.println("Total Gate Width: " + df.format(gateWidth * numberOfGates) + " units");
        System.out.println("Fencing Required: " + df.format(calculatePerimeter()) + " units");
        
        double totalCost = calculateFencingCost();
        double materialCost = totalCost * 0.7; // 70% materials
        double laborCost = totalCost * 0.3;    // 30% labor
        
        System.out.println("\n💰 COST BREAKDOWN");
        System.out.println("=".repeat(50));
        System.out.println("Fencing Material: " + getFencingMaterial());
        System.out.println("Material Cost: $" + df.format(materialCost));
        System.out.println("Labor Cost: $" + df.format(laborCost));
        System.out.println("TOTAL COST: $" + df.format(totalCost));
        
        // Additional rectangular-specific information
        System.out.println("\n🔧 RECTANGULAR PLOT SPECIFICS");
        System.out.println("=".repeat(50));
        System.out.println("Corner Posts Required: " + (hasCornerPosts ? "Yes (4 posts)" : "No"));
        System.out.println("Post Spacing: Every 8 units (recommended)");
        
        double posts = Math.ceil(calculatePerimeter() / 8) + 4; // Corner posts + intermediate
        System.out.println("Estimated Posts Needed: " + (int)posts);
        
        // Calculate additional costs
        double postCost = posts * 15; // $15 per post
        double gateCost = numberOfGates * 120; // $120 per gate
        
        System.out.println("\n💸 ADDITIONAL COSTS");
        System.out.println("=".repeat(50));
        System.out.println("Posts (" + (int)posts + " × $15): $" + df.format(postCost));
        System.out.println("Gates (" + numberOfGates + " × $120): $" + df.format(gateCost));
        System.out.println("GRAND TOTAL: $" + df.format(totalCost + postCost + gateCost));
        
        System.out.println("=".repeat(50));
    }
    
    // Specific method for rectangular plots
    public void setGateDetails(double gateWidth, int numberOfGates) {
        this.gateWidth = gateWidth;
        this.numberOfGates = numberOfGates;
        System.out.println("Gate details updated: " + numberOfGates + " gates, " + gateWidth + " units wide each");
    }
    
    // Method to calculate diagonal (specific to rectangle)
    public double calculateDiagonal() {
        return Math.sqrt(length * length + width * width);
    }
}

// Another concrete subclass for square plots (special case of rectangle)
class SquarePlot extends FencingCalculator {
    private double side;
    private boolean decorativeFencing;
    
    // Constructor
    public SquarePlot(String ownerName, double costPerUnit, boolean decorativeFencing) {
        super("Square", ownerName, costPerUnit);
        this.decorativeFencing = decorativeFencing;
    }
    
    // Override setDimensions for square
    @Override
    public void setDimensions(double length, double width) {
        if (length != width) {
            System.out.println("⚠️  Warning: Square plot should have equal sides. Using length as side.");
        }
        this.side = length;
        this.length = length;
        this.width = length;
        System.out.println("Square side set: " + side + " units");
    }
    
    // Set side directly
    public void setSide(double side) {
        this.side = side;
        this.length = side;
        this.width = side;
        System.out.println("Square side set: " + side + " units");
    }
    
    // Implementation of abstract methods
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }
    
    @Override
    public String getFencingMaterial() {
        if (decorativeFencing) {
            return "Decorative Wrought Iron Fencing";
        } else {
            return "Standard Wire Fencing";
        }
    }
    
    @Override
    public void displayDetailedReport() {
        displayBasicInfo();
        
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("\n📊 CALCULATIONS");
        System.out.println("=".repeat(50));
        System.out.println("Side Length: " + side + " units");
        System.out.println("Area: " + df.format(calculateArea()) + " square units");
        System.out.println("Perimeter: " + df.format(calculatePerimeter()) + " units");
        
        double baseCost = calculateFencingCost();
        double decorativeMultiplier = decorativeFencing ? 2.5 : 1.0;
        double totalCost = baseCost * decorativeMultiplier;
        
        System.out.println("\n💰 COST BREAKDOWN");
        System.out.println("=".repeat(50));
        System.out.println("Fencing Material: " + getFencingMaterial());
        System.out.println("Base Cost: $" + df.format(baseCost));
        
        if (decorativeFencing) {
            System.out.println("Decorative Multiplier: 2.5x");
            System.out.println("Decorative Upgrade: $" + df.format(totalCost - baseCost));
        }
        
        System.out.println("TOTAL COST: $" + df.format(totalCost));
        
        System.out.println("\n🔧 SQUARE PLOT SPECIFICS");
        System.out.println("=".repeat(50));
        System.out.println("Corner Posts: 4 (one at each corner)");
        System.out.println("Symmetrical Design: Yes");
        System.out.println("Decorative Fencing: " + (decorativeFencing ? "Yes" : "No"));
        
        System.out.println("=".repeat(50));
    }
}

// Utility class for managing multiple plots
class PlotManager {
    private List<FencingCalculator> plots;
    
    public PlotManager() {
        plots = new ArrayList<>();
    }
    
    public void addPlot(FencingCalculator plot) {
        plots.add(plot);
    }
    
    public void displayAllPlots() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("             📋 ALL PLOTS SUMMARY");
        System.out.println("=".repeat(60));
        
        if (plots.isEmpty()) {
            System.out.println("No plots registered.");
            return;
        }
        
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double totalCost = 0;
        
        for (int i = 0; i < plots.size(); i++) {
            FencingCalculator plot = plots.get(i);
            double cost = plot.calculateFencingCost();
            totalCost += cost;
            
            System.out.println((i + 1) + ". " + plot.plotType + " Plot - " + plot.ownerName);
            System.out.println("   Dimensions: " + plot.length + " x " + plot.width);
            System.out.println("   Area: " + df.format(plot.calculateArea()) + " sq units");
            System.out.println("   Perimeter: " + df.format(plot.calculatePerimeter()) + " units");
            System.out.println("   Cost: $" + df.format(cost));
            System.out.println();
        }
        
        System.out.println("Total Plots: " + plots.size());
        System.out.println("Combined Fencing Cost: $" + df.format(totalCost));
        System.out.println("=".repeat(60));
    }
}

// Main class
public class Q5_AbstractClassDemo {
    
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("        ABSTRACT CLASS - FENCING COST CALCULATOR");
        System.out.println("==========================================================\n");
        
        Scanner scanner = new Scanner(System.in);
        PlotManager manager = new PlotManager();
        
        try {
            demonstrateAbstractClass(manager);
            
            System.out.println("\n" + "=".repeat(60) + "\n");
            
            // Interactive mode
            System.out.println("🔧 INTERACTIVE FENCING CALCULATOR");
            System.out.println("Would you like to calculate fencing for your own plot? (y/n): ");
            String response = scanner.nextLine().toLowerCase();
            
            if (response.startsWith("y")) {
                interactiveCalculation(scanner, manager);
            }
            
            // Display all plots
            manager.displayAllPlots();
            
            // Print abstract class theory
            printAbstractClassTheory();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    // Method to demonstrate abstract class concepts
    private static void demonstrateAbstractClass(PlotManager manager) {
        System.out.println("🏠 DEMONSTRATION OF ABSTRACT CLASS CONCEPTS");
        System.out.println("=".repeat(60));
        
        // Create rectangular plot
        System.out.println("\n1. Creating Rectangular Plot:");
        System.out.println("-".repeat(30));
        RectangularPlot rectPlot = new RectangularPlot("John Smith", 25.50);
        rectPlot.setDimensions(30, 20);
        rectPlot.setGateDetails(3, 2); // 2 gates, 3 units wide each
        
        if (rectPlot.validateDimensions()) {
            rectPlot.displayDetailedReport();
        }
        
        manager.addPlot(rectPlot);
        
        System.out.println("\n" + "=".repeat(60));
        
        // Create square plot
        System.out.println("\n2. Creating Square Plot:");
        System.out.println("-".repeat(25));
        SquarePlot squarePlot = new SquarePlot("Alice Johnson", 35.00, true);
        squarePlot.setSide(15);
        
        if (squarePlot.validateDimensions()) {
            squarePlot.displayDetailedReport();
        }
        
        manager.addPlot(squarePlot);
        
        System.out.println("\n" + "=".repeat(60));
        
        // Demonstrate polymorphism with abstract class
        System.out.println("\n3. Demonstrating Polymorphism:");
        System.out.println("-".repeat(30));
        
        FencingCalculator[] plots = {
            new RectangularPlot("Bob Wilson", 20.00),
            new SquarePlot("Carol Brown", 30.00, false)
        };
        
        plots[0].setDimensions(25, 15);
        plots[1].setDimensions(12, 12);
        
        for (FencingCalculator plot : plots) {
            System.out.println("\nPlot Type: " + plot.plotType);
            System.out.println("Perimeter: " + plot.calculatePerimeter() + " units");
            System.out.println("Area: " + plot.calculateArea() + " square units");
            System.out.println("Fencing Cost: $" + new DecimalFormat("#,##0.00").format(plot.calculateFencingCost()));
            System.out.println("Material: " + plot.getFencingMaterial());
        }
        
        System.out.println("\nTotal plots calculated so far: " + FencingCalculator.getTotalPlotsCalculated());
    }
    
    // Interactive calculation method
    private static void interactiveCalculation(Scanner scanner, PlotManager manager) {
        System.out.println("\n📝 INTERACTIVE PLOT CALCULATION");
        System.out.println("=".repeat(40));
        
        try {
            System.out.print("Enter owner name: ");
            String ownerName = scanner.nextLine();
            
            System.out.print("Enter cost per unit ($): ");
            double costPerUnit = scanner.nextDouble();
            
            System.out.println("\nChoose plot type:");
            System.out.println("1. Rectangular Plot");
            System.out.println("2. Square Plot");
            System.out.print("Enter choice (1-2): ");
            int choice = scanner.nextInt();
            
            FencingCalculator plot = null;
            
            switch (choice) {
                case 1:
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    
                    RectangularPlot rectPlot = new RectangularPlot(ownerName, costPerUnit);
                    rectPlot.setDimensions(length, width);
                    
                    System.out.print("Number of gates (0 for none): ");
                    int gates = scanner.nextInt();
                    if (gates > 0) {
                        System.out.print("Width of each gate: ");
                        double gateWidth = scanner.nextDouble();
                        rectPlot.setGateDetails(gateWidth, gates);
                    }
                    
                    plot = rectPlot;
                    break;
                    
                case 2:
                    System.out.print("Enter side length: ");
                    double side = scanner.nextDouble();
                    
                    System.out.print("Decorative fencing? (true/false): ");
                    boolean decorative = scanner.nextBoolean();
                    
                    SquarePlot squarePlot = new SquarePlot(ownerName, costPerUnit, decorative);
                    squarePlot.setSide(side);
                    
                    plot = squarePlot;
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
                    return;
            }
            
            if (plot != null && plot.validateDimensions()) {
                plot.displayDetailedReport();
                manager.addPlot(plot);
            }
            
        } catch (Exception e) {
            System.out.println("Error in input: " + e.getMessage());
        }
    }
    
    // Method to print abstract class theory
    private static void printAbstractClassTheory() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                 ABSTRACT CLASS THEORY");
        System.out.println("=".repeat(60));
        
        System.out.println("\nWHAT IS AN ABSTRACT CLASS?");
        System.out.println("-".repeat(25));
        System.out.println("• A class declared with 'abstract' keyword");
        System.out.println("• Cannot be instantiated directly");
        System.out.println("• Designed to be extended by other classes");
        System.out.println("• Provides a template for subclasses");
        
        System.out.println("\nKEY FEATURES:");
        System.out.println("-".repeat(13));
        System.out.println("• Can have abstract methods (no implementation)");
        System.out.println("• Can have concrete methods (with implementation)");
        System.out.println("• Can have instance variables and constructors");
        System.out.println("• Can have static and final methods");
        System.out.println("• Subclasses must implement all abstract methods");
        
        System.out.println("\nABSTRACT vs CONCRETE METHODS:");
        System.out.println("-".repeat(29));
        System.out.println("Abstract Method:");
        System.out.println("  • Declared without implementation");
        System.out.println("  • Must be implemented in subclass");
        System.out.println("  • Uses 'abstract' keyword");
        System.out.println("\nConcrete Method:");
        System.out.println("  • Has complete implementation");
        System.out.println("  • Can be used as-is or overridden");
        System.out.println("  • Provides default behavior");
        
        System.out.println("\nABSTRACT CLASS vs INTERFACE:");
        System.out.println("-".repeat(28));
        System.out.println("Abstract Class:");
        System.out.println("  • Can have both abstract and concrete methods");
        System.out.println("  • Can have instance variables");
        System.out.println("  • Can have constructors");
        System.out.println("  • Single inheritance only");
        System.out.println("\nInterface:");
        System.out.println("  • All methods abstract (before Java 8)");
        System.out.println("  • Only constants allowed");
        System.out.println("  • No constructors");
        System.out.println("  • Multiple inheritance supported");
        
        System.out.println("\nBENEFITS OF ABSTRACT CLASSES:");
        System.out.println("-".repeat(25));
        System.out.println("• Code reusability (common methods in base class)");
        System.out.println("• Enforced structure (abstract methods must be implemented)");
        System.out.println("• Polymorphism support");
        System.out.println("• Partial implementation (mix of abstract and concrete)");
        System.out.println("• Template method pattern implementation");
        
        System.out.println("\nWHEN TO USE ABSTRACT CLASSES:");
        System.out.println("-".repeat(26));
        System.out.println("• Multiple classes share common code");
        System.out.println("• Need to enforce certain methods in subclasses");
        System.out.println("• Want to provide default implementations");
        System.out.println("• Need instance variables in base class");
        System.out.println("• Implementing template method pattern");
        
        System.out.println("\nEXAMPLE SYNTAX:");
        System.out.println("-".repeat(15));
        System.out.println("abstract class AbstractClass {");
        System.out.println("    // Instance variable");
        System.out.println("    protected int value;");
        System.out.println("    ");
        System.out.println("    // Constructor");
        System.out.println("    public AbstractClass(int value) {");
        System.out.println("        this.value = value;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Abstract method");
        System.out.println("    public abstract void abstractMethod();");
        System.out.println("    ");
        System.out.println("    // Concrete method");
        System.out.println("    public void concreteMethod() {");
        System.out.println("        System.out.println(\"Implemented in abstract class\");");
        System.out.println("    }");
        System.out.println("}");
        
        System.out.println("\n" + "=".repeat(60));
    }
}