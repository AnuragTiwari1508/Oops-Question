// Question 22: Multiple Inheritance using Interfaces// Question 22: Custom Exception

// An interface extends other interfaces// Demonstrate user-defined exceptions



// Base Interface 1// Custom exception for invalid age

interface Vehicle {class InvalidAgeException extends Exception {

    void start();    public InvalidAgeException(String message) {

    void stop();        super(message);

        }

    default void showVehicleInfo() {}

        System.out.println("This is a vehicle");

    }// Custom exception for insufficient balance

}class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {

// Base Interface 2        super(message);

interface Engine {    }

    void startEngine();}

    void stopEngine();

    int getHorsePower();// Custom exception for invalid marks

}class InvalidMarksException extends Exception {

    public InvalidMarksException(String message) {

// Base Interface 3        super(message);

interface FuelSystem {    }

    void refuel(double liters);}

    double getFuelLevel();

    String getFuelType();class Voter {

}    String name;

    int age;

// Derived interface extending multiple interfaces    

interface Car extends Vehicle, Engine, FuelSystem {    void validateAge(int age) throws InvalidAgeException {

    void accelerate();        if (age < 18) {

    void brake();            throw new InvalidAgeException("Age must be 18 or above to vote. Current age: " + age);

    int getNumberOfDoors();        } else {

                this.age = age;

    default void showCarInfo() {            System.out.println("Age validated successfully. Eligible to vote.");

        System.out.println("This is a car with advanced features");        }

    }    }

}}



// Another derived interfaceclass BankAccount {

interface ElectricVehicle extends Vehicle {    double balance;

    void chargeBattery(double kwh);    

    double getBatteryLevel();    BankAccount(double balance) {

    int getRange();        this.balance = balance;

}    }

    

// Class implementing the derived interface    void withdraw(double amount) throws InsufficientBalanceException {

class Sedan implements Car {        if (amount > balance) {

    String model;            throw new InsufficientBalanceException(

    int horsePower;                "Insufficient balance. Available: Rs." + balance + ", Requested: Rs." + amount

    double fuelLevel;            );

    String fuelType;        } else {

    int doors;            balance -= amount;

    boolean engineRunning;            System.out.println("Withdrawal successful. Remaining balance: Rs." + balance);

            }

    Sedan(String model, int horsePower, int doors) {    }

        this.model = model;}

        this.horsePower = horsePower;

        this.doors = doors;class Student {

        this.fuelLevel = 50.0; // Start with half tank    String name;

        this.fuelType = "Petrol";    int marks;

        this.engineRunning = false;    

    }    void validateMarks(int marks) throws InvalidMarksException {

            if (marks < 0 || marks > 100) {

    @Override            throw new InvalidMarksException("Marks must be between 0 and 100. Entered: " + marks);

    public void start() {        } else {

        System.out.println("Starting " + model + "...");            this.marks = marks;

        startEngine();            System.out.println("Marks validated successfully.");

    }        }

        }

    @Override}

    public void stop() {

        System.out.println("Stopping " + model + "...");public class Question22 {

        stopEngine();    public static void main(String[] args) {

    }        System.out.println("Custom Exception Demonstration:");

            System.out.println("========================");

    @Override        

    public void startEngine() {        // Test InvalidAgeException

        engineRunning = true;        System.out.println("1. Testing Age Validation:");

        System.out.println("Engine started. Ready to drive!");        Voter voter = new Voter();

    }        try {

                voter.validateAge(15);

    @Override        } catch (InvalidAgeException e) {

    public void stopEngine() {            System.out.println("Exception caught: " + e.getMessage());

        engineRunning = false;        }

        System.out.println("Engine stopped.");        

    }        try {

                voter.validateAge(20);

    @Override        } catch (InvalidAgeException e) {

    public int getHorsePower() {            System.out.println("Exception caught: " + e.getMessage());

        return horsePower;        }

    }        

            // Test InsufficientBalanceException

    @Override        System.out.println("\n2. Testing Bank Account:");

    public void refuel(double liters) {        BankAccount account = new BankAccount(5000);

        fuelLevel += liters;        try {

        if (fuelLevel > 100) fuelLevel = 100;            account.withdraw(3000);

        System.out.printf("Refueled %.2f liters. Current fuel level: %.2f%%\n", liters, fuelLevel);        } catch (InsufficientBalanceException e) {

    }            System.out.println("Exception caught: " + e.getMessage());

            }

    @Override        

    public double getFuelLevel() {        try {

        return fuelLevel;            account.withdraw(3000);

    }        } catch (InsufficientBalanceException e) {

                System.out.println("Exception caught: " + e.getMessage());

    @Override        }

    public String getFuelType() {        

        return fuelType;        // Test InvalidMarksException

    }        System.out.println("\n3. Testing Marks Validation:");

            Student student = new Student();

    @Override        try {

    public void accelerate() {            student.validateMarks(150);

        if (engineRunning) {        } catch (InvalidMarksException e) {

            System.out.println("Accelerating... Speed increasing!");            System.out.println("Exception caught: " + e.getMessage());

            fuelLevel -= 0.5;        }

        } else {        

            System.out.println("Start the engine first!");        try {

        }            student.validateMarks(85);

    }        } catch (InvalidMarksException e) {

                System.out.println("Exception caught: " + e.getMessage());

    @Override        }

    public void brake() {    }

        System.out.println("Braking... Speed decreasing!");}

    }
    
    @Override
    public int getNumberOfDoors() {
        return doors;
    }
    
    void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("         CAR INFORMATION");
        System.out.println("========================================");
        System.out.println("Model: " + model);
        System.out.println("Horse Power: " + horsePower + " HP");
        System.out.println("Number of Doors: " + doors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.printf("Fuel Level: %.2f%%\n", fuelLevel);
        System.out.println("Engine Status: " + (engineRunning ? "Running" : "Off"));
        System.out.println("========================================");
    }
}

// Class implementing ElectricVehicle interface
class Tesla implements ElectricVehicle {
    String model;
    double batteryLevel;
    int range;
    
    Tesla(String model, int range) {
        this.model = model;
        this.range = range;
        this.batteryLevel = 100.0;
    }
    
    @Override
    public void start() {
        System.out.println("Tesla " + model + " starting silently...");
    }
    
    @Override
    public void stop() {
        System.out.println("Tesla " + model + " stopped.");
    }
    
    @Override
    public void chargeBattery(double kwh) {
        batteryLevel += (kwh / 100.0 * 10);
        if (batteryLevel > 100) batteryLevel = 100;
        System.out.printf("Charged %.2f kWh. Battery level: %.2f%%\n", kwh, batteryLevel);
    }
    
    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }
    
    @Override
    public int getRange() {
        return (int)(range * batteryLevel / 100);
    }
    
    void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("    ELECTRIC VEHICLE INFORMATION");
        System.out.println("========================================");
        System.out.println("Model: Tesla " + model);
        System.out.printf("Battery Level: %.2f%%\n", batteryLevel);
        System.out.println("Max Range: " + range + " km");
        System.out.println("Current Range: " + getRange() + " km");
        System.out.println("========================================");
    }
}

public class Question22 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  MULTIPLE INHERITANCE VIA INTERFACES");
        System.out.println("  (Interface extends Other Interfaces)");
        System.out.println("========================================");
        
        // Create Sedan object
        System.out.println("\n--- SEDAN CAR DEMO ---");
        Sedan myCar = new Sedan("Honda Civic", 180, 4);
        myCar.displayInfo();
        
        System.out.println("\nOperating the car:");
        myCar.start();
        myCar.accelerate();
        myCar.brake();
        myCar.refuel(20);
        myCar.stop();
        
        // Create Tesla object
        System.out.println("\n\n--- ELECTRIC VEHICLE DEMO ---");
        Tesla myTesla = new Tesla("Model 3", 500);
        myTesla.displayInfo();
        
        System.out.println("\nOperating Tesla:");
        myTesla.start();
        System.out.println("Current range: " + myTesla.getRange() + " km");
        myTesla.chargeBattery(50);
        myTesla.stop();
        
        // Demonstrate interface hierarchy
        System.out.println("\n========================================");
        System.out.println("     INTERFACE HIERARCHY");
        System.out.println("========================================");
        System.out.println("\nCar interface extends:");
        System.out.println("  - Vehicle (start, stop)");
        System.out.println("  - Engine (startEngine, stopEngine, getHorsePower)");
        System.out.println("  - FuelSystem (refuel, getFuelLevel, getFuelType)");
        System.out.println("\nElectricVehicle interface extends:");
        System.out.println("  - Vehicle (start, stop)");
        System.out.println("\nSedan class implements Car interface");
        System.out.println("Tesla class implements ElectricVehicle interface");
        System.out.println("========================================");
    }
}
