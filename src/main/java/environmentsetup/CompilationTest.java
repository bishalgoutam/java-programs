package environmentsetup;

/**
 * Compilation Test
 * 
 * Simple Java program to test basic compilation and execution capabilities.
 * This program validates that the Java development environment can:
 * - Compile Java source code
 * - Execute compiled bytecode
 * - Handle modern Java language features
 * - Access standard library classes
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CompilationTest {
    
    public static void main(String[] args) {
        System.out.println("=== Java Compilation Test ===");
        System.out.println("Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println();
        
        testBasicFeatures();
        testModernFeatures();
        testCollections();
        testStreamAPI();
        
        System.out.println();
        System.out.println("🎉 All compilation tests passed!");
        System.out.println("Your Java environment is ready for development.");
    }
    
    /**
     * Test basic Java features
     */
    private static void testBasicFeatures() {
        System.out.println("1. Basic Features Test");
        System.out.println("-".repeat(30));
        
        // Variables and data types
        int number = 42;
        double decimal = 3.14159;
        String text = "Hello, Java!";
        boolean flag = true;
        
        System.out.println("✓ Variables: int=" + number + ", double=" + decimal + 
                         ", String=" + text + ", boolean=" + flag);
        
        // Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("✓ Arrays: " + Arrays.toString(numbers));
        
        // Control structures
        String result = (number > 0) ? "positive" : "negative";
        System.out.println("✓ Conditional: " + number + " is " + result);
        
        // Methods
        int sum = addNumbers(10, 20);
        System.out.println("✓ Method call: 10 + 20 = " + sum);
        
        System.out.println();
    }
    
    /**
     * Test modern Java features
     */
    private static void testModernFeatures() {
        System.out.println("2. Modern Features Test");
        System.out.println("-".repeat(30));
        
        // Switch expressions (Java 14+)
        String day = "MONDAY";
        String dayType = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Unknown";
        };
        System.out.println("✓ Switch expressions: " + day + " is a " + dayType);
        
        // Text blocks (Java 15+)
        String json = """
                {
                    "name": "Java",
                    "version": "21",
                    "type": "Programming Language"
                }
                """;
        System.out.println("✓ Text blocks: JSON formatted");
        System.out.println("  " + json.trim());
        
        // Records (Java 14+)
        record Person(String name, int age) {}
        Person person = new Person("Alice", 30);
        System.out.println("✓ Records: " + person);
        
        // Pattern matching for instanceof (Java 16+)
        Object obj = "Pattern matching test";
        if (obj instanceof String str && str.length() > 10) {
            System.out.println("✓ Pattern matching: String length is " + str.length());
        }
        
        // Local variable type inference (Java 10+)
        var message = "Type inference works!";
        System.out.println("✓ Var keyword: " + message);
        
        System.out.println();
    }
    
    /**
     * Test Collections Framework
     */
    private static void testCollections() {
        System.out.println("3. Collections Test");
        System.out.println("-".repeat(30));
        
        // List
        List<String> fruits = new ArrayList<>();
        fruits.addAll(Arrays.asList("apple", "banana", "orange"));
        System.out.println("✓ ArrayList: " + fruits);
        
        // Set
        Set<String> uniqueFruits = new HashSet<>(fruits);
        uniqueFruits.add("apple"); // Duplicate, should not be added
        System.out.println("✓ HashSet: " + uniqueFruits);
        
        // Map
        Map<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("apple", 100);
        fruitPrices.put("banana", 80);
        fruitPrices.put("orange", 120);
        System.out.println("✓ HashMap: " + fruitPrices);
        
        System.out.println();
    }
    
    /**
     * Test Stream API (Java 8+)
     */
    private static void testStreamAPI() {
        System.out.println("4. Stream API Test");
        System.out.println("-".repeat(30));
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter and collect
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("✓ Filter (even numbers): " + evenNumbers);
        
        // Map and sum
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("✓ Map and sum: " + sum);
        
        // Find maximum
        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("✓ Find max: " + (max.isPresent() ? max.getAsInt() : "none"));
        
        // Group by even/odd
        Map<Boolean, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("✓ Group by even/odd: " + groupedNumbers);
        
        System.out.println();
    }
    
    /**
     * Helper method for testing
     */
    private static int addNumbers(int a, int b) {
        return a + b;
    }
}