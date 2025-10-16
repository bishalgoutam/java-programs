package fundamentals.methods;

/**
 * Methods Fundamentals - Comprehensive Examples
 * 
 * This program demonstrates Java methods including:
 * - Method declaration and calling
 * - Parameter passing (by value, by reference)
 * - Method overloading
 * - Variable arguments (varargs)
 * - Static vs instance methods
 * - Recursive methods
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
import java.util.Arrays;

public class MethodsDemo {
    
    // Instance variables for demonstration
    private String name;
    private int count;
    
    // Constructor
    public MethodsDemo(String name) {
        this.name = name;
        this.count = 0;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Java Methods Comprehensive Demo ===\n");
        
        // Create instance for instance method demonstrations
        MethodsDemo demo = new MethodsDemo("MethodsDemo");
        System.out.println("Created demo instance: " + demo.name + " (call count: " + demo.count + ")\n");
        
        demo.basicMethodConcepts();
        demo.parameterPassingDemo();
        demo.methodOverloadingDemo();
        demo.varargsDemo();
        staticMethodsDemo();
        demo.recursiveMethodsDemo();
        demo.practicalMethodExamples();
    }
    
    /**
     * Demonstrates basic method concepts
     */
    public void basicMethodConcepts() {
        count++; // Increment method call counter
        System.out.println("1. Basic Method Concepts");
        System.out.println("-".repeat(28));
        
        // Method with no parameters and no return value
        greetUser();
        
        // Method with parameters and return value
        int result = addNumbers(15, 25);
        System.out.println("15 + 25 = " + result);
        
        // Method with multiple parameters
        String fullName = createFullName("John", "Doe", "Smith");
        System.out.println("Full name: " + fullName);
        
        // Method returning different data types
        double area = calculateCircleArea(5.0);
        boolean isEven = isEvenNumber(42);
        String status = getStatus(85);
        
        System.out.println("Circle area (radius 5): " + String.format("%.2f", area));
        System.out.println("Is 42 even? " + isEven);
        System.out.println("Status for score 85: " + status);
        System.out.println();
    }
    
    /**
     * Demonstrates parameter passing mechanisms
     */
    public void parameterPassingDemo() {
        System.out.println("2. Parameter Passing");
        System.out.println("-".repeat(24));
        
        // Primitive parameters (pass by value)
        int number = 10;
        System.out.println("Before modifyPrimitive: " + number);
        modifyPrimitive(number);
        System.out.println("After modifyPrimitive: " + number);
        
        // Object parameters (pass by reference)
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Before modifyArray: " + Arrays.toString(array));
        modifyArray(array);
        System.out.println("After modifyArray: " + Arrays.toString(array));
        
        // String parameters (special case - immutable)
        String text = "Hello";
        System.out.println("Before modifyString: " + text);
        modifyString(text);
        System.out.println("After modifyString: " + text);
        
        // Demonstration with custom object
        Person person = new Person("Alice", 25);
        System.out.println("Before modifyPerson: " + person);
        modifyPerson(person);
        System.out.println("After modifyPerson: " + person);
        System.out.println();
    }
    
    /**
     * Demonstrates method overloading
     */
    public void methodOverloadingDemo() {
        System.out.println("3. Method Overloading");
        System.out.println("-".repeat(25));
        
        // Different number of parameters
        System.out.println("calculate(5): " + calculate(5));
        System.out.println("calculate(5, 3): " + calculate(5, 3));
        System.out.println("calculate(5, 3, 2): " + calculate(5, 3, 2));
        
        // Different parameter types
        System.out.println("calculate(5.5): " + calculate(5.5));
        System.out.println("calculate(5.5, 3.2): " + calculate(5.5, 3.2));
        
        // Different parameter order
        displayInfo("John", 25);
        displayInfo(25, "John");
        
        // Array vs individual parameters
        printNumbers(new int[]{1, 2, 3, 4, 5});
        printNumbersVarargs(1, 2, 3, 4, 5);
        System.out.println();
    }
    
    /**
     * Demonstrates variable arguments (varargs)
     */
    public void varargsDemo() {
        System.out.println("4. Variable Arguments (Varargs)");
        System.out.println("-".repeat(35));
        
        // Varargs with different number of arguments
        System.out.println("Sum of no numbers: " + sum());
        System.out.println("Sum of one number: " + sum(5));
        System.out.println("Sum of multiple numbers: " + sum(1, 2, 3, 4, 5));
        System.out.println("Sum of array: " + sum(10, 20, 30));
        
        // Varargs with other parameters
        String result1 = formatMessage("Hello", "John", "Alice", "Bob");
        String result2 = formatMessage("Welcome", "Guest");
        System.out.println(result1);
        System.out.println(result2);
        
        // Mixed parameters with varargs
        double average1 = calculateAverage("Math", 85, 90, 78, 92);
        double average2 = calculateAverage("Science", 88, 91, 87);
        System.out.printf("Math average: %.2f%n", average1);
        System.out.printf("Science average: %.2f%n", average2);
        System.out.println();
    }
    
    /**
     * Demonstrates static methods
     */
    public static void staticMethodsDemo() {
        System.out.println("5. Static Methods");
        System.out.println("-".repeat(20));
        
        // Static utility methods
        System.out.println("Math utilities:");
        System.out.println("Max of 10, 20, 15: " + MathUtils.max(10, 20, 15));
        System.out.println("Factorial of 5: " + MathUtils.factorial(5));
        System.out.println("Is 17 prime? " + MathUtils.isPrime(17));
        System.out.println("GCD of 48, 18: " + MathUtils.gcd(48, 18));
        
        // Static methods for string utilities
        System.out.println("\nString utilities:");
        System.out.println("Reverse 'Hello': " + StringUtils.reverse("Hello"));
        System.out.println("Is 'racecar' palindrome? " + StringUtils.isPalindrome("racecar"));
        System.out.println("Count vowels in 'Education': " + StringUtils.countVowels("Education"));
        System.out.println();
    }
    
    /**
     * Demonstrates recursive methods
     */
    public void recursiveMethodsDemo() {
        System.out.println("6. Recursive Methods");
        System.out.println("-".repeat(24));
        
        // Simple recursion examples
        System.out.println("Factorial of 6: " + factorial(6));
        System.out.println("Fibonacci of 8: " + fibonacci(8));
        System.out.println("Power 2^10: " + power(2, 10));
        
        // String manipulation with recursion
        System.out.println("Reverse 'Programming': " + reverseString("Programming"));
        
        // Array operations with recursion
        int[] numbers = {3, 7, 2, 9, 1, 5, 8};
        System.out.println("Sum of array: " + sumArray(numbers, 0));
        System.out.println("Max in array: " + findMax(numbers, 0, numbers[0]));
        
        // Tree-like recursion
        System.out.println("Binary representation of 25: " + toBinary(25));
        System.out.println();
    }
    
    /**
     * Practical examples using methods
     */
    public void practicalMethodExamples() {
        System.out.println("7. Practical Method Examples");
        System.out.println("-".repeat(32));
        
        // Grade calculator
        double[] grades = {85.5, 92.0, 78.5, 90.0, 87.5};
        System.out.println("Grades: " + Arrays.toString(grades));
        System.out.printf("Average: %.2f%n", calculateAverage(grades));
        System.out.println("Letter grade: " + getLetterGrade(calculateAverage(grades)));
        
        // Temperature converter
        double celsius = 25.0;
        System.out.printf("%.1f°C = %.1f°F%n", celsius, celsiusToFahrenheit(celsius));
        System.out.printf("%.1f°C = %.1f K%n", celsius, celsiusToKelvin(celsius));
        
        // Validation methods
        String email = "user@example.com";
        String phone = "123-456-7890";
        System.out.println("Is '" + email + "' valid email? " + isValidEmail(email));
        System.out.println("Is '" + phone + "' valid phone? " + isValidPhone(phone));
        
        // Array utilities
        int[] data = {5, 2, 8, 1, 9, 3};
        System.out.println("Original array: " + Arrays.toString(data));
        System.out.println("Sorted array: " + Arrays.toString(bubbleSort(data.clone())));
        System.out.println("Search for 8: index " + linearSearch(data, 8));
    }
    
    // Basic method examples
    private void greetUser() {
        System.out.println("Hello! Welcome to Java Methods Demo");
    }
    
    private int addNumbers(int a, int b) {
        return a + b;
    }
    
    private String createFullName(String first, String middle, String last) {
        return first + " " + middle + " " + last;
    }
    
    private double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
    
    private String getStatus(int score) {
        if (score >= 90) return "Excellent";
        else if (score >= 80) return "Good";
        else if (score >= 70) return "Satisfactory";
        else return "Needs Improvement";
    }
    
    // Parameter passing examples
    private void modifyPrimitive(int number) {
        number = 100; // This won't affect the original variable
        System.out.println("Inside modifyPrimitive: " + number);
    }
    
    private void modifyArray(int[] array) {
        array[0] = 99; // This will modify the original array
        System.out.println("Inside modifyArray: " + Arrays.toString(array));
    }
    
    private void modifyString(String text) {
        text = "Modified"; // This won't affect the original string
        System.out.println("Inside modifyString: " + text);
    }
    
    private void modifyPerson(Person person) {
        person.setAge(30); // This will modify the original object
        System.out.println("Inside modifyPerson: " + person);
    }
    
    // Method overloading examples
    private int calculate(int a) {
        return a * a; // Square
    }
    
    private int calculate(int a, int b) {
        return a + b; // Addition
    }
    
    private int calculate(int a, int b, int c) {
        return a + b + c; // Sum of three
    }
    
    private double calculate(double a) {
        return a * a; // Square of double
    }
    
    private double calculate(double a, double b) {
        return a * b; // Multiplication
    }
    
    private void displayInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    private void displayInfo(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
    
    private void printNumbers(int[] numbers) {
        System.out.print("Array version: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    private void printNumbersVarargs(int... numbers) {
        System.out.print("Varargs version: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Varargs examples
    private int sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
    
    private String formatMessage(String prefix, String... names) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append(": ");
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]);
            if (i < names.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    private double calculateAverage(String subject, int... scores) {
        if (scores.length == 0) return 0;
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    
    // Recursive methods
    private long factorial(int n) {
        if (n <= 1) {
            return 1; // Base case
        }
        return n * factorial(n - 1); // Recursive case
    }
    
    private int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base case
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }
    
    private long power(int base, int exponent) {
        if (exponent == 0) {
            return 1; // Base case
        }
        return base * power(base, exponent - 1); // Recursive case
    }
    
    private String reverseString(String str) {
        if (str.length() <= 1) {
            return str; // Base case
        }
        return reverseString(str.substring(1)) + str.charAt(0); // Recursive case
    }
    
    private int sumArray(int[] array, int index) {
        if (index >= array.length) {
            return 0; // Base case
        }
        return array[index] + sumArray(array, index + 1); // Recursive case
    }
    
    private int findMax(int[] array, int index, int currentMax) {
        if (index >= array.length) {
            return currentMax; // Base case
        }
        int newMax = Math.max(currentMax, array[index]);
        return findMax(array, index + 1, newMax); // Recursive case
    }
    
    private String toBinary(int number) {
        if (number == 0) {
            return "0"; // Base case
        }
        if (number == 1) {
            return "1"; // Base case
        }
        return toBinary(number / 2) + (number % 2); // Recursive case
    }
    
    // Practical utility methods
    private double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
    
    private String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
    
    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
    
    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }
    
    private int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
    
    private int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // Helper classes
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + " (age: " + age + ")";
        }
    }
    
    // Static utility classes
    static class MathUtils {
        public static int max(int... numbers) {
            int maximum = numbers[0];
            for (int number : numbers) {
                if (number > maximum) {
                    maximum = number;
                }
            }
            return maximum;
        }
        
        public static long factorial(int n) {
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
        
        public static boolean isPrime(int number) {
            if (number < 2) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
        
        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }
    
    static class StringUtils {
        public static String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }
        
        public static boolean isPalindrome(String str) {
            String cleaned = str.toLowerCase().replaceAll("[^a-z]", "");
            return cleaned.equals(reverse(cleaned));
        }
        
        public static int countVowels(String str) {
            int count = 0;
            String vowels = "aeiouAEIOU";
            for (char c : str.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    count++;
                }
            }
            return count;
        }
    }
}