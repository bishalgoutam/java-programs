package fundamentals.controlstructures;

/**
 * Control Structures - Comprehensive Examples
 * 
 * This program demonstrates all Java control structures:
 * - Conditional statements (if, if-else, switch)
 * - Loops (for, while, do-while, enhanced for)
 * - Jump statements (break, continue, return)
 * - Modern switch expressions (Java 14+)
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
import java.util.Random;

public class ControlStructuresDemo {
    
    public static void main(String[] args) {
        var demo = new ControlStructuresDemo();
        
        System.out.println("=== Java Control Structures Demo ===\n");
        
        demo.conditionalStatements();
        demo.loopStructures();
        demo.jumpStatements();
        demo.modernSwitchExpressions();
        demo.nestedControlStructures();
        demo.practicalExamples();
    }
    
    /**
     * Demonstrates conditional statements
     */
    public void conditionalStatements() {
        System.out.println("1. Conditional Statements");
        System.out.println("-".repeat(30));
        
        // Simple if statement
        int age = 25;
        if (age >= 18) {
            System.out.println("You are an adult (age: " + age + ")");
        }
        
        // if-else statement
        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        
        // Ternary operator
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Status using ternary: " + status);
        
        // Traditional switch statement
        int dayOfWeek = 3;
        String dayName;
        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        System.out.println("Day " + dayOfWeek + " is: " + dayName);
        System.out.println();
    }
    
    /**
     * Demonstrates various loop structures
     */
    public void loopStructures() {
        System.out.println("2. Loop Structures");
        System.out.println("-".repeat(20));
        
        // For loop
        System.out.println("For loop - counting 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // While loop
        System.out.println("While loop - countdown from 5:");
        int count = 5;
        while (count > 0) {
            System.out.print(count + " ");
            count--;
        }
        System.out.println();
        
        // Do-while loop
        System.out.println("Do-while loop - at least one execution:");
        int number = 10;
        do {
            System.out.print(number + " ");
            number += 5;
        } while (number < 10); // Condition is false, but executes once
        System.out.println();
        
        // Enhanced for loop (for-each)
        String[] languages = {"Java", "Python", "JavaScript", "C++", "Go"};
        System.out.println("Enhanced for loop - programming languages:");
        for (String language : languages) {
            System.out.print(language + " ");
        }
        System.out.println();
        
        // Nested loops - multiplication table
        System.out.println("Nested loops - 5x5 multiplication table:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Demonstrates jump statements
     */
    public void jumpStatements() {
        System.out.println("3. Jump Statements");
        System.out.println("-".repeat(22));
        
        // Break statement
        System.out.println("Break statement - find first even number:");
        int[] numbers = {1, 3, 7, 8, 9, 12, 15};
        for (int num : numbers) {
            System.out.print(num + " ");
            if (num % 2 == 0) {
                System.out.println("(Found even number: " + num + ")");
                break;
            }
        }
        
        // Continue statement
        System.out.println("Continue statement - skip even numbers:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Labeled break and continue
        System.out.println("Labeled break - exit nested loops:");
        outer: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking out of nested loops at (" + i + "," + j + ")");
                    break outer;
                }
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        System.out.println();
        
        // Return statement in method
        int result = findFirstFactorOf(20);
        System.out.println("First factor of 20 (other than 1): " + result);
        System.out.println();
    }
    
    /**
     * Demonstrates modern switch expressions (Java 14+)
     */
    public void modernSwitchExpressions() {
        System.out.println("4. Modern Switch Expressions (Java 14+)");
        System.out.println("-".repeat(42));
        
        // Switch expression with arrow syntax
        int dayNumber = 5;
        String dayType = switch (dayNumber) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println("Day " + dayNumber + " is a: " + dayType);
        
        // Switch expression with yield
        String season = "SPRING";
        String description = switch (season) {
            case "SPRING" -> {
                System.out.println("Processing spring...");
                yield "Flowers bloom, weather warms up";
            }
            case "SUMMER" -> {
                System.out.println("Processing summer...");
                yield "Hot weather, vacation time";
            }
            case "FALL", "AUTUMN" -> "Leaves change color, cooler weather";
            case "WINTER" -> "Cold weather, possible snow";
            default -> "Unknown season";
        };
        System.out.println(season + ": " + description);
        
        // Switch with different data types
        demonstrateModernSwitchTypes();
        System.out.println();
    }
    
    /**
     * Demonstrates nested control structures
     */
    public void nestedControlStructures() {
        System.out.println("5. Nested Control Structures");
        System.out.println("-".repeat(32));
        
        // Nested if-else with loops
        System.out.println("Grade analysis for students:");
        int[][] studentGrades = {
            {85, 90, 78, 92, 88},  // Student 1
            {76, 82, 79, 85, 80},  // Student 2
            {95, 98, 94, 96, 97}   // Student 3
        };
        
        for (int student = 0; student < studentGrades.length; student++) {
            System.out.println("Student " + (student + 1) + ":");
            
            int total = 0;
            int highestGrade = 0;
            int lowestGrade = 100;
            
            for (int grade : studentGrades[student]) {
                total += grade;
                if (grade > highestGrade) highestGrade = grade;
                if (grade < lowestGrade) lowestGrade = grade;
                
                // Nested conditional
                String letterGrade = switch (grade / 10) {
                    case 10, 9 -> "A";
                    case 8 -> "B";
                    case 7 -> "C";
                    case 6 -> "D";
                    default -> "F";
                };
                System.out.print("  " + grade + "(" + letterGrade + ") ");
            }
            
            double average = (double) total / studentGrades[student].length;
            System.out.println();
            System.out.printf("  Average: %.2f, Highest: %d, Lowest: %d%n", 
                            average, highestGrade, lowestGrade);
            
            if (average >= 90) {
                System.out.println("  Performance: Excellent!");
            } else if (average >= 80) {
                System.out.println("  Performance: Good");
            } else if (average >= 70) {
                System.out.println("  Performance: Satisfactory");
            } else {
                System.out.println("  Performance: Needs Improvement");
            }
            System.out.println();
        }
    }
    
    /**
     * Practical examples using control structures
     */
    public void practicalExamples() {
        System.out.println("6. Practical Examples");
        System.out.println("-".repeat(25));
        
        // Number guessing game simulation
        numberGuessingGame();
        
        // Prime number checker
        System.out.println("Prime numbers between 1 and 20:");
        for (int i = 2; i <= 20; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Fibonacci sequence
        System.out.println("First 10 Fibonacci numbers:");
        printFibonacci(10);
        
        // Pattern printing
        System.out.println("Number pyramid pattern:");
        printNumberPyramid(5);
        System.out.println();
    }
    
    // Helper methods
    private void demonstrateModernSwitchTypes() {
        // Switch with strings
        String language = "Java";
        String paradigm = switch (language.toLowerCase()) {
            case "java", "c++", "c#" -> "Object-Oriented";
            case "haskell", "lisp" -> "Functional";
            case "c", "pascal" -> "Procedural";
            case "javascript", "python" -> "Multi-paradigm";
            default -> "Unknown paradigm";
        };
        System.out.println(language + " is primarily: " + paradigm);
        
        // Switch with enums
        Day today = Day.FRIDAY;
        boolean isWeekend = switch (today) {
            case SATURDAY, SUNDAY -> true;
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> false;
        };
        System.out.println("Is " + today + " a weekend? " + isWeekend);
    }
    
    private int findFirstFactorOf(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return i; // Return statement exits the method
            }
        }
        return number; // If no factors found, number is prime
    }
    
    private void numberGuessingGame() {
        Random random = new Random();
        int targetNumber = random.nextInt(10) + 1; // 1-10
        int maxAttempts = 3;
        
        System.out.println("Number Guessing Game Simulation (1-10):");
        System.out.println("Target number: " + targetNumber + " (showing for demo)");
        
        // Simulate guesses
        int[] guesses = {5, 8, targetNumber}; // Predetermined guesses for demo
        
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            int guess = guesses[Math.min(attempt - 1, guesses.length - 1)];
            System.out.println("Attempt " + attempt + ": Guessing " + guess);
            
            if (guess == targetNumber) {
                System.out.println("Correct! You won in " + attempt + " attempts!");
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
            
            if (attempt == maxAttempts) {
                System.out.println("Game over! The number was " + targetNumber);
            }
        }
        System.out.println();
    }
    
    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void printFibonacci(int count) {
        int first = 0, second = 1;
        
        if (count >= 1) System.out.print(first + " ");
        if (count >= 2) System.out.print(second + " ");
        
        for (int i = 3; i <= count; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }
    
    private void printNumberPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            // Print spaces
            for (int j = 1; j <= height - i; j++) {
                System.out.print("  ");
            }
            
            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            
            // Print numbers in reverse (except the middle one)
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            
            System.out.println();
        }
    }
    
    // Enum for switch example
    private enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}