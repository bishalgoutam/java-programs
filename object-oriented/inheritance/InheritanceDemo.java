/**
 * Inheritance - Comprehensive Examples
 * 
 * This program demonstrates inheritance concepts:
 * - Single inheritance and class hierarchy
 * - Method overriding and super keyword
 * - Abstract classes and methods
 * - Constructor inheritance and super() calls
 * - instanceof operator and type checking
 * 
 * @author Bishal Goutam
 * @since Java 21
 */

public class InheritanceDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Inheritance Demo ===\n");
        
        demonstrateBasicInheritance();
        demonstrateMethodOverriding();
        demonstrateAbstractClasses();
        demonstratePolymorphism();
        demonstrateConstructorInheritance();
    }
    
    /**
     * Demonstrates basic inheritance concepts
     */
    public static void demonstrateBasicInheritance() {
        System.out.println("1. Basic Inheritance");
        System.out.println("-".repeat(24));
        
        // Create instances of base and derived classes
        Animal genericAnimal = new Animal("Generic", 5);
        Dog myDog = new Dog("Buddy", 3, "Golden Retriever");
        Cat myCat = new Cat("Whiskers", 2, true);
        
        System.out.println("Generic Animal:");
        genericAnimal.displayInfo();
        genericAnimal.makeSound();
        
        System.out.println("\nDog:");
        myDog.displayInfo(); // Inherited method
        myDog.makeSound();   // Overridden method
        myDog.fetch();       // Dog-specific method
        
        System.out.println("\nCat:");
        myCat.displayInfo(); // Inherited method
        myCat.makeSound();   // Overridden method
        myCat.climb();       // Cat-specific method
        System.out.println();
    }
    
    /**
     * Demonstrates method overriding
     */
    public static void demonstrateMethodOverriding() {
        System.out.println("2. Method Overriding");
        System.out.println("-".repeat(24));
        
        Vehicle[] vehicles = {
            new Car("Toyota Camry", 4),
            new Motorcycle("Harley Davidson", 2),
            new Bicycle("Mountain Bike", 2)
        };
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle: " + vehicle.getName());
            vehicle.start();    // Overridden method
            vehicle.accelerate(); // Overridden method
            vehicle.stop();     // Overridden method
            System.out.println("Wheels: " + vehicle.getWheels());
            System.out.println();
        }
    }
    
    /**
     * Demonstrates abstract classes and methods
     */
    public static void demonstrateAbstractClasses() {
        System.out.println("3. Abstract Classes");
        System.out.println("-".repeat(23));
        
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0)
        };
        
        double totalArea = 0;
        double totalPerimeter = 0;
        
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getClass().getSimpleName());
            double area = shape.calculateArea();
            double perimeter = shape.calculatePerimeter();
            
            System.out.printf("Area: %.2f%n", area);
            System.out.printf("Perimeter: %.2f%n", perimeter);
            shape.displayInfo(); // Abstract method implementation
            
            totalArea += area;
            totalPerimeter += perimeter;
            System.out.println();
        }
        
        System.out.printf("Total Area: %.2f%n", totalArea);
        System.out.printf("Total Perimeter: %.2f%n", totalPerimeter);
        System.out.println();
    }
    
    /**
     * Demonstrates runtime polymorphism
     */
    public static void demonstratePolymorphism() {
        System.out.println("4. Polymorphism and instanceof");
        System.out.println("-".repeat(35));
        
        Employee[] employees = {
            new Manager("Alice Johnson", 75000, "Engineering", 5),
            new Developer("Bob Smith", 65000, "Java", 3),
            new Designer("Carol Davis", 60000, "UI/UX", 2),
            new Manager("David Wilson", 80000, "Sales", 8)
        };
        
        double totalSalary = 0;
        int managerCount = 0;
        int developerCount = 0;
        int designerCount = 0;
        
        for (Employee emp : employees) {
            System.out.println("Employee: " + emp.getName());
            emp.work(); // Polymorphic method call
            
            // Type checking with instanceof
            if (emp instanceof Manager manager) {
                System.out.println("  Department: " + manager.getDepartment());
                System.out.println("  Team Size: " + manager.getTeamSize());
                managerCount++;
            } else if (emp instanceof Developer developer) {
                System.out.println("  Programming Language: " + developer.getProgrammingLanguage());
                System.out.println("  Experience: " + developer.getExperience() + " years");
                developerCount++;
            } else if (emp instanceof Designer designer) {
                System.out.println("  Design Type: " + designer.getDesignType());
                System.out.println("  Experience: " + designer.getExperience() + " years");
                designerCount++;
            }
            
            System.out.println("  Salary: $" + emp.getSalary());
            totalSalary += emp.getSalary();
            System.out.println();
        }
        
        System.out.println("Summary:");
        System.out.println("Managers: " + managerCount);
        System.out.println("Developers: " + developerCount);
        System.out.println("Designers: " + designerCount);
        System.out.printf("Average Salary: $%.2f%n", totalSalary / employees.length);
        System.out.println();
    }
    
    /**
     * Demonstrates constructor inheritance
     */
    public static void demonstrateConstructorInheritance() {
        System.out.println("5. Constructor Inheritance");
        System.out.println("-".repeat(30));
        
        System.out.println("Creating Student...");
        Student student = new Student("John Doe", 20, "S12345", "Computer Science");
        student.displayInfo();
        
        System.out.println("\nCreating Graduate Student...");
        GraduateStudent gradStudent = new GraduateStudent(
            "Jane Smith", 24, "G67890", "Computer Science", 
            "Machine Learning", "Dr. Johnson"
        );
        gradStudent.displayInfo();
        
        System.out.println("\nCreating Undergraduate Student...");
        UndergraduateStudent undergradStudent = new UndergraduateStudent(
            "Mike Brown", 19, "U11111", "Mathematics", 2
        );
        undergradStudent.displayInfo();
    }
}

// Base Animal class
class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound");
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
}

// Dog class inheriting from Animal
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Breed: " + breed);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball");
    }
    
    public String getBreed() { return breed; }
}

// Cat class inheriting from Animal
class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor cat: " + isIndoor);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    public void climb() {
        System.out.println(name + " is climbing a tree");
    }
    
    public boolean isIndoor() { return isIndoor; }
}

// Vehicle hierarchy
class Vehicle {
    protected String name;
    protected int wheels;
    
    public Vehicle(String name, int wheels) {
        this.name = name;
        this.wheels = wheels;
    }
    
    public void start() {
        System.out.println(name + " is starting");
    }
    
    public void stop() {
        System.out.println(name + " is stopping");
    }
    
    public void accelerate() {
        System.out.println(name + " is accelerating");
    }
    
    public String getName() { return name; }
    public int getWheels() { return wheels; }
}

class Car extends Vehicle {
    public Car(String name, int wheels) {
        super(name, wheels);
    }
    
    @Override
    public void start() {
        System.out.println("Car " + name + " engine started");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Car " + name + " is accelerating smoothly");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String name, int wheels) {
        super(name, wheels);
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle " + name + " engine roared to life");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Motorcycle " + name + " is accelerating rapidly");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String name, int wheels) {
        super(name, wheels);
    }
    
    @Override
    public void start() {
        System.out.println("Bicycle " + name + " rider started pedaling");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Bicycle " + name + " rider is pedaling faster");
    }
    
    @Override
    public void stop() {
        System.out.println("Bicycle " + name + " brakes applied");
    }
}

// Abstract Shape class
abstract class Shape {
    protected String color;
    
    public Shape() {
        this.color = "Unknown";
    }
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract methods must be implemented by subclasses
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void displayInfo();
    
    // Concrete method available to all subclasses
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Red"); // Default color for circles
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Circle - Radius: " + radius + ", Color: " + color);
    }
    
    public double getRadius() { return radius; }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        super("Blue"); // Default color for rectangles
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Rectangle - Length: " + length + 
                          ", Width: " + width + ", Color: " + color);
    }
    
    public double getLength() { return length; }
    public double getWidth() { return width; }
}

class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        super("Green"); // Default color for triangles
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public double calculatePerimeter() {
        // Assuming equilateral triangle for simplicity
        return 3 * base;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Triangle - Base: " + base + 
                          ", Height: " + height + ", Color: " + color);
    }
    
    public double getBase() { return base; }
    public double getHeight() { return height; }
}

// Employee hierarchy
class Employee {
    protected String name;
    protected double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public void work() {
        System.out.println(name + " is working");
    }
    
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

class Manager extends Employee {
    private String department;
    private int teamSize;
    
    public Manager(String name, double salary, String department, int teamSize) {
        super(name, salary);
        this.department = department;
        this.teamSize = teamSize;
    }
    
    @Override
    public void work() {
        System.out.println("Manager " + name + " is managing the " + department + " department");
    }
    
    public String getDepartment() { return department; }
    public int getTeamSize() { return teamSize; }
}

class Developer extends Employee {
    private String programmingLanguage;
    private int experience;
    
    public Developer(String name, double salary, String programmingLanguage, int experience) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
        this.experience = experience;
    }
    
    @Override
    public void work() {
        System.out.println("Developer " + name + " is coding in " + programmingLanguage);
    }
    
    public String getProgrammingLanguage() { return programmingLanguage; }
    public int getExperience() { return experience; }
}

class Designer extends Employee {
    private String designType;
    private int experience;
    
    public Designer(String name, double salary, String designType, int experience) {
        super(name, salary);
        this.designType = designType;
        this.experience = experience;
    }
    
    @Override
    public void work() {
        System.out.println("Designer " + name + " is creating " + designType + " designs");
    }
    
    public String getDesignType() { return designType; }
    public int getExperience() { return experience; }
}

// Student hierarchy for constructor inheritance
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called for: " + name);
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
}

class Student extends Person {
    protected String studentId;
    protected String major;
    
    public Student(String name, int age, String studentId, String major) {
        super(name, age); // Must be first statement
        this.studentId = studentId;
        this.major = major;
        System.out.println("Student constructor called for: " + name);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId + ", Major: " + major);
    }
    
    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }
}

class GraduateStudent extends Student {
    private String researchArea;
    private String advisor;
    
    public GraduateStudent(String name, int age, String studentId, String major,
                          String researchArea, String advisor) {
        super(name, age, studentId, major);
        this.researchArea = researchArea;
        this.advisor = advisor;
        System.out.println("GraduateStudent constructor called for: " + name);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Area: " + researchArea + ", Advisor: " + advisor);
    }
    
    public String getResearchArea() { return researchArea; }
    public String getAdvisor() { return advisor; }
}

class UndergraduateStudent extends Student {
    private int year;
    
    public UndergraduateStudent(String name, int age, String studentId, String major, int year) {
        super(name, age, studentId, major);
        this.year = year;
        System.out.println("UndergraduateStudent constructor called for: " + name);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Year: " + year);
    }
    
    public int getYear() { return year; }
}