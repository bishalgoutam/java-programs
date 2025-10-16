package com.bishalgoutam.features;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Java 21 Pattern Matching Examples
 * 
 * Demonstrates the power of pattern matching for instanceof and switch expressions
 * available in Java 21 LTS.
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
public class PatternMatchingExamples {
    
    public static void main(String[] args) {
        var examples = new PatternMatchingExamples();
        examples.demonstrateInstanceofPatternMatching();
        examples.demonstrateSwitchPatternMatching();
        examples.demonstrateGuardConditions();
        examples.demonstrateDeconstructionPatterns();
    }
    
    /**
     * Demonstrates instanceof pattern matching (Java 16+)
     */
    public void demonstrateInstanceofPatternMatching() {
        System.out.println("=== instanceof Pattern Matching ===\n");
        
        Object[] testData = {
            "Hello World",
            42,
            3.14159,
            List.of("Java", "21", "LTS"),
            null
        };
        
        for (Object obj : testData) {
            processObject(obj);
        }
    }
    
    private void processObject(Object obj) {
        // Traditional approach (verbose)
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("Traditional: String with length " + s.length());
        }
        
        // Modern pattern matching approach (concise)
        if (obj instanceof String s) {
            System.out.println("Modern: String '" + s + "' has " + s.length() + " characters");
        } else if (obj instanceof Integer i && i > 0) {
            System.out.println("Positive integer: " + i + " (squared: " + (i * i) + ")");
        } else if (obj instanceof Double d) {
            System.out.println("Double value: " + d + " (rounded: " + Math.round(d) + ")");
        } else if (obj instanceof List<?> list && !list.isEmpty()) {
            System.out.println("Non-empty list with " + list.size() + " elements: " + list);
        } else if (obj == null) {
            System.out.println("Null value encountered");
        } else {
            System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates switch pattern matching (Java 21)
     */
    public void demonstrateSwitchPatternMatching() {
        System.out.println("=== Switch Pattern Matching ===\n");
        
        Object[] testData = {
            "Java 21",
            100,
            2.718,
            List.of("Pattern", "Matching"),
            new Point(5, 12),
            Optional.of("Present"),
            Optional.empty()
        };
        
        for (Object obj : testData) {
            String result = analyzeWithSwitch(obj);
            System.out.println(result);
        }
    }
    
    private String analyzeWithSwitch(Object obj) {
        return switch (obj) {
            case String s when s.length() > 10 -> 
                "Long string: '" + s + "' (" + s.length() + " chars)";
            case String s -> 
                "Short string: '" + s + "'";
            case Integer i when i < 0 -> 
                "Negative integer: " + i;
            case Integer i when i == 0 -> 
                "Zero";
            case Integer i -> 
                "Positive integer: " + i + " (binary: " + Integer.toBinaryString(i) + ")";
            case Double d when d > 100 -> 
                "Large double: " + d;
            case Double d -> 
                "Double: " + d + " (floor: " + Math.floor(d) + ")";
            case List<?> list when list.isEmpty() -> 
                "Empty list";
            case List<?> list -> 
                "List with " + list.size() + " elements: " + list;
            case Point(var x, var y) -> 
                "Point at (" + x + ", " + y + ") with distance " + 
                String.format("%.2f", Math.sqrt(x*x + y*y));
            case Optional<?> opt when opt.isPresent() -> 
                "Optional with value: " + opt.get();
            case Optional<?> opt -> 
                "Empty Optional";
            case null -> 
                "Null value";
            default -> 
                "Unknown object of type: " + obj.getClass().getSimpleName();
        };
    }
    
    /**
     * Demonstrates guard conditions in pattern matching
     */
    public void demonstrateGuardConditions() {
        System.out.println("\n=== Guard Conditions ===\n");
        
        var numbers = List.of(-5, 0, 7, 15, 42, 100, 1000);
        
        for (Integer num : numbers) {
            String classification = switch (num) {
                case Integer i when i < 0 -> "Negative: " + i;
                case Integer i when i == 0 -> "Zero";
                case Integer i when i > 0 && i < 10 -> "Single digit: " + i;
                case Integer i when i >= 10 && i < 100 -> "Double digit: " + i;
                case Integer i when i >= 100 && i < 1000 -> "Triple digit: " + i;
                case Integer i -> "Large number: " + i;
            };
            System.out.println(classification);
        }
    }
    
    /**
     * Demonstrates deconstruction patterns with records
     */
    public void demonstrateDeconstructionPatterns() {
        System.out.println("\n=== Deconstruction Patterns ===\n");
        
        var shapes = List.of(
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Point(3, 4)
        );
        
        for (Object shape : shapes) {
            String info = switch (shape) {
                case Circle(var radius) -> 
                    "Circle with radius " + radius + " (area: " + 
                    String.format("%.2f", Math.PI * radius * radius) + ")";
                case Rectangle(var width, var height) -> 
                    "Rectangle " + width + "x" + height + " (area: " + (width * height) + ")";
                case Point(var x, var y) -> 
                    "Point at (" + x + ", " + y + ")";
                default -> "Unknown shape";
            };
            System.out.println(info);
        }
    }
    
    // Record definitions for pattern matching examples
    public record Point(double x, double y) {}
    
    public record Circle(double radius) {
        public Circle {
            if (radius <= 0) {
                throw new IllegalArgumentException("Radius must be positive");
            }
        }
    }
    
    public record Rectangle(double width, double height) {
        public Rectangle {
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("Width and height must be positive");
            }
        }
    }
}