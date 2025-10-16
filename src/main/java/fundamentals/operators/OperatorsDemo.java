package fundamentals.operators;

/**
 * Java Operators Demo
 * 
 * This program demonstrates all types of Java operators:
 * arithmetic, assignment, comparison, logical, bitwise, and special operators.
 * 
 * Author: Bishal Goutam
 * Date: October 16, 2025
 */

public class OperatorsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java Operators Demo ===\n");
        
        OperatorsDemo demo = new OperatorsDemo();
        
        demo.demonstrateArithmeticOperators();
        demo.demonstrateAssignmentOperators();
        demo.demonstrateComparisonOperators();
        demo.demonstrateLogicalOperators();
        demo.demonstrateBitwiseOperators();
        demo.demonstrateUnaryOperators();
        demo.demonstrateSpecialOperators();
        demo.demonstrateOperatorPrecedence();
        demo.demonstratePracticalExamples();
        
        System.out.println("\n=== End of Operators Demo ===");
    }
    
    /**
     * Demonstrates arithmetic operators
     */
    public void demonstrateArithmeticOperators() {
        System.out.println("1. Arithmetic Operators:");
        System.out.println("------------------------");
        
        int a = 15;
        int b = 4;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println();
        
        // Basic arithmetic operations
        System.out.println("Basic Operations:");
        System.out.println("  Addition (a + b): " + a + " + " + b + " = " + (a + b));
        System.out.println("  Subtraction (a - b): " + a + " - " + b + " = " + (a - b));
        System.out.println("  Multiplication (a * b): " + a + " * " + b + " = " + (a * b));
        System.out.println("  Division (a / b): " + a + " / " + b + " = " + (a / b));
        System.out.println("  Modulus (a % b): " + a + " % " + b + " = " + (a % b));
        
        // Floating-point division
        System.out.println("\nFloating-point Division:");
        double doubleA = a;
        double doubleB = b;
        System.out.println("  Floating division: " + doubleA + " / " + doubleB + " = " + (doubleA / doubleB));
        
        // Working with different data types
        System.out.println("\nMixed Data Types:");
        int intNum = 10;
        double doubleNum = 3.5;
        System.out.println("  int " + intNum + " + double " + doubleNum + " = " + (intNum + doubleNum));
        System.out.println("  Result type: double");
        
        System.out.println();
    }
    
    /**
     * Demonstrates assignment operators
     */
    public void demonstrateAssignmentOperators() {
        System.out.println("2. Assignment Operators:");
        System.out.println("------------------------");
        
        int num = 20;
        System.out.println("Initial num: " + num);
        
        // Compound assignment operators
        num += 5;  // num = num + 5
        System.out.println("After num += 5: " + num);
        
        num -= 3;  // num = num - 3
        System.out.println("After num -= 3: " + num);
        
        num *= 2;  // num = num * 2
        System.out.println("After num *= 2: " + num);
        
        num /= 4;  // num = num / 4
        System.out.println("After num /= 4: " + num);
        
        num %= 7;  // num = num % 7
        System.out.println("After num %= 7: " + num);
        
        // Bitwise compound assignment
        System.out.println("\nBitwise Assignment:");
        int bits = 12;  // Binary: 1100
        System.out.println("Initial bits: " + bits + " (binary: " + Integer.toBinaryString(bits) + ")");
        
        bits &= 10;  // bits = bits & 10
        System.out.println("After bits &= 10: " + bits + " (binary: " + Integer.toBinaryString(bits) + ")");
        
        bits |= 5;   // bits = bits | 5
        System.out.println("After bits |= 5: " + bits + " (binary: " + Integer.toBinaryString(bits) + ")");
        
        System.out.println();
    }
    
    /**
     * Demonstrates comparison (relational) operators
     */
    public void demonstrateComparisonOperators() {
        System.out.println("3. Comparison Operators:");
        System.out.println("------------------------");
        
        int x = 10;
        int y = 20;
        int z = 10;
        
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
        System.out.println();
        
        // Relational operators
        System.out.println("Relational Operators:");
        System.out.println("  x == y: " + (x == y));   // Equal to
        System.out.println("  x != y: " + (x != y));   // Not equal to
        System.out.println("  x < y: " + (x < y));     // Less than
        System.out.println("  x > y: " + (x > y));     // Greater than
        System.out.println("  x <= z: " + (x <= z));   // Less than or equal to
        System.out.println("  y >= x: " + (y >= x));   // Greater than or equal to
        
        // String comparison
        System.out.println("\nString Comparison:");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        
        System.out.println("str1 = \"" + str1 + "\", str2 = \"" + str2 + "\", str3 = \"" + str3 + "\"");
        System.out.println("  str1 == str2: " + (str1 == str2));         // Reference comparison
        System.out.println("  str1 == str3: " + (str1 == str3));         // Reference comparison
        System.out.println("  str1.equals(str3): " + str1.equals(str3)); // Content comparison
        
        System.out.println();
    }
    
    /**
     * Demonstrates logical operators
     */
    public void demonstrateLogicalOperators() {
        System.out.println("4. Logical Operators:");
        System.out.println("---------------------");
        
        boolean isTrue = true;
        boolean isFalse = false;
        int age = 25;
        boolean hasLicense = true;
        
        System.out.println("isTrue = " + isTrue + ", isFalse = " + isFalse);
        System.out.println("age = " + age + ", hasLicense = " + hasLicense);
        System.out.println();
        
        // Logical AND (&&)
        System.out.println("Logical AND (&&):");
        System.out.println("  isTrue && hasLicense: " + (isTrue && hasLicense));
        System.out.println("  isFalse && hasLicense: " + (isFalse && hasLicense));
        System.out.println("  (age >= 18) && hasLicense: " + ((age >= 18) && hasLicense));
        
        // Logical OR (||)
        System.out.println("\nLogical OR (||):");
        System.out.println("  isTrue || isFalse: " + (isTrue || isFalse));
        System.out.println("  isFalse || hasLicense: " + (isFalse || hasLicense));
        System.out.println("  (age < 18) || hasLicense: " + ((age < 18) || hasLicense));
        
        // Logical NOT (!)
        System.out.println("\nLogical NOT (!):");
        System.out.println("  !isTrue: " + (!isTrue));
        System.out.println("  !isFalse: " + (!isFalse));
        System.out.println("  !(age < 18): " + (!(age < 18)));
        
        // Short-circuit evaluation
        System.out.println("\nShort-circuit Evaluation:");
        @SuppressWarnings("unused")
        boolean shortCircuit1 = false && expensiveOperation(); // expensiveOperation() not called
        @SuppressWarnings("unused") 
        boolean shortCircuit2 = true || expensiveOperation(); // expensiveOperation() not called
        System.out.println("  false && (expensive operation): " + shortCircuit1);
        System.out.println("  true || (expensive operation): " + shortCircuit2);
        System.out.println("Note: expensive operation methods were not called due to short-circuiting");
        
        System.out.println();
    }
    
    /**
     * Demonstrates bitwise operators
     */
    public void demonstrateBitwiseOperators() {
        System.out.println("5. Bitwise Operators:");
        System.out.println("---------------------");
        
        int a = 12; // Binary: 1100
        int b = 10; // Binary: 1010
        
        System.out.println("a = " + a + " (binary: " + String.format("%4s", Integer.toBinaryString(a)).replace(' ', '0') + ")");
        System.out.println("b = " + b + " (binary: " + String.format("%4s", Integer.toBinaryString(b)).replace(' ', '0') + ")");
        System.out.println();
        
        // Bitwise operations
        System.out.println("Bitwise Operations:");
        int andResult = a & b;
        int orResult = a | b;
        int xorResult = a ^ b;
        int notResult = ~a;
        
        System.out.println("  AND (a & b): " + andResult + " (binary: " + Integer.toBinaryString(andResult) + ")");
        System.out.println("  OR (a | b): " + orResult + " (binary: " + Integer.toBinaryString(orResult) + ")");
        System.out.println("  XOR (a ^ b): " + xorResult + " (binary: " + Integer.toBinaryString(xorResult) + ")");
        System.out.println("  NOT (~a): " + notResult + " (binary: " + Integer.toBinaryString(notResult) + ")");
        
        // Shift operations
        System.out.println("\nShift Operations:");
        int leftShift = a << 2;   // Left shift by 2 positions
        int rightShift = a >> 2;  // Right shift by 2 positions
        int unsignedRightShift = a >>> 2; // Unsigned right shift
        
        System.out.println("  Left shift (a << 2): " + leftShift + " (binary: " + Integer.toBinaryString(leftShift) + ")");
        System.out.println("  Right shift (a >> 2): " + rightShift + " (binary: " + Integer.toBinaryString(rightShift) + ")");
        System.out.println("  Unsigned right shift (a >>> 2): " + unsignedRightShift);
        
        System.out.println();
    }
    
    /**
     * Demonstrates unary operators
     */
    public void demonstrateUnaryOperators() {
        System.out.println("6. Unary Operators:");
        System.out.println("-------------------");
        
        int num = 10;
        boolean flag = true;
        
        System.out.println("Initial values: num = " + num + ", flag = " + flag);
        System.out.println();
        
        // Increment and decrement operators
        System.out.println("Increment/Decrement Operators:");
        System.out.println("  Pre-increment (++num): " + (++num));   // Increment first, then use
        System.out.println("  Current num: " + num);
        System.out.println("  Post-increment (num++): " + (num++)); // Use first, then increment
        System.out.println("  Current num: " + num);
        
        System.out.println("  Pre-decrement (--num): " + (--num));   // Decrement first, then use
        System.out.println("  Current num: " + num);
        System.out.println("  Post-decrement (num--): " + (num--)); // Use first, then decrement
        System.out.println("  Final num: " + num);
        
        // Unary plus and minus
        System.out.println("\nUnary Plus/Minus:");
        int positive = +num;  // Unary plus (rarely used)
        int negative = -num;  // Unary minus
        
        System.out.println("  Unary plus (+num): " + positive);
        System.out.println("  Unary minus (-num): " + negative);
        
        // Logical NOT
        System.out.println("\nLogical NOT:");
        System.out.println("  !flag: " + (!flag));
        System.out.println("  !(!flag): " + (!(!flag)));
        
        System.out.println();
    }
    
    /**
     * Demonstrates special operators
     */
    public void demonstrateSpecialOperators() {
        System.out.println("7. Special Operators:");
        System.out.println("--------------------");
        
        // Ternary operator (conditional operator)
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Ternary Operator:");
        System.out.println("  Age: " + age);
        System.out.println("  Status: " + status + " (using ternary operator)");
        
        // Nested ternary operator
        int score = 85;
        char grade = (score >= 90) ? 'A' : (score >= 80) ? 'B' : (score >= 70) ? 'C' : 'F';
        System.out.println("  Score: " + score + ", Grade: " + grade + " (nested ternary)");
        
        // instanceof operator
        System.out.println("\ninstanceof Operator:");
        String text = "Hello World";
        Object obj = text;
        
        System.out.println("  text instanceof String: " + (text instanceof String));
        System.out.println("  text instanceof Object: " + (text instanceof Object));
        System.out.println("  obj instanceof String: " + (obj instanceof String));
        
        // Type cast operator
        System.out.println("\nType Cast Operator:");
        double doubleValue = 123.456;
        int intValue = (int) doubleValue;  // Explicit casting
        
        System.out.println("  double value: " + doubleValue);
        System.out.println("  Casted to int: " + intValue);
        
        System.out.println();
    }
    
    /**
     * Demonstrates operator precedence
     */
    public void demonstrateOperatorPrecedence() {
        System.out.println("8. Operator Precedence:");
        System.out.println("-----------------------");
        
        // Arithmetic precedence
        int result1 = 5 + 3 * 2;          // Multiplication first
        int result2 = (5 + 3) * 2;        // Parentheses first
        
        System.out.println("Arithmetic Precedence:");
        System.out.println("  5 + 3 * 2 = " + result1 + " (multiplication first)");
        System.out.println("  (5 + 3) * 2 = " + result2 + " (parentheses first)");
        
        // Logical precedence
        @SuppressWarnings("unused")
        boolean result3 = true || false && false;  // && has higher precedence than ||
        @SuppressWarnings("unused") 
        boolean result4 = (true || false) && false; // Parentheses change order
        
        System.out.println("\nLogical Precedence:");
        System.out.println("  true || false && false = " + result3 + " (&& has higher precedence)");
        System.out.println("  (true || false) && false = " + result4 + " (parentheses first)");
        
        // Complex expression
        int complex = 10 + 5 * 2 - 8 / 4;
        System.out.println("\nComplex Expression:");
        System.out.println("  10 + 5 * 2 - 8 / 4 = " + complex);
        System.out.println("  Order: 5*2=10, 8/4=2, 10+10-2=18");
        
        System.out.println();
    }
    
    /**
     * Demonstrates practical examples using operators
     */
    public void demonstratePracticalExamples() {
        System.out.println("9. Practical Examples:");
        System.out.println("----------------------");
        
        // Example 1: Calculator
        System.out.println("Example 1: Simple Calculator");
        double num1 = 15.5;
        double num2 = 4.2;
        
        System.out.println("  Numbers: " + num1 + " and " + num2);
        System.out.println("  Addition: " + (num1 + num2));
        System.out.println("  Subtraction: " + (num1 - num2));
        System.out.println("  Multiplication: " + (num1 * num2));
        System.out.println("  Division: " + (num1 / num2));
        System.out.println("  Modulus: " + (num1 % num2));
        
        // Example 2: Grade evaluation
        System.out.println("\nExample 2: Grade Evaluation");
        int[] scores = {92, 78, 85, 96, 73};
        int total = 0;
        
        System.out.print("  Scores: ");
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
            System.out.print(scores[i]);
            if (i < scores.length - 1) System.out.print(", ");
        }
        
        double average = (double) total / scores.length;
        String grade = (average >= 90) ? "A" : 
                      (average >= 80) ? "B" : 
                      (average >= 70) ? "C" : 
                      (average >= 60) ? "D" : "F";
        
        System.out.println("\n  Total: " + total);
        System.out.println("  Average: " + String.format("%.2f", average));
        System.out.println("  Grade: " + grade);
        
        // Example 3: User authentication
        System.out.println("\nExample 3: User Authentication");
        String username = "admin";
        String password = "password123";
        boolean isAccountActive = true;
        int loginAttempts = 2;
        
        boolean canLogin = username.equals("admin") && 
                          password.equals("password123") && 
                          isAccountActive && 
                          loginAttempts < 3;
        
        System.out.println("  Username: " + username);
        System.out.println("  Password correct: " + password.equals("password123"));
        System.out.println("  Account active: " + isAccountActive);
        System.out.println("  Login attempts: " + loginAttempts + "/3");
        System.out.println("  Can login: " + canLogin);
        
        // Example 4: Bitwise flags
        System.out.println("\nExample 4: Permission Flags (Bitwise)");
        final int READ = 1;    // Binary: 001
        final int WRITE = 2;   // Binary: 010
        final int EXECUTE = 4; // Binary: 100
        
        int userPermissions = READ | WRITE; // User has read and write permissions
        
        System.out.println("  READ flag: " + READ + " (binary: " + Integer.toBinaryString(READ) + ")");
        System.out.println("  WRITE flag: " + WRITE + " (binary: " + Integer.toBinaryString(WRITE) + ")");
        System.out.println("  EXECUTE flag: " + EXECUTE + " (binary: " + Integer.toBinaryString(EXECUTE) + ")");
        System.out.println("  User permissions: " + userPermissions + " (binary: " + Integer.toBinaryString(userPermissions) + ")");
        
        boolean hasRead = (userPermissions & READ) != 0;
        boolean hasWrite = (userPermissions & WRITE) != 0;
        boolean hasExecute = (userPermissions & EXECUTE) != 0;
        
        System.out.println("  Has READ permission: " + hasRead);
        System.out.println("  Has write permission: " + hasWrite);
        System.out.println("  Has execute permission: " + hasExecute);
    }
    
    /**
     * Helper method to simulate an expensive operation
     */
    private boolean expensiveOperation() {
        System.out.println("    Expensive operation called!"); // This shouldn't print due to short-circuiting
        return true;
    }
}