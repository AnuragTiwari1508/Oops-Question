// Question 1: Check Java Installation Details
// This program displays Java version, runtime version, home directory, and vendor name

public class Question1 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  JAVA INSTALLATION INFORMATION");
        System.out.println("========================================\n");
        
        // (i) Java version
        String javaVersion = System.getProperty("java.version");
        System.out.println("(i) Java Version: " + javaVersion);
        
        // (ii) Java runtime version
        String runtimeVersion = System.getProperty("java.runtime.version");
        System.out.println("(ii) Java Runtime Version: " + runtimeVersion);
        
        // (iii) Java home directory
        String javaHome = System.getProperty("java.home");
        System.out.println("(iii) Java Home Directory: " + javaHome);
        
        // (iv) Java vendor name
        String javaVendor = System.getProperty("java.vendor");
        System.out.println("(iv) Java Vendor Name: " + javaVendor);
        
        System.out.println("\n========================================");
        System.out.println("Additional Information:");
        System.out.println("========================================");
        System.out.println("Java VM Name: " + System.getProperty("java.vm.name"));
        System.out.println("Java VM Version: " + System.getProperty("java.vm.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("User Name: " + System.getProperty("user.name"));
        System.out.println("User Home Directory: " + System.getProperty("user.home"));
        System.out.println("========================================");
    }
}
