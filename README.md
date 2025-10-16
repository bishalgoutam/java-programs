# Java Programming Repository

Welcome to my comprehensive Java programming collection! This repository contains educational resources, examples, and projects covering Java from fundamentals to advanced concepts.

## 🚀 Repository Structure

```
java-programs/
├── fundamentals/              # Core Java concepts
│   ├── variables-datatypes/   # Variables, data types, and type conversion
│   ├── operators/            # Arithmetic, comparison, logical operators
│   ├── control-structures/   # Conditionals, loops, and control flow
│   ├── methods/             # Method declarations, overloading, parameters
│   └── arrays/              # Array manipulation and multidimensional arrays
├── object-oriented/          # Object-Oriented Programming
│   ├── classes-objects/     # Classes, objects, constructors
│   ├── inheritance/         # Inheritance and super keyword
│   ├── polymorphism/        # Method overriding and runtime polymorphism
│   └── encapsulation/       # Access modifiers and data hiding
├── intermediate/             # Intermediate Java topics
│   ├── collections/         # ArrayList, HashMap, Set, Queue
│   ├── exception-handling/  # Try-catch, custom exceptions
│   ├── file-io/            # File reading/writing, serialization
│   └── multithreading/     # Threads, synchronization, concurrency
├── advanced/                # Advanced Java features
│   ├── generics/           # Generic classes and methods
│   ├── lambda-expressions/ # Lambda expressions and functional interfaces
│   ├── streams/            # Stream API and functional programming
│   └── design-patterns/    # Common design patterns in Java
├── projects/               # Practical Java projects
│   ├── calculator/         # Console-based calculator
│   ├── student-management/ # Student record management system
│   ├── banking-system/     # Simple banking application
│   └── inventory-system/   # Inventory management application
├── environment-setup/      # Development environment configuration
│   ├── jdk-setup/         # JDK installation and configuration
│   ├── ide-configuration/ # IDE setup guides (Eclipse, IntelliJ, VS Code)
│   └── build-tools/       # Maven, Gradle configuration
└── README.md              # This file
```

## 🛠️ Environment Requirements

### Java Development Kit (JDK)
- **JDK**: Java 21 LTS (Latest Long Term Support release)
- **IDE**: IntelliJ IDEA, Eclipse, VS Code with Java extensions
- **Build Tools**: Maven 3.9+ or Gradle 8.0+ (configured for Java 21)

### System Requirements
- **Operating System**: Windows 10+, macOS 10.14+, or Linux
- **Memory**: 4GB RAM minimum (8GB recommended)
- **Storage**: 2GB free space for JDK and IDE

## 🎯 Learning Path

### 1. Fundamentals (Start Here)
- Variables and Data Types
- Operators and Expressions
- Control Structures
- Methods and Parameters
- Arrays and Array Manipulation

### 2. Object-Oriented Programming
- Classes and Objects
- Inheritance and Super
- Polymorphism and Overriding
- Encapsulation and Access Modifiers

### 3. Intermediate Concepts
- Collections Framework
- Exception Handling
- File Input/Output
- Multithreading Basics

### 4. Advanced Topics
- Generics and Type Safety
- Lambda Expressions
- Stream API
- Design Patterns

### 5. Practical Projects
- Build real-world applications
- Apply learned concepts
- Portfolio development

## 📝 Code Examples

Each directory contains:
- **Source Code**: Well-commented Java files (.java)
- **README.md**: Concept explanations and usage instructions
- **Examples**: Practical demonstrations
- **Exercises**: Practice problems and solutions

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/bishalgoutam/java-programs.git
   cd java-programs
   ```

2. **Verify Java 21 installation:**
   ```bash
   # Check Java version (should show 21.x.x)
   java --version
   javac --version
   
   # Run environment validation
   cd environment-setup
   java -cp ../target/classes com.bishalgoutam.environment.Java21EnvironmentValidator
   ```

3. **Compile and run examples:**
   ```bash
   # Build with Maven (recommended)
   mvn clean compile
   
   # Run Java 21 features demo
   java -cp target/classes com.bishalgoutam.features.PatternMatchingExamples
   
   # Or navigate to specific examples
   cd fundamentals/variables-datatypes
   
   # Compile Java program
   javac VariablesDemo.java
   
   # Run the program
   java VariablesDemo
   ```

4. **Using an IDE:**
   - Import the project into your preferred IDE
   - Set up the project structure
   - Run programs directly from the IDE

## 📚 Key Java Concepts Covered

### Core Language Features
- ✅ Variables and Data Types (primitives, objects)
- ✅ Operators and Expressions
- ✅ Control Flow and Loops
- ✅ Methods and Method Overloading
- ✅ Arrays and Multidimensional Arrays
- ✅ Strings and String Manipulation

### Object-Oriented Programming
- ✅ Classes and Objects
- ✅ Constructors and this keyword
- ✅ Inheritance and super keyword
- ✅ Method Overriding and Polymorphism
- ✅ Abstract Classes and Interfaces
- ✅ Encapsulation and Access Modifiers

### Advanced Features
- ✅ Collections Framework (List, Set, Map)
- ✅ Exception Handling and Custom Exceptions
- ✅ File I/O and Serialization
- ✅ Multithreading and Synchronization
- ✅ Generics and Type Safety
- ✅ Lambda Expressions and Functional Interfaces
- ✅ Stream API and Functional Programming

### Modern Java Features
- ✅ Pattern Matching for switch (Java 21)
- ✅ Record Patterns (Java 21)
- ✅ Text Blocks (Java 15+)
- ✅ Records (Java 16+)
- ✅ Sealed Classes (Java 17+)
- ✅ Virtual Threads (Java 21)
- ✅ String Templates (Java 21 Preview)

## 🔧 Development Tools

### Recommended IDEs
- **IntelliJ IDEA**: Professional Java development
- **Eclipse**: Open-source Java IDE
- **VS Code**: Lightweight with Java extension pack
- **NetBeans**: Apache NetBeans IDE

### Build Tools
- **Maven**: Project object model and build automation (Java 21 configured)
- **Gradle**: Flexible build tool with Groovy/Kotlin DSL
- **Ant**: XML-based build tool (legacy projects)

### Useful Tools
- **JUnit**: Unit testing framework
- **Mockito**: Mocking framework for testing
- **Checkstyle**: Code style checking
- **SpotBugs**: Static analysis for bug detection

## 📁 Project Structure Guidelines

Each Java program follows a consistent structure:
```
program-name/
├── src/
│   └── main/
│       └── java/
│           └── ProgramName.java    # Main Java file
├── README.md                       # Program documentation
├── sample-output.txt              # Expected output
└── pom.xml                        # Maven configuration (if applicable)
```

## 🤝 Contributing

Feel free to contribute by:
- Adding new examples and programs
- Improving documentation
- Fixing bugs and issues
- Suggesting enhancements
- Adding more advanced topics

## 📞 Contact

**Bishal Goutam**
- GitHub: [@bishalgoutam](https://github.com/bishalgoutam)
- LinkedIn: [Bishal Goutam](https://www.linkedin.com/in/bishal-goutam-9139451a/)
- Email: [your-email@example.com]

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

*Happy coding with Java! ☕*