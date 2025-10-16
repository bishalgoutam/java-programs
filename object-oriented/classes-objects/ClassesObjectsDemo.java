/**
 * Classes and Objects - Comprehensive Examples
 * 
 * This program demonstrates fundamental OOP concepts:
 * - Class definition and object creation
 * - Constructors (default, parameterized, copy)
 * - Instance variables and methods
 * - Static variables and methods
 * - Object relationships and composition
 * 
 * @author Bishal Goutam
 * @since Java 21
 */

public class ClassesObjectsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Classes and Objects Demo ===\n");
        
        demonstrateBasicClassConcepts();
        demonstrateConstructors();
        demonstrateStaticMembers();
        demonstrateObjectComposition();
        demonstrateObjectArrays();
    }
    
    /**
     * Demonstrates basic class and object concepts
     */
    public static void demonstrateBasicClassConcepts() {
        System.out.println("1. Basic Class and Object Concepts");
        System.out.println("-".repeat(38));
        
        // Create Student objects
        Student student1 = new Student();
        student1.setName("Alice Johnson");
        student1.setAge(20);
        student1.setGrade(85.5);
        
        Student student2 = new Student("Bob Smith", 22, 91.2);
        
        // Display student information
        System.out.println("Student 1:");
        student1.displayInfo();
        student1.study("Mathematics");
        
        System.out.println("\nStudent 2:");
        student2.displayInfo();
        student2.study("Physics");
        
        // Demonstrate object methods
        System.out.println("\nStudent 1 grade status: " + student1.getGradeStatus());
        System.out.println("Student 2 is adult: " + student2.isAdult());
        System.out.println();
    }
    
    /**
     * Demonstrates different types of constructors
     */
    public static void demonstrateConstructors() {
        System.out.println("2. Constructor Types");
        System.out.println("-".repeat(24));
        
        // Default constructor
        Car car1 = new Car();
        System.out.println("Car 1 (default constructor): " + car1);
        
        // Parameterized constructor
        Car car2 = new Car("Toyota", "Camry", 2023, 25000.0);
        System.out.println("Car 2 (parameterized): " + car2);
        
        // Copy constructor
        Car car3 = new Car(car2);
        System.out.println("Car 3 (copy of car2): " + car3);
        
        // Constructor chaining
        Employee emp1 = new Employee("John Doe");
        Employee emp2 = new Employee("Jane Smith", "Software Engineer");
        Employee emp3 = new Employee("Mike Johnson", "Manager", 75000.0);
        
        System.out.println("\nEmployees:");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println();
    }
    
    /**
     * Demonstrates static variables and methods
     */
    public static void demonstrateStaticMembers() {
        System.out.println("3. Static Members");
        System.out.println("-".repeat(20));
        
        // Static variables track state across all objects
        System.out.println("Initial student count: " + Student.getStudentCount());
        
        Student s1 = new Student("Alice", 20, 85.0);
        Student s2 = new Student("Bob", 21, 90.0);
        Student s3 = new Student("Charlie", 19, 88.0);
        
        System.out.println("After creating 3 students: " + Student.getStudentCount());
        
        // Static methods can be called without objects
        System.out.println("Average passing grade: " + Student.getAveragePassingGrade());
        
        // Utility class with only static methods
        System.out.println("\nMath Utilities:");
        System.out.println("Circle area (radius 5): " + MathHelper.calculateCircleArea(5.0));
        System.out.println("Rectangle area (4x6): " + MathHelper.calculateRectangleArea(4.0, 6.0));
        System.out.println("Triangle area (base 8, height 5): " + MathHelper.calculateTriangleArea(8.0, 5.0));
        System.out.println();
    }
    
    /**
     * Demonstrates object composition and relationships
     */
    public static void demonstrateObjectComposition() {
        System.out.println("4. Object Composition");
        System.out.println("-".repeat(25));
        
        // Create a university with departments and courses
        University university = new University("Tech University", "Boston");
        
        // Add departments
        Department csDept = new Department("Computer Science", "Dr. Smith");
        Department mathDept = new Department("Mathematics", "Dr. Johnson");
        
        university.addDepartment(csDept);
        university.addDepartment(mathDept);
        
        // Add courses to departments
        csDept.addCourse(new Course("CS101", "Introduction to Programming", 3));
        csDept.addCourse(new Course("CS201", "Data Structures", 4));
        mathDept.addCourse(new Course("MATH101", "Calculus I", 4));
        mathDept.addCourse(new Course("MATH201", "Linear Algebra", 3));
        
        // Display university information
        university.displayInfo();
        System.out.println();
    }
    
    /**
     * Demonstrates arrays of objects
     */
    public static void demonstrateObjectArrays() {
        System.out.println("5. Object Arrays");
        System.out.println("-".repeat(20));
        
        // Create array of Book objects
        Book[] library = {
            new Book("1984", "George Orwell", 328, 12.99),
            new Book("To Kill a Mockingbird", "Harper Lee", 281, 14.99),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, 10.99),
            new Book("Pride and Prejudice", "Jane Austen", 432, 13.99),
            new Book("The Catcher in the Rye", "J.D. Salinger", 277, 11.99)
        };
        
        System.out.println("Library Books:");
        for (int i = 0; i < library.length; i++) {
            System.out.println((i + 1) + ". " + library[i]);
        }
        
        // Find most expensive book
        Book mostExpensive = library[0];
        for (Book book : library) {
            if (book.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = book;
            }
        }
        System.out.println("\nMost expensive book: " + mostExpensive.getTitle() + 
                          " ($" + mostExpensive.getPrice() + ")");
        
        // Calculate total value
        double totalValue = 0;
        for (Book book : library) {
            totalValue += book.getPrice();
        }
        System.out.println("Total library value: $" + String.format("%.2f", totalValue));
    }
}

/**
 * Student class demonstrating basic OOP concepts
 */
class Student {
    // Instance variables
    private String name;
    private int age;
    private double grade;
    
    // Static variable to count total students
    private static int studentCount = 0;
    private static final double PASSING_GRADE = 60.0;
    
    // Default constructor
    public Student() {
        this("Unknown", 0, 0.0);
    }
    
    // Parameterized constructor
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        studentCount++; // Increment static counter
    }
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    
    // Instance methods
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
    
    public void study(String subject) {
        System.out.println(name + " is studying " + subject);
    }
    
    public String getGradeStatus() {
        return (grade >= PASSING_GRADE) ? "Passing" : "Failing";
    }
    
    public boolean isAdult() {
        return age >= 18;
    }
    
    // Static methods
    public static int getStudentCount() {
        return studentCount;
    }
    
    public static double getAveragePassingGrade() {
        return PASSING_GRADE;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }
}

/**
 * Car class demonstrating constructors
 */
class Car {
    private String make;
    private String model;
    private int year;
    private double price;
    
    // Default constructor
    public Car() {
        this("Unknown", "Unknown", 2020, 0.0);
    }
    
    // Parameterized constructor
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    // Copy constructor
    public Car(Car other) {
        this(other.make, other.model, other.year, other.price);
    }
    
    @Override
    public String toString() {
        return year + " " + make + " " + model + " ($" + String.format("%.2f", price) + ")";
    }
}

/**
 * Employee class demonstrating constructor chaining
 */
class Employee {
    private String name;
    private String position;
    private double salary;
    
    // Constructor with name only
    public Employee(String name) {
        this(name, "Entry Level", 40000.0);
    }
    
    // Constructor with name and position
    public Employee(String name, String position) {
        this(name, position, 50000.0);
    }
    
    // Main constructor
    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return name + " - " + position + " ($" + String.format("%.2f", salary) + ")";
    }
}

/**
 * Utility class with static methods only
 */
class MathHelper {
    // Private constructor to prevent instantiation
    private MathHelper() {}
    
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }
    
    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }
}

/**
 * University class demonstrating composition
 */
class University {
    private String name;
    private String location;
    private Department[] departments;
    private int departmentCount;
    
    public University(String name, String location) {
        this.name = name;
        this.location = location;
        this.departments = new Department[10]; // Max 10 departments
        this.departmentCount = 0;
    }
    
    public void addDepartment(Department department) {
        if (departmentCount < departments.length) {
            departments[departmentCount++] = department;
        }
    }
    
    public void displayInfo() {
        System.out.println("University: " + name + " (" + location + ")");
        System.out.println("Departments: " + departmentCount);
        
        for (int i = 0; i < departmentCount; i++) {
            departments[i].displayInfo();
        }
    }
}

/**
 * Department class
 */
class Department {
    private String name;
    private String head;
    private Course[] courses;
    private int courseCount;
    
    public Department(String name, String head) {
        this.name = name;
        this.head = head;
        this.courses = new Course[20]; // Max 20 courses
        this.courseCount = 0;
    }
    
    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
        }
    }
    
    public void displayInfo() {
        System.out.println("  Department: " + name + " (Head: " + head + ")");
        System.out.println("  Courses: " + courseCount);
        
        for (int i = 0; i < courseCount; i++) {
            System.out.println("    " + courses[i]);
        }
    }
}

/**
 * Course class
 */
class Course {
    private String code;
    private String title;
    private int credits;
    
    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return code + ": " + title + " (" + credits + " credits)";
    }
}

/**
 * Book class for object array demonstration
 */
class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }
    
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + pages + " pages, $" + 
               String.format("%.2f", price) + ")";
    }
}