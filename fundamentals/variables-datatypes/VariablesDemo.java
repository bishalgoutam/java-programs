/**
 * Java Variables and Data Types Demo
 * 
 * This program demonstrates different variable declarations and Java data types.
 * Covers: primitive types, reference types, type conversion, and variable scope.
 * 
 * Author: Bishal Goutam
 * Date: October 16, 2025
 */

public class VariablesDemo {
    
    // Class-level variables (fields)
    static int classVariable = 100;  // Static variable
    String instanceVariable = "Instance Variable";  // Instance variable
    
    public static void main(String[] args) {
        System.out.println("=== Java Variables and Data Types Demo ===\n");
        
        // Create an instance to demonstrate instance variables
        VariablesDemo demo = new VariablesDemo();
        
        // Call different demonstration methods
        demo.demonstratePrimitiveTypes();
        demo.demonstrateReferenceTypes();
        demo.demonstrateTypeConversion();
        demo.demonstrateVariableScope();
        demo.demonstrateConstants();
        demo.demonstratePracticalExamples();
        
        System.out.println("\n=== End of Variables and Data Types Demo ===");
    }
    
    /**
     * Demonstrates Java primitive data types
     */
    public void demonstratePrimitiveTypes() {
        System.out.println("1. Primitive Data Types:");
        System.out.println("------------------------");
        
        // Integer types
        byte byteVar = 127;                    // 8-bit: -128 to 127
        short shortVar = 32767;                // 16-bit: -32,768 to 32,767
        int intVar = 2147483647;               // 32-bit: -2^31 to 2^31-1
        long longVar = 9223372036854775807L;   // 64-bit: -2^63 to 2^63-1
        
        System.out.println("Integer Types:");
        System.out.println("  byte: " + byteVar + " (size: " + Byte.BYTES + " bytes, range: " + 
                          Byte.MIN_VALUE + " to " + Byte.MAX_VALUE + ")");
        System.out.println("  short: " + shortVar + " (size: " + Short.BYTES + " bytes, range: " + 
                          Short.MIN_VALUE + " to " + Short.MAX_VALUE + ")");
        System.out.println("  int: " + intVar + " (size: " + Integer.BYTES + " bytes, range: " + 
                          Integer.MIN_VALUE + " to " + Integer.MAX_VALUE + ")");
        System.out.println("  long: " + longVar + " (size: " + Long.BYTES + " bytes, range: " + 
                          Long.MIN_VALUE + " to " + Long.MAX_VALUE + ")");
        
        // Floating-point types
        float floatVar = 3.14159f;             // 32-bit IEEE 754
        double doubleVar = 3.141592653589793;  // 64-bit IEEE 754
        
        System.out.println("\nFloating-Point Types:");
        System.out.println("  float: " + floatVar + " (size: " + Float.BYTES + " bytes, precision: ~7 digits)");
        System.out.println("  double: " + doubleVar + " (size: " + Double.BYTES + " bytes, precision: ~15 digits)");
        
        // Character type
        char charVar = 'A';                    // 16-bit Unicode character
        char unicodeChar = '\u0041';           // Unicode representation of 'A'
        
        System.out.println("\nCharacter Type:");
        System.out.println("  char: '" + charVar + "' (size: " + Character.BYTES + " bytes, Unicode: " + (int)charVar + ")");
        System.out.println("  Unicode char: '" + unicodeChar + "' (\\u0041 = " + (int)unicodeChar + ")");
        
        // Boolean type
        boolean booleanVar = true;
        boolean falseVar = false;
        
        System.out.println("\nBoolean Type:");
        System.out.println("  boolean: " + booleanVar + " (values: true or false)");
        System.out.println("  boolean: " + falseVar);
        
        System.out.println();
    }
    
    /**
     * Demonstrates Java reference data types
     */
    public void demonstrateReferenceTypes() {
        System.out.println("2. Reference Data Types:");
        System.out.println("------------------------");
        
        // String (most commonly used reference type)
        String stringVar = "Hello, Java!";
        String emptyString = "";
        String nullString = null;
        
        System.out.println("String Examples:");
        System.out.println("  stringVar: \"" + stringVar + "\" (length: " + stringVar.length() + ")");
        System.out.println("  emptyString: \"" + emptyString + "\" (length: " + emptyString.length() + ")");
        System.out.println("  nullString: " + nullString + " (null reference)");
        
        // Arrays
        int[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Java", "Python", "C++", "JavaScript"};
        
        System.out.println("\nArray Examples:");
        System.out.print("  intArray: [");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if (i < intArray.length - 1) System.out.print(", ");
        }
        System.out.println("] (length: " + intArray.length + ")");
        
        System.out.print("  stringArray: [");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print("\"" + stringArray[i] + "\"");
            if (i < stringArray.length - 1) System.out.print(", ");
        }
        System.out.println("] (length: " + stringArray.length + ")");
        
        // Object creation
        StringBuilder stringBuilder = new StringBuilder("Dynamic String");
        System.out.println("\nObject Example:");
        System.out.println("  StringBuilder: \"" + stringBuilder.toString() + "\"");
        stringBuilder.append(" - Modified!");
        System.out.println("  After modification: \"" + stringBuilder.toString() + "\"");
        
        System.out.println();
    }
    
    /**
     * Demonstrates type conversion (casting) in Java
     */
    public void demonstrateTypeConversion() {
        System.out.println("3. Type Conversion:");
        System.out.println("------------------");
        
        // Implicit conversion (widening)
        System.out.println("Implicit Conversion (Widening):");
        int intValue = 100;
        long longValue = intValue;        // int to long (automatic)
        double doubleValue = intValue;    // int to double (automatic)
        
        System.out.println("  int " + intValue + " -> long " + longValue);
        System.out.println("  int " + intValue + " -> double " + doubleValue);
        
        // Explicit conversion (narrowing)
        System.out.println("\nExplicit Conversion (Narrowing):");
        double largeDouble = 123.456;
        int convertedInt = (int) largeDouble;  // double to int (manual cast)
        byte convertedByte = (byte) intValue;  // int to byte (manual cast)
        
        System.out.println("  double " + largeDouble + " -> int " + convertedInt + " (truncated)");
        System.out.println("  int " + intValue + " -> byte " + convertedByte);
        
        // String conversion
        System.out.println("\nString Conversion:");
        int numberForString = 42;
        String numberAsString = String.valueOf(numberForString);
        String stringNumber = "123";
        int parsedNumber = Integer.parseInt(stringNumber);
        
        System.out.println("  int " + numberForString + " -> String \"" + numberAsString + "\"");
        System.out.println("  String \"" + stringNumber + "\" -> int " + parsedNumber);
        
        // Wrapper classes
        System.out.println("\nWrapper Classes:");
        Integer integerWrapper = Integer.valueOf(100);  // Boxing
        int primitiveFromWrapper = integerWrapper.intValue();  // Unboxing
        
        // Autoboxing and auto-unboxing (Java 5+)
        Integer autoBoxed = 200;  // Automatic boxing
        int autoUnboxed = autoBoxed;  // Automatic unboxing
        
        System.out.println("  Wrapper Integer: " + integerWrapper);
        System.out.println("  Auto-boxed: " + autoBoxed);
        System.out.println("  Auto-unboxed: " + autoUnboxed);
        
        System.out.println();
    }
    
    /**
     * Demonstrates variable scope in Java
     */
    public void demonstrateVariableScope() {
        System.out.println("4. Variable Scope:");
        System.out.println("-----------------");
        
        // Local variable
        int localVariable = 50;
        
        System.out.println("Accessing different variable scopes:");
        System.out.println("  Class variable (static): " + classVariable);
        System.out.println("  Instance variable: " + instanceVariable);
        System.out.println("  Local variable: " + localVariable);
        
        // Block scope
        if (true) {
            int blockVariable = 25;
            System.out.println("  Block variable (inside if): " + blockVariable);
            System.out.println("  Local variable accessible in block: " + localVariable);
        }
        // blockVariable is not accessible here
        
        // Method parameter scope
        demonstrateParameterScope(75);
        
        System.out.println();
    }
    
    /**
     * Helper method to demonstrate parameter scope
     */
    private void demonstrateParameterScope(int parameter) {
        System.out.println("  Method parameter: " + parameter);
        
        // Parameters are local to the method
        parameter = 999;  // This change doesn't affect the caller
        System.out.println("  Modified parameter (local change): " + parameter);
    }
    
    /**
     * Demonstrates constants and final variables
     */
    public void demonstrateConstants() {
        System.out.println("5. Constants and Final Variables:");
        System.out.println("--------------------------------");
        
        // Constants using final keyword
        final int CONSTANT_VALUE = 100;
        final double PI = 3.14159;
        final String COMPANY_NAME = "Tech Solutions Inc.";
        
        System.out.println("Final Variables (Constants):");
        System.out.println("  CONSTANT_VALUE: " + CONSTANT_VALUE);
        System.out.println("  PI: " + PI);
        System.out.println("  COMPANY_NAME: \"" + COMPANY_NAME + "\"");
        
        // Attempting to change a final variable would cause compilation error
        // CONSTANT_VALUE = 200;  // This would cause an error
        
        // Static final constants (class-level constants)
        System.out.println("\nClass Constants:");
        System.out.println("  Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("  Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("  Character.MAX_VALUE: " + (int)Character.MAX_VALUE);
        
        System.out.println();
    }
    
    /**
     * Demonstrates practical examples using variables and data types
     */
    public void demonstratePracticalExamples() {
        System.out.println("6. Practical Examples:");
        System.out.println("---------------------");
        
        // Example 1: Student grade calculation
        System.out.println("Example 1: Student Grade Calculation");
        String studentName = "Alice Johnson";
        int mathScore = 85;
        int scienceScore = 92;
        int englishScore = 78;
        double averageScore = (mathScore + scienceScore + englishScore) / 3.0;
        char grade = calculateGrade(averageScore);
        
        System.out.println("  Student: " + studentName);
        System.out.println("  Scores: Math=" + mathScore + ", Science=" + scienceScore + ", English=" + englishScore);
        System.out.println("  Average: " + String.format("%.2f", averageScore));
        System.out.println("  Grade: " + grade);
        
        // Example 2: Currency conversion
        System.out.println("\nExample 2: Currency Conversion");
        double usdAmount = 100.0;
        double exchangeRate = 0.85;  // USD to EUR
        double eurAmount = usdAmount * exchangeRate;
        
        System.out.println("  $" + String.format("%.2f", usdAmount) + " USD = €" + 
                          String.format("%.2f", eurAmount) + " EUR");
        System.out.println("  Exchange rate: " + exchangeRate);
        
        // Example 3: Data validation
        System.out.println("\nExample 3: Data Validation");
        validateUserData("John Doe", 25, "john@email.com");
        validateUserData("", -5, "invalid-email");
        
        // Example 4: Working with different number systems
        System.out.println("\nExample 4: Number Systems");
        int decimal = 255;
        String binary = Integer.toBinaryString(decimal);
        String octal = Integer.toOctalString(decimal);
        String hexadecimal = Integer.toHexString(decimal);
        
        System.out.println("  Decimal: " + decimal);
        System.out.println("  Binary: " + binary);
        System.out.println("  Octal: " + octal);
        System.out.println("  Hexadecimal: " + hexadecimal.toUpperCase());
    }
    
    /**
     * Helper method to calculate grade from average score
     */
    private char calculateGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }
    
    /**
     * Helper method to validate user data
     */
    private void validateUserData(String name, int age, String email) {
        System.out.println("  Validating: name=\"" + name + "\", age=" + age + ", email=\"" + email + "\"");
        
        boolean isValidName = name != null && !name.trim().isEmpty();
        boolean isValidAge = age >= 0 && age <= 150;
        boolean isValidEmail = email != null && email.contains("@") && email.contains(".");
        
        System.out.println("    Valid name: " + isValidName);
        System.out.println("    Valid age: " + isValidAge);
        System.out.println("    Valid email: " + isValidEmail);
        System.out.println("    Overall valid: " + (isValidName && isValidAge && isValidEmail));
    }
}