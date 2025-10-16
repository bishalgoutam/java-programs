/**
 * Scientific Calculator Project
 * 
 * A comprehensive calculator application demonstrating:
 * - Object-oriented design principles
 * - Exception handling for invalid operations
 * - Method overloading for different operation types
 * - Static utility methods for mathematical functions
 * - User interface with menu-driven console application
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
import java.util.*;

/**
 * Main Calculator Application
 */
public class CalculatorApp {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Calculator calculator = new Calculator();
    private static CalculatorHistory history = new CalculatorHistory();
    
    public static void main(String[] args) {
        System.out.println("=== Scientific Calculator Application ===\n");
        
        showWelcomeMessage();
        runCalculatorMenu();
        
        System.out.println("Thank you for using the Scientific Calculator!");
        scanner.close();
    }
    
    private static void showWelcomeMessage() {
        System.out.println("Welcome to the Scientific Calculator!");
        System.out.println("This calculator supports:");
        System.out.println("• Basic arithmetic operations (+, -, *, /, %)");
        System.out.println("• Scientific functions (sin, cos, tan, log, sqrt, power)");
        System.out.println("• Memory operations (store, recall, clear)");
        System.out.println("• Calculation history");
        System.out.println("• Error handling for invalid operations");
        System.out.println();
    }
    
    private static void runCalculatorMenu() {
        boolean running = true;
        
        while (running) {
            showMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            try {
                switch (choice) {
                    case 1 -> performBasicCalculation();
                    case 2 -> performScientificCalculation();
                    case 3 -> manageMemory();
                    case 4 -> showHistory();
                    case 5 -> clearHistory();
                    case 6 -> showCalculatorInfo();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }
    }
    
    private static void showMainMenu() {
        System.out.println("=== CALCULATOR MENU ===");
        System.out.println("1. Basic Calculations");
        System.out.println("2. Scientific Functions");
        System.out.println("3. Memory Operations");
        System.out.println("4. Show History");
        System.out.println("5. Clear History");
        System.out.println("6. Calculator Info");
        System.out.println("0. Exit");
        System.out.println("-".repeat(25));
    }
    
    private static void performBasicCalculation() {
        System.out.println("\n=== Basic Calculations ===");
        System.out.println("Available operations: +, -, *, /, %");
        
        double num1 = getDoubleInput("Enter first number: ");
        String operator = getStringInput("Enter operator (+, -, *, /, %): ");
        double num2 = getDoubleInput("Enter second number: ");
        
        try {
            double result = switch (operator) {
                case "+" -> calculator.add(num1, num2);
                case "-" -> calculator.subtract(num1, num2);
                case "*" -> calculator.multiply(num1, num2);
                case "/" -> calculator.divide(num1, num2);
                case "%" -> calculator.modulo(num1, num2);
                default -> throw new IllegalArgumentException("Invalid operator: " + operator);
            };
            
            String calculation = num1 + " " + operator + " " + num2 + " = " + result;
            System.out.println("Result: " + result);
            history.addCalculation(calculation);
            
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void performScientificCalculation() {
        System.out.println("\n=== Scientific Functions ===");
        System.out.println("1. Square Root (sqrt)");
        System.out.println("2. Power (x^y)");
        System.out.println("3. Sine (sin)");
        System.out.println("4. Cosine (cos)");
        System.out.println("5. Tangent (tan)");
        System.out.println("6. Natural Logarithm (ln)");
        System.out.println("7. Logarithm Base 10 (log)");
        System.out.println("8. Factorial (n!)");
        
        int choice = getIntInput("Choose function: ");
        
        try {
            String calculation;
            double result;
            
            switch (choice) {
                case 1 -> {
                    double num = getDoubleInput("Enter number: ");
                    result = calculator.sqrt(num);
                    calculation = "sqrt(" + num + ") = " + result;
                }
                case 2 -> {
                    double base = getDoubleInput("Enter base: ");
                    double exponent = getDoubleInput("Enter exponent: ");
                    result = calculator.power(base, exponent);
                    calculation = base + "^" + exponent + " = " + result;
                }
                case 3 -> {
                    double angle = getDoubleInput("Enter angle in degrees: ");
                    result = calculator.sin(angle);
                    calculation = "sin(" + angle + "°) = " + result;
                }
                case 4 -> {
                    double angle = getDoubleInput("Enter angle in degrees: ");
                    result = calculator.cos(angle);
                    calculation = "cos(" + angle + "°) = " + result;
                }
                case 5 -> {
                    double angle = getDoubleInput("Enter angle in degrees: ");
                    result = calculator.tan(angle);
                    calculation = "tan(" + angle + "°) = " + result;
                }
                case 6 -> {
                    double num = getDoubleInput("Enter number: ");
                    result = calculator.naturalLog(num);
                    calculation = "ln(" + num + ") = " + result;
                }
                case 7 -> {
                    double num = getDoubleInput("Enter number: ");
                    result = calculator.log10(num);
                    calculation = "log(" + num + ") = " + result;
                }
                case 8 -> {
                    int num = getIntInput("Enter integer: ");
                    result = calculator.factorial(num);
                    calculation = num + "! = " + result;
                }
                default -> {
                    System.out.println("Invalid choice!");
                    return;
                }
            }
            
            System.out.println("Result: " + result);
            history.addCalculation(calculation);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void manageMemory() {
        System.out.println("\n=== Memory Operations ===");
        System.out.println("Current memory value: " + calculator.getMemoryValue());
        System.out.println("1. Store in memory (MS)");
        System.out.println("2. Add to memory (M+)");
        System.out.println("3. Subtract from memory (M-)");
        System.out.println("4. Recall memory (MR)");
        System.out.println("5. Clear memory (MC)");
        
        int choice = getIntInput("Choose operation: ");
        
        switch (choice) {
            case 1 -> {
                double value = getDoubleInput("Enter value to store: ");
                calculator.memoryStore(value);
                System.out.println("Value " + value + " stored in memory.");
            }
            case 2 -> {
                double value = getDoubleInput("Enter value to add: ");
                calculator.memoryAdd(value);
                System.out.println("Added " + value + " to memory.");
            }
            case 3 -> {
                double value = getDoubleInput("Enter value to subtract: ");
                calculator.memorySubtract(value);
                System.out.println("Subtracted " + value + " from memory.");
            }
            case 4 -> {
                double value = calculator.memoryRecall();
                System.out.println("Memory value: " + value);
            }
            case 5 -> {
                calculator.memoryClear();
                System.out.println("Memory cleared.");
            }
            default -> System.out.println("Invalid choice!");
        }
        
        System.out.println("Current memory value: " + calculator.getMemoryValue());
        System.out.println();
    }
    
    private static void showHistory() {
        System.out.println("\n=== Calculation History ===");
        history.displayHistory();
        System.out.println();
    }
    
    private static void clearHistory() {
        history.clearHistory();
        System.out.println("History cleared!\n");
    }
    
    private static void showCalculatorInfo() {
        System.out.println("\n=== Calculator Information ===");
        System.out.println("Calculator Model: Scientific Calculator v2.1");
        System.out.println("Precision: Double precision floating point");
        System.out.println("Memory Storage: Single value");
        System.out.println("History Capacity: " + history.getMaxHistorySize() + " calculations");
        System.out.println("Current History Size: " + history.getHistorySize());
        System.out.println("Developer: Bishal Goutam");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println();
    }
    
    // Utility methods for input
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a number: ");
            scanner.next(); // Clear invalid input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline
        return value;
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter an integer: ");
            scanner.next(); // Clear invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Clear the newline
        return value;
    }
    
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}

/**
 * Core Calculator Class with Mathematical Operations
 */
class Calculator {
    private double memory;
    
    public Calculator() {
        this.memory = 0.0;
    }
    
    // Basic arithmetic operations
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
    
    public double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed");
        }
        return a % b;
    }
    
    // Scientific functions
    public double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
    
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    public double sin(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }
    
    public double cos(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }
    
    public double tan(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }
    
    public double naturalLog(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm undefined for non-positive numbers");
        }
        return Math.log(number);
    }
    
    public double log10(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm undefined for non-positive numbers");
        }
        return Math.log10(number);
    }
    
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial undefined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorial too large (max 20)");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // Memory operations
    public void memoryStore(double value) {
        memory = value;
    }
    
    public void memoryAdd(double value) {
        memory += value;
    }
    
    public void memorySubtract(double value) {
        memory -= value;
    }
    
    public double memoryRecall() {
        return memory;
    }
    
    public void memoryClear() {
        memory = 0.0;
    }
    
    public double getMemoryValue() {
        return memory;
    }
}

/**
 * Calculator History Management
 */
class CalculatorHistory {
    private List<String> history;
    private final int maxHistorySize;
    
    public CalculatorHistory() {
        this.history = new ArrayList<>();
        this.maxHistorySize = 50; // Maximum 50 calculations in history
    }
    
    public void addCalculation(String calculation) {
        if (history.size() >= maxHistorySize) {
            history.remove(0); // Remove oldest calculation
        }
        
        String timestamp = new Date().toString();
        String entry = "[" + timestamp + "] " + calculation;
        history.add(entry);
    }
    
    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No calculations in history.");
            return;
        }
        
        System.out.println("Recent calculations (newest first):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }
    
    public void clearHistory() {
        history.clear();
    }
    
    public int getHistorySize() {
        return history.size();
    }
    
    public int getMaxHistorySize() {
        return maxHistorySize;
    }
    
    public List<String> getHistory() {
        return new ArrayList<>(history); // Return copy to prevent external modification
    }
}

/**
 * Mathematical Constants and Utility Functions
 */
class MathConstants {
    public static final double PI = Math.PI;
    public static final double E = Math.E;
    public static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
    public static final double SPEED_OF_LIGHT = 299792458; // m/s
    
    // Utility methods
    public static double degreesToRadians(double degrees) {
        return Math.toRadians(degrees);
    }
    
    public static double radiansToDegrees(double radians) {
        return Math.toDegrees(radians);
    }
    
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
    
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}