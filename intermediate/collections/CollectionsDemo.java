/**
 * Collections Framework - Comprehensive Examples
 * 
 * This program demonstrates Java Collections Framework:
 * - List implementations (ArrayList, LinkedList, Vector)
 * - Set implementations (HashSet, LinkedHashSet, TreeSet)
 * - Map implementations (HashMap, LinkedHashMap, TreeMap)
 * - Queue implementations (PriorityQueue, ArrayDeque)
 * - Collections utility methods and algorithms
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
import java.util.*;

public class CollectionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java Collections Framework Demo ===\n");
        
        demonstrateArrayList();
        demonstrateLinkedList();
        demonstrateHashSet();
        demonstrateTreeSet();
        demonstrateHashMap();
        demonstrateTreeMap();
        demonstratePriorityQueue();
        demonstrateCollectionsUtility();
        practicalCollectionsExample();
    }
    
    /**
     * Demonstrates ArrayList operations
     */
    public static void demonstrateArrayList() {
        System.out.println("1. ArrayList Demo");
        System.out.println("-".repeat(20));
        
        // Create and populate ArrayList
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Mango");
        
        System.out.println("Original list: " + fruits);
        System.out.println("Size: " + fruits.size());
        
        // Access elements
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Last fruit: " + fruits.get(fruits.size() - 1));
        
        // Modify elements
        fruits.set(1, "Blueberry");
        System.out.println("After replacing Banana: " + fruits);
        
        // Insert at specific position
        fruits.add(2, "Cherry");
        System.out.println("After inserting Cherry: " + fruits);
        
        // Search operations
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        System.out.println("Index of Orange: " + fruits.indexOf("Orange"));
        
        // Remove elements
        fruits.remove("Grape");
        fruits.remove(0); // Remove by index
        System.out.println("After removals: " + fruits);
        
        // Iterate through list
        System.out.print("Iteration: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");
    }
    
    /**
     * Demonstrates LinkedList operations
     */
    public static void demonstrateLinkedList() {
        System.out.println("2. LinkedList Demo");
        System.out.println("-".repeat(21));
        
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.addFirst(5);  // Add at beginning
        numbers.addLast(40);  // Add at end
        
        System.out.println("LinkedList: " + numbers);
        
        // Queue operations
        System.out.println("First element (peek): " + numbers.peekFirst());
        System.out.println("Last element (peek): " + numbers.peekLast());
        
        // Stack operations
        numbers.push(1); // Add to front
        System.out.println("After push(1): " + numbers);
        
        Integer popped = numbers.pop(); // Remove from front
        System.out.println("Popped element: " + popped);
        System.out.println("After pop: " + numbers);
        
        // Deque operations
        numbers.offerFirst(2);
        numbers.offerLast(50);
        System.out.println("After offer operations: " + numbers);
        
        System.out.println("Poll first: " + numbers.pollFirst());
        System.out.println("Poll last: " + numbers.pollLast());
        System.out.println("Final list: " + numbers);
        System.out.println();
    }
    
    /**
     * Demonstrates HashSet operations
     */
    public static void demonstrateHashSet() {
        System.out.println("3. HashSet Demo");
        System.out.println("-".repeat(18));
        
        Set<String> colors = new HashSet<>();
        
        // Add elements (duplicates ignored)
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red");    // Duplicate - will be ignored
        colors.add("Yellow");
        
        System.out.println("HashSet (no order guaranteed): " + colors);
        System.out.println("Size: " + colors.size());
        
        // Check operations
        System.out.println("Contains Red: " + colors.contains("Red"));
        System.out.println("Contains Purple: " + colors.contains("Purple"));
        
        // Set operations
        Set<String> moreColors = Set.of("Purple", "Orange", "Red", "Pink");
        System.out.println("More colors: " + moreColors);
        
        // Union (add all)
        Set<String> union = new HashSet<>(colors);
        union.addAll(moreColors);
        System.out.println("Union: " + union);
        
        // Intersection (retain all)
        Set<String> intersection = new HashSet<>(colors);
        intersection.retainAll(moreColors);
        System.out.println("Intersection: " + intersection);
        
        // Difference (remove all)
        Set<String> difference = new HashSet<>(colors);
        difference.removeAll(moreColors);
        System.out.println("Difference: " + difference);
        System.out.println();
    }
    
    /**
     * Demonstrates TreeSet operations (sorted set)
     */
    public static void demonstrateTreeSet() {
        System.out.println("4. TreeSet Demo");
        System.out.println("-".repeat(18));
        
        TreeSet<Integer> numbers = new TreeSet<>();
        
        // Add elements (automatically sorted)
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(30);
        numbers.add(70);
        
        System.out.println("TreeSet (sorted): " + numbers);
        
        // NavigableSet operations
        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());
        System.out.println("Lower than 50: " + numbers.lower(50));
        System.out.println("Higher than 50: " + numbers.higher(50));
        System.out.println("Floor of 45: " + numbers.floor(45));
        System.out.println("Ceiling of 45: " + numbers.ceiling(45));
        
        // Range operations
        System.out.println("Elements between 20 and 70: " + 
                          numbers.subSet(20, true, 70, true));
        System.out.println("Head set (< 50): " + numbers.headSet(50));
        System.out.println("Tail set (>= 50): " + numbers.tailSet(50));
        
        // Custom sorting with String
        TreeSet<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        names.addAll(Arrays.asList("Alice", "bob", "Charlie", "diana", "Eve"));
        System.out.println("Case-insensitive sorted names: " + names);
        System.out.println();
    }
    
    /**
     * Demonstrates HashMap operations
     */
    public static void demonstrateHashMap() {
        System.out.println("5. HashMap Demo");
        System.out.println("-".repeat(18));
        
        Map<String, Integer> studentGrades = new HashMap<>();
        
        // Add key-value pairs
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);
        studentGrades.put("Diana", 96);
        studentGrades.put("Eve", 89);
        
        System.out.println("Student grades: " + studentGrades);
        
        // Access operations
        System.out.println("Alice's grade: " + studentGrades.get("Alice"));
        System.out.println("Frank's grade: " + studentGrades.get("Frank")); // null
        System.out.println("Frank's grade (with default): " + 
                          studentGrades.getOrDefault("Frank", 0));
        
        // Check operations
        System.out.println("Contains key 'Bob': " + studentGrades.containsKey("Bob"));
        System.out.println("Contains value 96: " + studentGrades.containsValue(96));
        
        // Update operations
        studentGrades.put("Alice", 90); // Update existing
        studentGrades.putIfAbsent("Frank", 75); // Add if not present
        System.out.println("After updates: " + studentGrades);
        
        // Iterate through map
        System.out.println("Iteration methods:");
        
        // Method 1: Key set
        System.out.print("Keys: ");
        for (String key : studentGrades.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        
        // Method 2: Values
        System.out.print("Values: ");
        for (Integer value : studentGrades.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Method 3: Entry set
        System.out.println("Key-Value pairs:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates TreeMap operations (sorted map)
     */
    public static void demonstrateTreeMap() {
        System.out.println("6. TreeMap Demo");
        System.out.println("-".repeat(18));
        
        TreeMap<Integer, String> monthNames = new TreeMap<>();
        
        // Add entries (will be sorted by key)
        monthNames.put(12, "December");
        monthNames.put(1, "January");
        monthNames.put(6, "June");
        monthNames.put(3, "March");
        monthNames.put(9, "September");
        
        System.out.println("Months (sorted by key): " + monthNames);
        
        // NavigableMap operations
        System.out.println("First key: " + monthNames.firstKey());
        System.out.println("Last key: " + monthNames.lastKey());
        System.out.println("Lower key than 6: " + monthNames.lowerKey(6));
        System.out.println("Higher key than 6: " + monthNames.higherKey(6));
        
        // Range operations
        System.out.println("SubMap (3 to 9): " + monthNames.subMap(3, true, 9, true));
        System.out.println("Head map (< 6): " + monthNames.headMap(6));
        System.out.println("Tail map (>= 6): " + monthNames.tailMap(6));
        
        // Reverse order
        NavigableMap<Integer, String> reverseMonths = monthNames.descendingMap();
        System.out.println("Reverse order: " + reverseMonths);
        System.out.println();
    }
    
    /**
     * Demonstrates PriorityQueue operations
     */
    public static void demonstratePriorityQueue() {
        System.out.println("7. PriorityQueue Demo");
        System.out.println("-".repeat(24));
        
        // Default priority queue (min heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(Arrays.asList(30, 10, 50, 20, 40));
        
        System.out.println("PriorityQueue elements: " + minHeap);
        System.out.print("Polling elements (min first): ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
        
        // Max heap using custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(30, 10, 50, 20, 40));
        
        System.out.print("Max heap polling: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // Priority queue with custom objects
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(
            Comparator.comparingInt(Task::getPriority).reversed()
        );
        
        taskQueue.add(new Task("Low priority task", 1));
        taskQueue.add(new Task("High priority task", 5));
        taskQueue.add(new Task("Medium priority task", 3));
        taskQueue.add(new Task("Critical task", 10));
        
        System.out.println("Task execution order (by priority):");
        while (!taskQueue.isEmpty()) {
            System.out.println("  " + taskQueue.poll());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates Collections utility methods
     */
    public static void demonstrateCollectionsUtility() {
        System.out.println("8. Collections Utility Methods");
        System.out.println("-".repeat(35));
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));
        System.out.println("Original list: " + numbers);
        
        // Sorting
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
        
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse sorted: " + numbers);
        
        // Searching
        Collections.sort(numbers); // Must be sorted for binary search
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Binary search for 5: index " + index);
        
        // Shuffling
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);
        
        // Min and Max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));
        
        // Frequency
        numbers.addAll(Arrays.asList(5, 5, 5));
        System.out.println("With duplicates: " + numbers);
        System.out.println("Frequency of 5: " + Collections.frequency(numbers, 5));
        
        // Fill and replace
        List<String> words = new ArrayList<>(Arrays.asList("hello", "world", "java", "hello"));
        System.out.println("Words: " + words);
        Collections.replaceAll(words, "hello", "hi");
        System.out.println("After replace: " + words);
        
        Collections.fill(words, "test");
        System.out.println("After fill: " + words);
        
        // Reverse and rotate
        List<Character> chars = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        System.out.println("Original chars: " + chars);
        
        Collections.reverse(chars);
        System.out.println("Reversed: " + chars);
        
        Collections.rotate(chars, 2);
        System.out.println("Rotated by 2: " + chars);
        System.out.println();
    }
    
    /**
     * Practical example combining multiple collections
     */
    public static void practicalCollectionsExample() {
        System.out.println("9. Practical Example: Student Management");
        System.out.println("-".repeat(44));
        
        // Use different collections for different purposes
        List<Student> students = new ArrayList<>();
        Set<String> majors = new TreeSet<>(); // Sorted unique majors
        Map<String, List<Student>> studentsByMajor = new HashMap<>();
        Queue<Student> graduationQueue = new PriorityQueue<>(
            Comparator.comparingDouble(Student::getGpa).reversed()
        );
        
        // Add students
        students.add(new Student("Alice", "Computer Science", 3.8));
        students.add(new Student("Bob", "Mathematics", 3.6));
        students.add(new Student("Charlie", "Computer Science", 3.9));
        students.add(new Student("Diana", "Physics", 3.7));
        students.add(new Student("Eve", "Mathematics", 3.5));
        students.add(new Student("Frank", "Computer Science", 3.4));
        
        // Collect majors and group students
        for (Student student : students) {
            majors.add(student.getMajor());
            
            studentsByMajor.computeIfAbsent(student.getMajor(), k -> new ArrayList<>())
                          .add(student);
            
            if (student.getGpa() >= 3.5) {
                graduationQueue.offer(student);
            }
        }
        
        // Display results
        System.out.println("All majors: " + majors);
        System.out.println("Total students: " + students.size());
        
        System.out.println("\nStudents by major:");
        for (Map.Entry<String, List<Student>> entry : studentsByMajor.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " students");
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
        
        System.out.println("\nGraduation queue (by GPA, highest first):");
        while (!graduationQueue.isEmpty()) {
            System.out.println("  " + graduationQueue.poll());
        }
        
        // Statistics using Collections
        List<Double> gpas = new ArrayList<>();
        for (Student student : students) {
            gpas.add(student.getGpa());
        }
        
        double averageGpa = gpas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.printf("\nStatistics:\n");
        System.out.printf("Average GPA: %.2f\n", averageGpa);
        System.out.printf("Highest GPA: %.2f\n", Collections.max(gpas));
        System.out.printf("Lowest GPA: %.2f\n", Collections.min(gpas));
    }
}

/**
 * Task class for PriorityQueue demonstration
 */
class Task {
    private String description;
    private int priority;
    
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }
    
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    
    @Override
    public String toString() {
        return description + " (Priority: " + priority + ")";
    }
}

/**
 * Student class for practical example
 */
class Student {
    private String name;
    private String major;
    private double gpa;
    
    public Student(String name, String major, double gpa) {
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }
    
    public String getName() { return name; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    
    @Override
    public String toString() {
        return name + " (" + major + ", GPA: " + gpa + ")";
    }
}