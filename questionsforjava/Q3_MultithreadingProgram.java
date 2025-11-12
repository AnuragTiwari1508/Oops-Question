/*
 * Q.3: Multi-threading Program - Average Calculator
 * 
 * THEORY: MULTI-THREADING IN JAVA
 * 
 * Multi-threading is a Java feature that allows concurrent execution of multiple
 * parts of a program to maximize utilization of CPU. Each part is called a thread.
 * 
 * Key Concepts:
 * 1. Thread: A lightweight sub-process, smallest unit of processing
 * 2. Multitasking: Multiple tasks executing simultaneously
 * 3. Thread Class: Java provides Thread class to create and manage threads
 * 4. Runnable Interface: Alternative way to create threads
 * 
 * WAYS TO CREATE THREADS:
 * 1. Extend Thread class (used in this program)
 * 2. Implement Runnable interface
 * 
 * THREAD LIFECYCLE:
 * NEW -> RUNNABLE -> RUNNING -> BLOCKED/WAITING -> TERMINATED
 */

import java.util.Random;
import java.util.Scanner;

// Thread class that extends Thread to calculate average of five double numbers
class AverageCalculatorThread extends Thread {
    private double[] numbers;
    private String threadName;
    private double average;
    private boolean calculationComplete;
    
    // Constructor
    public AverageCalculatorThread(String name, double[] nums) {
        this.threadName = name;
        this.numbers = nums.clone(); // Create a copy to avoid shared data issues
        this.calculationComplete = false;
        System.out.println("Thread created: " + threadName);
    }
    
    // Override run method - this is where thread execution begins
    @Override
    public void run() {
        System.out.println("\n" + threadName + " started execution...");
        System.out.println(threadName + " ID: " + Thread.currentThread().getId());
        
        try {
            // Display the numbers
            System.out.print(threadName + " processing numbers: ");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(String.format("%.2f", numbers[i]));
                if (i < numbers.length - 1) System.out.print(", ");
            }
            System.out.println();
            
            // Calculate sum with some delay to simulate processing
            double sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
                System.out.println(threadName + " added " + String.format("%.2f", numbers[i]) + 
                                 " -> Current sum: " + String.format("%.2f", sum));
                
                // Add delay to make thread execution visible
                Thread.sleep(500); // 500 milliseconds delay
            }
            
            // Calculate average
            average = sum / numbers.length;
            calculationComplete = true;
            
            System.out.println(threadName + " -> Sum: " + String.format("%.2f", sum));
            System.out.println(threadName + " -> Average: " + String.format("%.2f", average));
            System.out.println(threadName + " completed execution!\n");
            
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.out.println(threadName + " encountered an error: " + e.getMessage());
        }
    }
    
    // Getter methods
    public double getAverage() {
        return average;
    }
    
    public boolean isCalculationComplete() {
        return calculationComplete;
    }
    
    public String getThreadName() {
        return threadName;
    }
}

// Utility class for thread operations
class ThreadManager {
    
    // Method to generate random double numbers
    public static double[] generateRandomNumbers(int count) {
        Random random = new Random();
        double[] numbers = new double[count];
        
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextDouble() * 100; // Random numbers between 0 and 100
        }
        
        return numbers;
    }
    
    // Method to get user input numbers
    public static double[] getUserInputNumbers(Scanner scanner) {
        double[] numbers = new double[5];
        System.out.println("\nEnter 5 double numbers:");
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }
        
        return numbers;
    }
    
    // Method to demonstrate multiple threads
    public static void runMultipleThreads() {
        System.out.println("=== MULTIPLE THREADS DEMONSTRATION ===");
        
        // Create different sets of numbers for different threads
        double[][] dataSets = {
            {10.5, 20.3, 30.7, 40.2, 50.1},
            {5.5, 15.8, 25.4, 35.9, 45.2},
            {12.1, 22.6, 32.3, 42.8, 52.4}
        };
        
        // Create multiple threads
        AverageCalculatorThread[] threads = new AverageCalculatorThread[3];
        threads[0] = new AverageCalculatorThread("Thread-Dataset-1", dataSets[0]);
        threads[1] = new AverageCalculatorThread("Thread-Dataset-2", dataSets[1]);
        threads[2] = new AverageCalculatorThread("Thread-Dataset-3", dataSets[2]);
        
        System.out.println("\nStarting all threads...");
        
        // Start all threads
        for (AverageCalculatorThread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        try {
            for (AverageCalculatorThread thread : threads) {
                thread.join(); // Wait for this thread to finish
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        // Display final results
        System.out.println("=== FINAL RESULTS ===");
        for (AverageCalculatorThread thread : threads) {
            if (thread.isCalculationComplete()) {
                System.out.println(thread.getThreadName() + " - Average: " + 
                                 String.format("%.2f", thread.getAverage()));
            }
        }
    }
}

// Main class
public class Q3_MultithreadingProgram {
    
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("        MULTI-THREADING PROGRAM - AVERAGE CALCULATOR");
        System.out.println("==========================================================\n");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Demonstrate basic thread concepts
            demonstrateBasicThread();
            
            System.out.println("\n" + "=".repeat(60) + "\n");
            
            // Interactive mode
            System.out.println("Choose an option:");
            System.out.println("1. Enter your own 5 numbers");
            System.out.println("2. Use random numbers");
            System.out.println("3. Demonstrate multiple threads");
            System.out.print("Enter choice (1-3): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // User input mode
                    double[] userNumbers = ThreadManager.getUserInputNumbers(scanner);
                    runSingleThread("User-Input-Thread", userNumbers);
                    break;
                    
                case 2:
                    // Random numbers mode
                    double[] randomNumbers = ThreadManager.generateRandomNumbers(5);
                    runSingleThread("Random-Numbers-Thread", randomNumbers);
                    break;
                    
                case 3:
                    // Multiple threads demonstration
                    ThreadManager.runMultipleThreads();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Using random numbers...");
                    double[] defaultNumbers = ThreadManager.generateRandomNumbers(5);
                    runSingleThread("Default-Thread", defaultNumbers);
            }
            
            // Print threading concepts
            printThreadingConcepts();
            
        } catch (Exception e) {
            System.out.println("Error in main program: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    // Method to demonstrate basic thread properties
    private static void demonstrateBasicThread() {
        System.out.println("=== BASIC THREAD DEMONSTRATION ===");
        System.out.println("Main Thread Information:");
        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Priority: " + Thread.currentThread().getPriority());
        System.out.println("State: " + Thread.currentThread().getState());
        System.out.println("Is Alive: " + Thread.currentThread().isAlive());
    }
    
    // Method to run a single thread
    private static void runSingleThread(String threadName, double[] numbers) {
        System.out.println("\n=== SINGLE THREAD EXECUTION ===");
        
        // Create and start thread
        AverageCalculatorThread thread = new AverageCalculatorThread(threadName, numbers);
        
        System.out.println("Thread State before start: " + thread.getState());
        
        long startTime = System.currentTimeMillis();
        thread.start();
        
        System.out.println("Thread State after start: " + thread.getState());
        
        try {
            // Wait for thread to complete
            thread.join();
            long endTime = System.currentTimeMillis();
            
            System.out.println("Thread State after completion: " + thread.getState());
            System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
            
            if (thread.isCalculationComplete()) {
                System.out.println("\n*** FINAL RESULT ***");
                System.out.println("Average calculated by " + threadName + ": " + 
                                 String.format("%.2f", thread.getAverage()));
            }
            
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted: " + e.getMessage());
        }
    }
    
    // Method to print threading concepts and theory
    private static void printThreadingConcepts() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    THREADING CONCEPTS");
        System.out.println("=".repeat(60));
        
        System.out.println("\n1. THREAD CREATION BY EXTENDING Thread CLASS:");
        System.out.println("   • Inherit from Thread class");
        System.out.println("   • Override run() method");
        System.out.println("   • Call start() to begin execution");
        System.out.println("   • Cannot extend multiple classes (Java limitation)");
        
        System.out.println("\n2. THREAD LIFECYCLE:");
        System.out.println("   • NEW: Thread created but not started");
        System.out.println("   • RUNNABLE: Thread is executing or ready to execute");
        System.out.println("   • BLOCKED: Thread blocked waiting for monitor lock");
        System.out.println("   • WAITING: Thread waiting indefinitely for another thread");
        System.out.println("   • TIMED_WAITING: Thread waiting for specified period");
        System.out.println("   • TERMINATED: Thread has finished execution");
        
        System.out.println("\n3. IMPORTANT THREAD METHODS:");
        System.out.println("   • start(): Begin thread execution");
        System.out.println("   • run(): Contains the code to be executed by thread");
        System.out.println("   • join(): Wait for thread to complete");
        System.out.println("   • sleep(): Pause thread execution for specified time");
        System.out.println("   • interrupt(): Interrupt thread execution");
        
        System.out.println("\n4. ADVANTAGES OF MULTITHREADING:");
        System.out.println("   • Better CPU utilization");
        System.out.println("   • Concurrent execution of tasks");
        System.out.println("   • Improved application responsiveness");
        System.out.println("   • Resource sharing between threads");
        
        System.out.println("\n5. SYNCHRONIZATION CONSIDERATIONS:");
        System.out.println("   • Threads share memory space");
        System.out.println("   • Need synchronization for shared resources");
        System.out.println("   • Avoid race conditions");
        System.out.println("   • Use synchronized keyword when needed");
        
        System.out.println("\n6. THREAD vs RUNNABLE:");
        System.out.println("   • Extending Thread: Direct inheritance, simpler");
        System.out.println("   • Implementing Runnable: More flexible, allows multiple inheritance");
        System.out.println("   • Runnable preferred for better design");
        
        System.out.println("\n=".repeat(60));
    }
}