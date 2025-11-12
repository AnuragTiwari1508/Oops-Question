/*
 * Q.4: ClassNotFoundException Demonstration and Handling
 * 
 * THEORY: ClassNotFoundException
 * 
 * ClassNotFoundException is a checked exception that occurs when the Java Virtual
 * Machine (JVM) tries to load a class through its string name but cannot find
 * the definition of the class.
 * 
 * WHEN DOES IT OCCUR?
 * 1. Class.forName() - Dynamic class loading
 * 2. ClassLoader.loadClass() - Custom class loading
 * 3. ClassLoader.findSystemClass() - System class loading
 * 
 * COMMON CAUSES:
 * • Class not present in classpath
 * • Typo in class name
 * • Wrong package name
 * • Missing JAR files
 * • Case sensitivity issues
 * 
 * HANDLING STRATEGIES:
 * 1. try-catch blocks
 * 2. Verify classpath
 * 3. Check class names
 * 4. Use proper package names
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Q4_ClassNotFoundExceptionDemo {
    
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("      ClassNotFoundException DEMONSTRATION & HANDLING");
        System.out.println("==========================================================\n");
        
        ClassNotFoundDemo demo = new ClassNotFoundDemo();
        
        // Demonstrate different scenarios
        demo.demonstrateBasicClassNotFoundException();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateSuccessfulClassLoading();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateReflectionWithException();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateCustomClassLoader();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        demo.demonstrateHandlingStrategies();
        
        // Print comprehensive theory
        demo.printClassNotFoundTheory();
    }
}

class ClassNotFoundDemo {
    
    // 1. Basic ClassNotFoundException demonstration
    public void demonstrateBasicClassNotFoundException() {
        System.out.println("1. BASIC ClassNotFoundException DEMONSTRATION:");
        System.out.println("---------------------------------------------");
        
        // Scenario 1: Non-existent class
        try {
            System.out.println("Attempting to load non-existent class 'com.example.NonExistentClass'...");
            Class<?> clazz = Class.forName("com.example.NonExistentClass");
            System.out.println("Class loaded successfully: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("✗ ClassNotFoundException caught!");
            System.out.println("  Message: " + e.getMessage());
            System.out.println("  Cause: Class not found in classpath");
            System.out.println("  This is a CHECKED exception - must be handled");
        }
        
        // Scenario 2: Typo in class name
        try {
            System.out.println("\nAttempting to load class with typo 'java.lang.Strng'...");
            Class<?> clazz = Class.forName("java.lang.Strng"); // Missing 'i' in String
            System.out.println("Class loaded: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("✗ ClassNotFoundException caught!");
            System.out.println("  Message: " + e.getMessage());
            System.out.println("  Cause: Typo in class name");
        }
        
        // Scenario 3: Wrong package name
        try {
            System.out.println("\nAttempting to load class with wrong package 'java.utils.ArrayList'...");
            Class<?> clazz = Class.forName("java.utils.ArrayList"); // Should be java.util
            System.out.println("Class loaded: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("✗ ClassNotFoundException caught!");
            System.out.println("  Message: " + e.getMessage());
            System.out.println("  Cause: Wrong package name");
        }
    }
    
    // 2. Successful class loading examples
    public void demonstrateSuccessfulClassLoading() {
        System.out.println("2. SUCCESSFUL CLASS LOADING EXAMPLES:");
        System.out.println("-------------------------------------");
        
        // Load standard Java classes
        String[] classNames = {
            "java.lang.String",
            "java.util.ArrayList",
            "java.io.FileInputStream",
            "java.lang.Math",
            "java.util.HashMap"
        };
        
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                System.out.println("✓ Successfully loaded: " + clazz.getName());
                System.out.println("  Package: " + clazz.getPackage().getName());
                System.out.println("  Simple Name: " + clazz.getSimpleName());
                System.out.println("  Is Interface: " + clazz.isInterface());
                System.out.println();
            } catch (ClassNotFoundException e) {
                System.out.println("✗ Failed to load: " + className);
            }
        }
    }
    
    // 3. Reflection with exception handling
    public void demonstrateReflectionWithException() {
        System.out.println("3. REFLECTION WITH EXCEPTION HANDLING:");
        System.out.println("--------------------------------------");
        
        try {
            // Load String class and inspect it
            Class<?> stringClass = Class.forName("java.lang.String");
            System.out.println("Analyzing class: " + stringClass.getName());
            
            // Get constructors
            Constructor<?>[] constructors = stringClass.getConstructors();
            System.out.println("\nConstructors found: " + constructors.length);
            for (int i = 0; i < Math.min(3, constructors.length); i++) {
                System.out.println("  " + (i+1) + ". " + constructors[i]);
            }
            
            // Get methods
            Method[] methods = stringClass.getMethods();
            System.out.println("\nTotal methods: " + methods.length);
            System.out.println("Sample methods:");
            int count = 0;
            for (Method method : methods) {
                if (count < 5) {
                    System.out.println("  • " + method.getName() + "()");
                    count++;
                }
            }
            
            // Get fields
            Field[] fields = stringClass.getFields();
            System.out.println("\nPublic fields: " + fields.length);
            for (Field field : fields) {
                System.out.println("  • " + field.getName() + " : " + field.getType().getSimpleName());
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Error during reflection: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }
    }
    
    // 4. Custom class loader demonstration
    public void demonstrateCustomClassLoader() {
        System.out.println("4. CUSTOM CLASS LOADER DEMONSTRATION:");
        System.out.println("-------------------------------------");
        
        try {
            // Get current class loader
            ClassLoader currentLoader = this.getClass().getClassLoader();
            System.out.println("Current ClassLoader: " + currentLoader.getClass().getName());
            
            // Try to load a class using different approaches
            System.out.println("\nTrying different class loading approaches:");
            
            // Approach 1: Using current class loader
            try {
                Class<?> clazz1 = currentLoader.loadClass("java.lang.Integer");
                System.out.println("✓ Loaded via current loader: " + clazz1.getName());
            } catch (ClassNotFoundException e) {
                System.out.println("✗ Failed via current loader: " + e.getMessage());
            }
            
            // Approach 2: Using system class loader
            try {
                ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
                Class<?> clazz2 = systemLoader.loadClass("java.lang.Double");
                System.out.println("✓ Loaded via system loader: " + clazz2.getName());
            } catch (ClassNotFoundException e) {
                System.out.println("✗ Failed via system loader: " + e.getMessage());
            }
            
            // Approach 3: Creating URL class loader (will fail for demonstration)
            try {
                URL[] urls = {new File("/nonexistent/path/").toURI().toURL()};
                URLClassLoader urlLoader = new URLClassLoader(urls);
                Class<?> clazz3 = urlLoader.loadClass("com.example.CustomClass");
                System.out.println("✓ Loaded via URL loader: " + clazz3.getName());
                urlLoader.close();
            } catch (ClassNotFoundException e) {
                System.out.println("✗ Failed via URL loader: " + e.getMessage());
                System.out.println("  This is expected - demonstrating custom loader failure");
            } catch (Exception e) {
                System.out.println("✗ URL loader error: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("✗ Error in custom class loader demo: " + e.getMessage());
        }
    }
    
    // 5. Different handling strategies
    public void demonstrateHandlingStrategies() {
        System.out.println("5. EXCEPTION HANDLING STRATEGIES:");
        System.out.println("---------------------------------");
        
        // Strategy 1: Try-catch with fallback
        System.out.println("Strategy 1: Try-catch with fallback class");
        loadClassWithFallback("com.example.PreferredClass", "java.lang.String");
        
        System.out.println("\nStrategy 2: Multiple class attempts");
        loadMultipleClassAttempts(new String[]{
            "com.example.FirstChoice",
            "com.example.SecondChoice", 
            "java.lang.Object"  // This will succeed
        });
        
        System.out.println("\nStrategy 3: Graceful degradation");
        loadClassWithGracefulDegradation("com.advanced.FeatureClass");
        
        System.out.println("\nStrategy 4: Logging and re-throwing");
        try {
            loadClassWithLogging("com.example.ImportantClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Final handling: Application will continue with reduced functionality");
        }
    }
    
    // Helper method: Load class with fallback
    private void loadClassWithFallback(String preferredClass, String fallbackClass) {
        try {
            Class<?> clazz = Class.forName(preferredClass);
            System.out.println("✓ Loaded preferred class: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Preferred class not found: " + e.getMessage());
            try {
                Class<?> fallback = Class.forName(fallbackClass);
                System.out.println("✓ Using fallback class: " + fallback.getName());
            } catch (ClassNotFoundException e2) {
                System.out.println("✗ Fallback also failed: " + e2.getMessage());
            }
        }
    }
    
    // Helper method: Try multiple classes
    private void loadMultipleClassAttempts(String[] classNames) {
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                System.out.println("✓ Successfully loaded: " + clazz.getName());
                return; // Exit on first success
            } catch (ClassNotFoundException e) {
                System.out.println("✗ Failed to load: " + className);
            }
        }
        System.out.println("✗ All class loading attempts failed");
    }
    
    // Helper method: Graceful degradation
    private void loadClassWithGracefulDegradation(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("✓ Advanced features available: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("ℹ Advanced class not available, using basic functionality");
            System.out.println("  Application continues with core features only");
        }
    }
    
    // Helper method: Logging and re-throwing
    private void loadClassWithLogging(String className) throws ClassNotFoundException {
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("✓ Critical class loaded: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            // Log the error
            System.out.println("🚨 CRITICAL ERROR: Failed to load essential class");
            System.out.println("   Class: " + className);
            System.out.println("   Error: " + e.getMessage());
            System.out.println("   Timestamp: " + new java.util.Date());
            
            // Re-throw for higher level handling
            throw e;
        }
    }
    
    // Method to print comprehensive theory
    public void printClassNotFoundTheory() {
        System.out.println("==========================================================");
        System.out.println("              ClassNotFoundException THEORY");
        System.out.println("==========================================================");
        
        System.out.println("\nWHAT IS ClassNotFoundException?");
        System.out.println("-------------------------------");
        System.out.println("• A checked exception in Java");
        System.out.println("• Thrown when JVM cannot find a class definition");
        System.out.println("• Occurs during dynamic class loading");
        System.out.println("• Must be handled at compile time");
        
        System.out.println("\nCOMMON SCENARIOS:");
        System.out.println("-----------------");
        System.out.println("1. Class.forName(\"ClassName\") - Dynamic loading");
        System.out.println("2. ClassLoader.loadClass() - Custom loading");
        System.out.println("3. Reflection operations");
        System.out.println("4. Deserialization of objects");
        
        System.out.println("\nROOT CAUSES:");
        System.out.println("------------");
        System.out.println("• Class not in classpath");
        System.out.println("• Incorrect class name (typos)");
        System.out.println("• Wrong package name");
        System.out.println("• Missing JAR files");
        System.out.println("• Case sensitivity issues");
        System.out.println("• Class file corruption");
        
        System.out.println("\nHANDLING STRATEGIES:");
        System.out.println("-------------------");
        System.out.println("1. TRY-CATCH BLOCKS:");
        System.out.println("   • Handle specific exceptions");
        System.out.println("   • Provide fallback mechanisms");
        System.out.println("   • Log errors for debugging");
        
        System.out.println("\n2. PREVENTION TECHNIQUES:");
        System.out.println("   • Verify classpath configuration");
        System.out.println("   • Use correct class names");
        System.out.println("   • Include necessary JAR files");
        System.out.println("   • Test class loading early");
        
        System.out.println("\n3. DEBUGGING APPROACHES:");
        System.out.println("   • Print classpath information");
        System.out.println("   • Use verbose class loading (-verbose:class)");
        System.out.println("   • Check case sensitivity");
        System.out.println("   • Verify package structure");
        
        System.out.println("\nBEST PRACTICES:");
        System.out.println("---------------");
        System.out.println("• Always handle ClassNotFoundException");
        System.out.println("• Provide meaningful error messages");
        System.out.println("• Implement fallback mechanisms");
        System.out.println("• Use proper logging for production");
        System.out.println("• Test with different environments");
        System.out.println("• Document class dependencies");
        
        System.out.println("\nEXAMPLE HANDLING PATTERN:");
        System.out.println("-------------------------");
        System.out.println("try {");
        System.out.println("    Class<?> clazz = Class.forName(\"ClassName\");");
        System.out.println("    // Use the class");
        System.out.println("} catch (ClassNotFoundException e) {");
        System.out.println("    logger.error(\"Class not found: \" + e.getMessage());");
        System.out.println("    // Fallback or graceful degradation");
        System.out.println("}");
        
        System.out.println("\n==========================================================");
    }
}