package com.bishalgoutam.environment;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Java 21 LTS Environment Validator
 * 
 * This program validates the Java 21 runtime environment and demonstrates
 * modern Java features available in the latest LTS release.
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
public class Java21EnvironmentValidator {
    
    // Java 21 Feature: Text Blocks for better readability
    private static final String BANNER = """
            ╔═══════════════════════════════════════════════════════╗
            ║              Java 21 LTS Environment                 ║
            ║                   Validator                           ║
            ╚═══════════════════════════════════════════════════════╝
            """;
    
    public static void main(String[] args) {
        var validator = new Java21EnvironmentValidator();
        validator.runValidation();
    }
    
    /**
     * Runs comprehensive validation of the Java 21 environment
     */
    public void runValidation() {
        System.out.println(BANNER);
        
        // Basic environment validation
        validateJavaVersion();
        validateSystemProperties();
        
        // Java 21 feature demonstrations
        demonstrateTextBlocks();
        demonstratePatternMatching();
        demonstrateRecords();
        demonstrateVarKeyword();
        demonstrateSwitchExpressions();
        demonstrateStreamAPI();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ Java 21 LTS Environment Validation Complete!");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Validates the Java version and runtime environment
     */
    private void validateJavaVersion() {
        System.out.println("\n🔍 Java Runtime Environment Validation:");
        System.out.println("-".repeat(45));
        
        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String javaHome = System.getProperty("java.home");
        
        System.out.printf("Java Version:    %s%n", javaVersion);
        System.out.printf("Java Vendor:     %s%n", javaVendor);
        System.out.printf("Java Home:       %s%n", javaHome);
        
        // Check if running on Java 21+
        var version = Runtime.version();
        if (version.feature() >= 21) {
            System.out.println("✅ Running on Java 21+ LTS - All features available!");
        } else {
            System.out.println("⚠️  Not running on Java 21 - Some features may not work");
        }
        
        System.out.printf("Runtime Version: %s%n", version);
    }
    
    /**
     * Displays relevant system properties
     */
    private void validateSystemProperties() {
        System.out.println("\n🖥️  System Environment:");
        System.out.println("-".repeat(25));
        
        Properties props = System.getProperties();
        var relevantProps = List.of(
            "os.name", "os.version", "os.arch",
            "user.name", "user.home", "user.dir",
            "file.separator", "path.separator"
        );
        
        relevantProps.forEach(prop -> 
            System.out.printf("%-15s: %s%n", prop, props.getProperty(prop))
        );
    }
    
    /**
     * Demonstrates Java 13+ Text Blocks feature
     */
    private void demonstrateTextBlocks() {
        System.out.println("\n📝 Text Blocks (Java 13+):");
        System.out.println("-".repeat(30));
        
        var jsonExample = """
                {
                    "name": "Java 21 LTS",
                    "version": "21.0.1",
                    "features": [
                        "Text Blocks",
                        "Pattern Matching",
                        "Records",
                        "Switch Expressions"
                    ],
                    "lts": true
                }
                """;
        
        System.out.println("JSON Example using Text Blocks:");
        System.out.println(jsonExample);
    }
    
    /**
     * Demonstrates Pattern Matching with instanceof (Java 16+)
     */
    private void demonstratePatternMatching() {
        System.out.println("\n🔍 Pattern Matching (Java 16+):");
        System.out.println("-".repeat(35));
        
        Object[] testObjects = {
            "Hello, Java 21!",
            42,
            3.14159,
            List.of("Java", "Pattern", "Matching")
        };
        
        for (Object obj : testObjects) {
            String result = analyzeObject(obj);
            System.out.println(result);
        }
    }
    
    /**
     * Analyzes an object using pattern matching
     */
    private String analyzeObject(Object obj) {
        return switch (obj) {
            case String s -> "String with length: " + s.length() + " - '" + s + "'";
            case Integer i -> "Integer value: " + i + " (even: " + (i % 2 == 0) + ")";
            case Double d -> "Double value: " + d + " (rounded: " + Math.round(d) + ")";
            case List<?> list -> "List with " + list.size() + " elements: " + list;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }
    
    /**
     * Demonstrates Records (Java 14+)
     */
    private void demonstrateRecords() {
        System.out.println("\n📋 Records (Java 14+):");
        System.out.println("-".repeat(25));
        
        var person = new Person("Bishal Goutam", 25, "Software Developer");
        var point = new Point(10, 20);
        
        System.out.println("Person Record: " + person);
        System.out.println("Point Record: " + point);
        System.out.println("Person Name: " + person.name());
        System.out.println("Point Distance from Origin: " + point.distanceFromOrigin());
    }
    
    /**
     * Demonstrates Local Variable Type Inference (Java 10+)
     */
    private void demonstrateVarKeyword() {
        System.out.println("\n🔧 Local Variable Type Inference (Java 10+):");
        System.out.println("-".repeat(50));
        
        var message = "Type inferred as String";
        var numbers = List.of(1, 2, 3, 4, 5);
        var sum = numbers.stream().mapToInt(Integer::intValue).sum();
        
        System.out.println("var message: " + message);
        System.out.println("var numbers: " + numbers);
        System.out.println("var sum: " + sum);
    }
    
    /**
     * Demonstrates Switch Expressions (Java 14+)
     */
    private void demonstrateSwitchExpressions() {
        System.out.println("\n🔀 Switch Expressions (Java 14+):");
        System.out.println("-".repeat(35));
        
        var days = List.of("MONDAY", "WEDNESDAY", "FRIDAY", "SATURDAY", "SUNDAY");
        
        days.forEach(day -> {
            var dayType = switch (day) {
                case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
                case "SATURDAY", "SUNDAY" -> "Weekend";
                default -> "Unknown";
            };
            System.out.println(day + " is a " + dayType);
        });
    }
    
    /**
     * Demonstrates Stream API enhancements
     */
    private void demonstrateStreamAPI() {
        System.out.println("\n🌊 Stream API Features:");
        System.out.println("-".repeat(25));
        
        var programmingLanguages = List.of(
            "Java", "Python", "JavaScript", "C++", "Go", "Rust", "Kotlin"
        );
        
        // Filter, map, and collect
        var javaRelated = programmingLanguages.stream()
            .filter(lang -> lang.contains("Java") || lang.equals("Kotlin"))
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        System.out.println("Java-related languages: " + javaRelated);
        
        // Count and statistics
        var totalLanguages = programmingLanguages.size();
        var avgLength = programmingLanguages.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
        
        System.out.println("Total languages: " + totalLanguages);
        System.out.println("Average name length: " + String.format("%.2f", avgLength));
    }
    
    /**
     * Person Record - demonstrates Java 14+ Records feature
     */
    public record Person(String name, int age, String profession) {
        
        // Compact constructor for validation
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or blank");
            }
        }
        
        // Additional methods can be added to records
        public boolean isAdult() {
            return age >= 18;
        }
        
        public String getDisplayName() {
            return name + " (" + profession + ")";
        }
    }
    
    /**
     * Point Record - demonstrates mathematical operations in records
     */
    public record Point(double x, double y) {
        
        public double distanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }
        
        public Point translate(double dx, double dy) {
            return new Point(x + dx, y + dy);
        }
    }
}