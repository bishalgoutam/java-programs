/**
 * Exception Handling Demo
 * 
 * Comprehensive demonstration of exception handling in Java including:
 * - Try-catch blocks
 * - Multiple catch blocks
 * - Finally blocks
 * - Custom exceptions
 * - Exception propagation
 * - Best practices
 */

import java.io.*;
import java.util.*;

// Custom Exception Classes
class InsufficientFundsException extends Exception {
    private double currentBalance;
    private double requestedAmount;
    
    public InsufficientFundsException(double currentBalance, double requestedAmount) {
        super(String.format("Insufficient funds. Balance: %.2f, Requested: %.2f", 
              currentBalance, requestedAmount));
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }
    
    public double getCurrentBalance() { return currentBalance; }
    public double getRequestedAmount() { return requestedAmount; }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String email) {
        super("Invalid email format: " + email);
    }
}

class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Bank Account class for demonstration
class BankAccount {
    private String accountNumber;
    private double balance;
    private String holderName;
    
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
        System.out.printf("Withdrawn: $%.2f, New Balance: $%.2f%n", amount, balance);
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.printf("Deposited: $%.2f, New Balance: $%.2f%n", amount, balance);
    }
    
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
}

// User Registration class
class UserRegistration {
    public static void registerUser(String name, String email, int age) 
            throws InvalidEmailException, IllegalArgumentException {
        
        // Validate name
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        
        // Validate email
        if (!isValidEmail(email)) {
            throw new InvalidEmailException(email);
        }
        
        // Validate age
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        
        System.out.println("User registered successfully: " + name);
    }
    
    private static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}

// File Operations with Exception Handling
class FileOperations {
    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        // try-with-resources automatically closes the reader
        
        return content.toString();
    }
    
    public static void writeFile(String filename, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(content);
        }
    }
    
    public static void copyFile(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}

// Database simulation class
class DatabaseManager {
    private boolean isConnected = false;
    
    public void connect() throws DatabaseConnectionException {
        // Simulate connection failure
        if (Math.random() < 0.3) { // 30% chance of failure
            throw new DatabaseConnectionException("Failed to connect to database", 
                new RuntimeException("Network timeout"));
        }
        isConnected = true;
        System.out.println("Database connected successfully");
    }
    
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected");
    }
    
    public boolean isConnected() { return isConnected; }
}

// Calculator with exception handling
class SafeCalculator {
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
    
    public static double sqrt(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
    
    public static long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorial too large to calculate (overflow risk)");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

public class ExceptionHandlingDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Exception Handling Demonstrations ===\n");
        
        demonstrateBasicTryCatch();
        demonstrateMultipleCatchBlocks();
        demonstrateFinallyBlock();
        demonstrateCustomExceptions();
        demonstrateTryWithResources();
        demonstrateExceptionPropagation();
        demonstrateChainedExceptions();
        demonstrateBestPractices();
    }
    
    /**
     * 1. Basic Try-Catch Demonstration
     */
    private static void demonstrateBasicTryCatch() {
        System.out.println("1. Basic Try-Catch Examples");
        System.out.println("-".repeat(40));
        
        // Array Index Out of Bounds
        try {
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Accessing valid index [2]: " + numbers[2]);
            System.out.println("Accessing invalid index [10]: " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // Number Format Exception
        try {
            String invalidNumber = "abc123";
            int number = Integer.parseInt(invalidNumber);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse '" + "abc123" + "' as integer: " + e.getMessage());
        }
        
        // Null Pointer Exception
        try {
            String nullString = null;
            @SuppressWarnings("null")
            int length = nullString.length();
            System.out.println("String length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 2. Multiple Catch Blocks
     */
    private static void demonstrateMultipleCatchBlocks() {
        System.out.println("2. Multiple Catch Blocks");
        System.out.println("-".repeat(40));
        
        String[] testInputs = {"10", "0", "abc", "5"};
        
        for (String input : testInputs) {
            try {
                System.out.printf("Processing input: '%s'%n", input);
                int number = Integer.parseInt(input);
                double result = SafeCalculator.divide(100, number);
                System.out.printf("100 / %d = %.2f%n", number, result);
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format - " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: Mathematical error - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Unexpected error - " + e.getMessage());
            }
            System.out.println();
        }
    }
    
    /**
     * 3. Finally Block Demonstration
     */
    private static void demonstrateFinallyBlock() {
        System.out.println("3. Finally Block Examples");
        System.out.println("-".repeat(40));
        
        DatabaseManager dbManager = new DatabaseManager();
        
        try {
            System.out.println("Attempting database connection...");
            dbManager.connect();
            
            // Simulate some database operations
            System.out.println("Performing database operations...");
            
            // Simulate potential error
            if (Math.random() < 0.5) {
                throw new RuntimeException("Simulated database error");
            }
            
            System.out.println("Database operations completed successfully");
            
        } catch (DatabaseConnectionException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime error during database operations: " + e.getMessage());
        } finally {
            // This block always executes
            if (dbManager.isConnected()) {
                dbManager.disconnect();
            }
            System.out.println("Cleanup completed in finally block");
        }
        
        System.out.println();
    }
    
    /**
     * 4. Custom Exceptions
     */
    private static void demonstrateCustomExceptions() {
        System.out.println("4. Custom Exception Examples");
        System.out.println("-".repeat(40));
        
        // Bank Account Example
        BankAccount account = new BankAccount("ACC-001", "John Doe", 1000.0);
        
        try {
            System.out.printf("Account: %s, Balance: $%.2f%n", 
                account.getAccountNumber(), account.getBalance());
            
            account.withdraw(500.0);  // Valid withdrawal
            account.withdraw(600.0);  // This will throw InsufficientFundsException
            
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            System.out.printf("Current balance: $%.2f%n", e.getCurrentBalance());
            System.out.printf("Requested amount: $%.2f%n", e.getRequestedAmount());
        }
        
        // User Registration Example
        String[] testUsers = {
            "John Doe|john@example.com|25",
            "Jane Smith|invalid-email|30",
            "|jane@example.com|25",
            "Bob Wilson|bob@example.com|-5"
        };
        
        for (String userData : testUsers) {
            try {
                String[] parts = userData.split("\\|");
                String name = parts[0];
                String email = parts[1];
                int age = Integer.parseInt(parts[2]);
                
                System.out.printf("Registering user: %s, %s, %d%n", name, email, age);
                UserRegistration.registerUser(name, email, age);
                
            } catch (InvalidEmailException e) {
                System.out.println("Registration failed: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Registration failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
            System.out.println();
        }
    }
    
    /**
     * 5. Try-with-Resources
     */
    private static void demonstrateTryWithResources() {
        System.out.println("5. Try-with-Resources Examples");
        System.out.println("-".repeat(40));
        
        String testFilename = "test-file.txt";
        String testContent = "This is a test file.\nIt contains multiple lines.\nFor demonstration purposes.";
        
        try {
            // Write to file
            System.out.println("Writing to file: " + testFilename);
            FileOperations.writeFile(testFilename, testContent);
            
            // Read from file
            System.out.println("Reading from file: " + testFilename);
            String content = FileOperations.readFile(testFilename);
            System.out.println("File content:");
            System.out.println(content);
            
            // Copy file
            String copyFilename = "copy-of-" + testFilename;
            System.out.println("Copying file to: " + copyFilename);
            FileOperations.copyFile(testFilename, copyFilename);
            System.out.println("File copied successfully");
            
        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 6. Exception Propagation
     */
    private static void demonstrateExceptionPropagation() {
        System.out.println("6. Exception Propagation Examples");
        System.out.println("-".repeat(40));
        
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Exception caught in main method: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    private static void methodA() throws Exception {
        System.out.println("Entering methodA()");
        methodB();
        System.out.println("Exiting methodA()");
    }
    
    private static void methodB() throws Exception {
        System.out.println("Entering methodB()");
        methodC();
        System.out.println("Exiting methodB()");
    }
    
    private static void methodC() throws Exception {
        System.out.println("Entering methodC()");
        throw new Exception("Exception thrown in methodC()");
    }
    
    /**
     * 7. Chained Exceptions
     */
    private static void demonstrateChainedExceptions() {
        System.out.println("7. Chained Exception Examples");
        System.out.println("-".repeat(40));
        
        try {
            performDatabaseOperation();
        } catch (DatabaseConnectionException e) {
            System.out.println("Top-level exception: " + e.getMessage());
            System.out.println("Root cause: " + e.getCause().getMessage());
            
            // Print full chain
            Throwable cause = e;
            int level = 0;
            while (cause != null) {
                System.out.println("Level " + level + ": " + cause.getClass().getSimpleName() + 
                                 " - " + cause.getMessage());
                cause = cause.getCause();
                level++;
            }
        }
        
        System.out.println();
    }
    
    private static void performDatabaseOperation() throws DatabaseConnectionException {
        try {
            // Simulate a low-level database error
            throw new RuntimeException("Network connection timeout");
        } catch (RuntimeException e) {
            // Wrap the low-level exception in a more meaningful high-level exception
            throw new DatabaseConnectionException("Database operation failed", e);
        }
    }
    
    /**
     * 8. Exception Handling Best Practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Exception Handling Best Practices");
        System.out.println("-".repeat(40));
        
        // Best Practice 1: Specific exception handling
        demonstrateSpecificExceptionHandling();
        
        // Best Practice 2: Resource management
        demonstrateResourceManagement();
        
        // Best Practice 3: Proper logging
        demonstrateProperLogging();
        
        // Best Practice 4: Fail-fast principle
        demonstrateFailFast();
    }
    
    private static void demonstrateSpecificExceptionHandling() {
        System.out.println("✓ Best Practice: Handle specific exceptions");
        
        try {
            long result = SafeCalculator.factorial(25); // Will throw exception
            System.out.println("Factorial result: " + result);
        } catch (IllegalArgumentException e) {
            // Handle specific exception with appropriate action
            System.out.println("Invalid input for factorial: " + e.getMessage());
            System.out.println("Using maximum safe value instead...");
            try {
                long safeResult = SafeCalculator.factorial(20);
                System.out.println("Safe factorial result: " + safeResult);
            } catch (IllegalArgumentException ignored) {
                System.out.println("Even safe value failed!");
            }
        }
        System.out.println();
    }
    
    private static void demonstrateResourceManagement() {
        System.out.println("✓ Best Practice: Proper resource management");
        
        // Good: Using try-with-resources
        try (Scanner scanner = new Scanner(System.in)) {
            // Resource automatically closed
            System.out.println("Scanner will be automatically closed");
        } catch (Exception e) {
            System.out.println("Error with scanner: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateProperLogging() {
        System.out.println("✓ Best Practice: Proper exception logging");
        
        try {
            double result = SafeCalculator.sqrt(-25);
            System.out.println("Square root result: " + result);
        } catch (IllegalArgumentException e) {
            // Log the exception with context
            System.err.println("ERROR: Mathematical operation failed");
            System.err.println("Operation: Square root of negative number");
            System.err.println("Input: -25");
            System.err.println("Exception: " + e.getMessage());
            System.err.println("Timestamp: " + new Date());
        }
        
        System.out.println();
    }
    
    private static void demonstrateFailFast() {
        System.out.println("✓ Best Practice: Fail-fast principle");
        
        try {
            processUserData(null, "user@example.com", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Input validation failed immediately: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void processUserData(String name, String email, int age) {
        // Fail-fast: Validate inputs immediately
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        
        // Continue with processing...
        System.out.println("Processing user data for: " + name);
    }
}