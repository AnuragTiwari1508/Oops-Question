// Question 4: Speed Calculator
// Takes distance (meters) and time (seconds, minutes, hours) as input
// Displays speed in metres/sec, km/hr, and miles/hr

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("       SPEED CALCULATOR");
        System.out.println("========================================\n");
        
        // Input distance in meters
        System.out.print("Enter distance in meters: ");
        double distanceInMeters = scanner.nextDouble();
        
        // Input time
        System.out.print("Enter time in seconds: ");
        double timeInSeconds = scanner.nextDouble();
        
        System.out.print("Enter time in minutes: ");
        double timeInMinutes = scanner.nextDouble();
        
        System.out.print("Enter time in hours: ");
        double timeInHours = scanner.nextDouble();
        
        // Convert all time to seconds
        double totalTimeInSeconds = timeInSeconds + (timeInMinutes * 60) + (timeInHours * 3600);
        
        // Calculate speeds
        double speedMPS = distanceInMeters / totalTimeInSeconds;  // meters per second
        double speedKMPH = (distanceInMeters / 1000) / (totalTimeInSeconds / 3600);  // km per hour
        double speedMPH = (distanceInMeters / 1609.34) / (totalTimeInSeconds / 3600);  // miles per hour
        
        System.out.println("\n========================================");
        System.out.println("RESULTS:");
        System.out.println("========================================");
        System.out.printf("Speed in metres/second: %.2f m/s\n", speedMPS);
        System.out.printf("Speed in km/hour: %.2f km/hr\n", speedKMPH);
        System.out.printf("Speed in miles/hour: %.2f mph\n", speedMPH);
        System.out.println("========================================");
        
        scanner.close();
    }
}
