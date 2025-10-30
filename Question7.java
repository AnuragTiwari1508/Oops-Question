// Question 7: Combinational Boolean Operators
// Demonstrates logical operators (AND, OR, NOT) and combinations

public class Question7 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  COMBINATIONAL BOOLEAN OPERATORS");
        System.out.println("========================================\n");
        
        boolean a = true;
        boolean b = false;
        boolean c = true;
        
        System.out.println("Initial Boolean Values:");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("\n========================================");
        
        // Logical AND operator (&&)
        System.out.println("\nLogical AND (&&) Operator:");
        System.out.println("a && b = " + (a && b));
        System.out.println("a && c = " + (a && c));
        System.out.println("b && c = " + (b && c));
        
        // Logical OR operator (||)
        System.out.println("\nLogical OR (||) Operator:");
        System.out.println("a || b = " + (a || b));
        System.out.println("a || c = " + (a || c));
        System.out.println("b || c = " + (b || c));
        
        // Logical NOT operator (!)
        System.out.println("\nLogical NOT (!) Operator:");
        System.out.println("!a = " + (!a));
        System.out.println("!b = " + (!b));
        System.out.println("!c = " + (!c));
        
        // Combinational Boolean operations
        System.out.println("\nCombinational Boolean Operations:");
        System.out.println("a && b || c = " + (a && b || c));
        System.out.println("(a || b) && c = " + ((a || b) && c));
        System.out.println("!(a && b) = " + (!(a && b)));
        System.out.println("!a || !b = " + (!a || !b));
        System.out.println("a && (b || c) = " + (a && (b || c)));
        System.out.println("(a && b) || (a && c) = " + ((a && b) || (a && c)));
        
        // Relational operators with boolean operations
        System.out.println("\nRelational Operators with Boolean Operations:");
        int x = 10, y = 20, z = 15;
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
        System.out.println("(x < y) && (y > z) = " + ((x < y) && (y > z)));
        System.out.println("(x > y) || (z < y) = " + ((x > y) || (z < y)));
        System.out.println("!(x == y) = " + (!(x == y)));
        System.out.println("(x <= z) && (z <= y) = " + ((x <= z) && (z <= y)));
        
        // Bitwise operators (also work on boolean)
        System.out.println("\nBitwise Boolean Operators:");
        System.out.println("a & b = " + (a & b));  // Bitwise AND
        System.out.println("a | b = " + (a | b));  // Bitwise OR
        System.out.println("a ^ b = " + (a ^ b));  // Bitwise XOR (exclusive OR)
        
        // Short-circuit evaluation
        System.out.println("\nShort-circuit Evaluation:");
        int num = 0;
        boolean result1 = (num != 0) && (10 / num > 1);  // Short-circuits, no division by zero
        System.out.println("(num != 0) && (10 / num > 1) = " + result1);
        
        System.out.println("\n========================================");
    }
}
