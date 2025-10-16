# Scientific Calculator Project

A comprehensive scientific calculator application built in Java, demonstrating object-oriented programming principles and advanced Java features.

## Features

### Basic Operations
- Addition (+)
- Subtraction (-)
- Multiplication (*)
- Division (/)
- Modulo (%)

### Scientific Functions
- Square Root (√)
- Power (x^y)
- Trigonometric Functions:
  - Sine (sin)
  - Cosine (cos)
  - Tangent (tan)
- Logarithmic Functions:
  - Natural Logarithm (ln)
  - Logarithm Base 10 (log)
- Factorial (n!)

### Memory Operations
- Memory Store (MS)
- Memory Add (M+)
- Memory Subtract (M-)
- Memory Recall (MR)
- Memory Clear (MC)

### Additional Features
- Calculation History (up to 50 calculations)
- Error Handling for invalid operations
- User-friendly console interface
- Input validation

## Technical Implementation

### Classes and OOP Concepts

1. **CalculatorApp** - Main application class with user interface
2. **Calculator** - Core calculation logic and memory management
3. **CalculatorHistory** - History management with timestamp logging
4. **MathConstants** - Mathematical constants and utility functions

### Java Concepts Demonstrated

- **Object-Oriented Design**: Separation of concerns with distinct classes
- **Exception Handling**: Custom error messages for invalid operations
- **Method Overloading**: Multiple ways to perform operations
- **Static Methods**: Utility functions in MathConstants class
- **Collections**: ArrayList for history management
- **Switch Expressions**: Modern Java 21 switch syntax
- **Input Validation**: Robust user input handling

## How to Run

### Prerequisites
- Java 21 LTS or later
- Command line interface

### Compilation and Execution

```bash
# Navigate to the calculator directory
cd projects/calculator

# Compile the Java files
javac CalculatorApp.java

# Run the application
java CalculatorApp
```

### Using Maven (from project root)

```bash
# Compile the entire project
mvn compile

# Run the calculator
java -cp target/classes CalculatorApp
```

## Usage Examples

### Basic Calculations
```
1. Basic Calculations
Enter first number: 15
Enter operator (+, -, *, /, %): +
Enter second number: 25
Result: 40.0
```

### Scientific Functions
```
2. Scientific Functions
Choose function: 3 (Sine)
Enter angle in degrees: 30
Result: 0.5
```

### Memory Operations
```
3. Memory Operations
Choose operation: 1 (Store)
Enter value to store: 42.5
Value 42.5 stored in memory.
```

## Error Handling

The calculator includes comprehensive error handling for:

- **Division by Zero**: Prevents mathematical errors
- **Invalid Input**: Validates user input types
- **Domain Errors**: Checks for invalid function inputs (e.g., sqrt of negative)
- **Range Errors**: Prevents overflow in factorial calculations

## Project Structure

```
calculator/
├── CalculatorApp.java          # Main application class
├── README.md                   # This documentation
└── sample-output.txt          # Example program output
```

## Code Highlights

### Modern Java Features
- **Switch Expressions** (Java 14+):
```java
double result = switch (operator) {
    case "+" -> calculator.add(num1, num2);
    case "-" -> calculator.subtract(num1, num2);
    case "*" -> calculator.multiply(num1, num2);
    case "/" -> calculator.divide(num1, num2);
    case "%" -> calculator.modulo(num1, num2);
    default -> throw new IllegalArgumentException("Invalid operator");
};
```

- **Pattern Matching** for instanceof:
```java
if (emp instanceof Manager manager) {
    System.out.println("Department: " + manager.getDepartment());
}
```

### Exception Handling
```java
public double divide(double a, double b) {
    if (b == 0) {
        throw new ArithmeticException("Division by zero is not allowed");
    }
    return a / b;
}
```

## Future Enhancements

- Graphical User Interface (GUI) with JavaFX
- Complex number support
- Unit conversions
- Equation solver
- Graph plotting capabilities
- Export history to file
- Custom function definitions

## Learning Objectives

This project helps learn:

1. **Object-Oriented Programming**: Class design and relationships
2. **Exception Handling**: Robust error management
3. **User Interface Design**: Console-based menu systems
4. **Data Structures**: Using collections for data management
5. **Input Validation**: Ensuring data integrity
6. **Mathematical Programming**: Implementing mathematical functions
7. **Software Architecture**: Separating concerns and modular design

## Contributing

Feel free to enhance this calculator by:
- Adding new mathematical functions
- Improving the user interface
- Adding unit tests
- Implementing additional features
- Optimizing performance

## License

This project is part of the Java Programming Repository and is available under the MIT License.

---

**Author**: Bishal Goutam  
**Language**: Java 21 LTS  
**Type**: Educational Project / Console Application