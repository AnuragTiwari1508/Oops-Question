// Question 24: User-Defined Exception
// Calculate room area and whitewashing cost with custom exception
// Takes command-line arguments: length, breadth, height, cost_per_sqm

// Custom Exception class
class InvalidRoomDimensionException extends Exception {
    public InvalidRoomDimensionException(String message) {
        super(message);
    }
}

// Room class
class Room {
    double length;
    double breadth;
    double height;
    
    // Constructor with validation
    Room(double length, double breadth, double height) throws InvalidRoomDimensionException {
        if (length < 1) {
            throw new InvalidRoomDimensionException("Invalid Length: " + length + " (must be >= 1)");
        }
        if (breadth < 1) {
            throw new InvalidRoomDimensionException("Invalid Breadth: " + breadth + " (must be >= 1)");
        }
        if (height < 1) {
            throw new InvalidRoomDimensionException("Invalid Height: " + height + " (must be >= 1)");
        }
        
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }
    
    // Calculate wall area for whitewashing (4 walls, excluding floor and ceiling)
    double calculateWallArea() {
        return 2 * (length * height + breadth * height);
    }
    
    // Calculate ceiling area
    double calculateCeilingArea() {
        return length * breadth;
    }
    
    // Calculate total area to be whitewashed (walls + ceiling)
    double calculateTotalArea() {
        return calculateWallArea() + calculateCeilingArea();
    }
    
    // Calculate whitewashing cost
    double calculateWhitewashingCost(double costPerSqm) {
        return calculateTotalArea() * costPerSqm;
    }
    
    // Display room details
    void displayDetails(double costPerSqm) {
        System.out.println("\n========================================");
        System.out.println("         ROOM DETAILS");
        System.out.println("========================================");
        System.out.println("Length: " + length + " meters");
        System.out.println("Breadth: " + breadth + " meters");
        System.out.println("Height: " + height + " meters");
        System.out.println("----------------------------------------");
        System.out.printf("Wall Area: %.2f sq.m\n", calculateWallArea());
        System.out.printf("Ceiling Area: %.2f sq.m\n", calculateCeilingArea());
        System.out.printf("Total Area to Whitewash: %.2f sq.m\n", calculateTotalArea());
        System.out.println("----------------------------------------");
        System.out.printf("Cost per sq.m: Rs.%.2f\n", costPerSqm);
        System.out.printf("Total Whitewashing Cost: Rs.%.2f\n", calculateWhitewashingCost(costPerSqm));
        System.out.println("========================================");
    }
}

public class Question24 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  ROOM WHITEWASHING COST CALCULATOR");
        System.out.println("  (With User-Defined Exception)");
        System.out.println("========================================");
        
        // Check if command-line arguments are provided
        if (args.length < 4) {
            System.out.println("\n⚠ ERROR: Insufficient arguments!");
            System.out.println("\nUsage: java Question24 <length> <breadth> <height> <cost_per_sqm>");
            System.out.println("\nExample: java Question24 10 12 8 50");
            System.out.println("\nRunning with default values for demonstration...");
            
            // Use default values for demonstration
            args = new String[]{"10", "12", "8", "50"};
        }
        
        try {
            // Parse command-line arguments
            double length = Double.parseDouble(args[0]);
            double breadth = Double.parseDouble(args[1]);
            double height = Double.parseDouble(args[2]);
            double costPerSqm = Double.parseDouble(args[3]);
            
            System.out.println("\nInput Parameters:");
            System.out.println("Length: " + length + " meters");
            System.out.println("Breadth: " + breadth + " meters");
            System.out.println("Height: " + height + " meters");
            System.out.println("Cost per sq.m: Rs." + costPerSqm);
            
            // Create Room object (may throw exception if dimensions are invalid)
            Room room = new Room(length, breadth, height);
            
            // Display calculations
            room.displayDetails(costPerSqm);
            
            // Additional information
            System.out.println("\n========================================");
            System.out.println("          BREAKDOWN");
            System.out.println("========================================");
            System.out.println("Wall 1 (Length × Height): " + length + " × " + height + " = " + (length * height) + " sq.m");
            System.out.println("Wall 2 (Breadth × Height): " + breadth + " × " + height + " = " + (breadth * height) + " sq.m");
            System.out.println("Wall 3 (Length × Height): " + length + " × " + height + " = " + (length * height) + " sq.m");
            System.out.println("Wall 4 (Breadth × Height): " + breadth + " × " + height + " = " + (breadth * height) + " sq.m");
            System.out.println("Ceiling (Length × Breadth): " + length + " × " + breadth + " = " + (length * breadth) + " sq.m");
            System.out.println("========================================");
            
            System.out.println("\n✓ SUCCESS: All dimensions are valid!");
            System.out.println("✓ Calculations completed successfully!");
            
        } catch (InvalidRoomDimensionException e) {
            // Handle custom exception
            System.out.println("\n========================================");
            System.out.println("❌ EXCEPTION CAUGHT!");
            System.out.println("========================================");
            System.out.println("Error: " + e.getMessage());
            System.out.println("\nAll room dimensions (length, breadth, height)");
            System.out.println("must be greater than or equal to 1 meter.");
            System.out.println("========================================");
            
        } catch (NumberFormatException e) {
            // Handle invalid number format
            System.out.println("\n========================================");
            System.out.println("❌ ERROR: Invalid Number Format!");
            System.out.println("========================================");
            System.out.println("Please provide valid numeric values.");
            System.out.println("Error details: " + e.getMessage());
            System.out.println("========================================");
            
        } catch (Exception e) {
            // Handle any other exception
            System.out.println("\n========================================");
            System.out.println("❌ UNEXPECTED ERROR!");
            System.out.println("========================================");
            System.out.println("Error: " + e.getMessage());
            System.out.println("========================================");
        }
        
        // Test cases demonstration
        System.out.println("\n========================================");
        System.out.println("      TEST CASES DEMONSTRATION");
        System.out.println("========================================");
        
        testRoom(15, 12, 10, 45);  // Valid
        testRoom(0, 10, 8, 50);     // Invalid length
        testRoom(10, -5, 8, 50);    // Invalid breadth
        testRoom(10, 12, 0.5, 50);  // Invalid height
        
        System.out.println("\n========================================");
        System.out.println("Program execution completed!");
        System.out.println("========================================");
    }
    
    // Helper method to test different room dimensions
    static void testRoom(double length, double breadth, double height, double cost) {
        System.out.println("\nTesting: Length=" + length + ", Breadth=" + breadth + ", Height=" + height);
        try {
            Room room = new Room(length, breadth, height);
            System.out.printf("✓ Valid - Total Area: %.2f sq.m, Cost: Rs.%.2f\n", 
                room.calculateTotalArea(), room.calculateWhitewashingCost(cost));
        } catch (InvalidRoomDimensionException e) {
            System.out.println("✗ Invalid - " + e.getMessage());
        }
    }
}
