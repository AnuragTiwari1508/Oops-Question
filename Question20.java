// Question 20: Abstract Class for Type Conversion
// Abstract methods to convert String to int and String to double

import java.util.Scanner;

// Abstract class
abstract class TypeConverter {
    // Abstract method to convert String to int
    abstract int convertToInt(String str);
    
    // Abstract method to convert String to double
    abstract double convertToDouble(String str);
    
    // Concrete method in abstract class
    void displayInfo() {
        System.out.println("Type Converter - Converts String to numeric types");
    }
}

// Concrete class implementing abstract methods
class StringToNumberConverter extends TypeConverter {
    
    @Override
    int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid integer format!");
            return 0;
        }
    }
    
    @Override
    double convertToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid double format!");
            return 0.0;
        }
    }
    
    // Additional method for validation
    boolean isValidNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    void displayConversionResults(String intStr, String doubleStr) {
        System.out.println("\n========================================");
        System.out.println("       CONVERSION RESULTS");
        System.out.println("========================================");
        
        // Convert to int
        System.out.println("String to Integer Conversion:");
        System.out.println("Input String: \"" + intStr + "\"");
        if (isValidNumber(intStr)) {
            int intValue = convertToInt(intStr);
            System.out.println("Converted Integer: " + intValue);
            System.out.println("Double of value: " + (intValue * 2));
            System.out.println("Square of value: " + (intValue * intValue));
        } else {
            System.out.println("Invalid integer string!");
        }
        
        System.out.println("\n----------------------------------------");
        
        // Convert to double
        System.out.println("String to Double Conversion:");
        System.out.println("Input String: \"" + doubleStr + "\"");
        if (isValidNumber(doubleStr)) {
            double doubleValue = convertToDouble(doubleStr);
            System.out.printf("Converted Double: %.4f\n", doubleValue);
            System.out.printf("Double of value: %.4f\n", (doubleValue * 2));
            System.out.printf("Square of value: %.4f\n", (doubleValue * doubleValue));
        } else {
            System.out.println("Invalid double string!");
        }
        
        System.out.println("========================================");
    }
}

public class Question20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   ABSTRACT CLASS DEMONSTRATION");
        System.out.println("   (String to Number Conversion)");
        System.out.println("========================================\n");
        
        StringToNumberConverter converter = new StringToNumberConverter();
        converter.displayInfo();
        
        System.out.println("\n========================================");
        
        // Integer conversion
        System.out.print("Enter a string to convert to integer: ");
        String intString = scanner.nextLine();
        
        // Double conversion
        System.out.print("Enter a string to convert to double: ");
        String doubleString = scanner.nextLine();
        
        // Display results
        converter.displayConversionResults(intString, doubleString);
        
        // Additional examples
        System.out.println("\n========================================");
        System.out.println("      ADDITIONAL EXAMPLES");
        System.out.println("========================================");
        
        String[] testInts = {"123", "456", "-789", "0"};
        String[] testDoubles = {"123.45", "67.89", "-10.5", "3.14159"};
        
        System.out.println("\nInteger Conversions:");
        for (String str : testInts) {
            int value = converter.convertToInt(str);
            System.out.println("\"" + str + "\" -> " + value);
        }
        
        System.out.println("\nDouble Conversions:");
        for (String str : testDoubles) {
            double value = converter.convertToDouble(str);
            System.out.printf("\"%s\" -> %.4f\n", str, value);
        }
        
        System.out.println("========================================");
        
        scanner.close();
    }
}
