/**
 * Arrays Fundamentals - Comprehensive Examples
 * 
 * This program demonstrates array operations including:
 * - Array declaration and initialization
 * - Single and multi-dimensional arrays
 * - Array manipulation and common algorithms
 * - Array utilities and best practices
 * 
 * @author Bishal Goutam
 * @since Java 21
 */
import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemo {
    
    public static void main(String[] args) {
        var demo = new ArraysDemo();
        
        System.out.println("=== Java Arrays Comprehensive Demo ===\n");
        
        demo.basicArrayOperations();
        demo.arrayInitializationMethods();
        demo.multidimensionalArrays();
        demo.arrayAlgorithms();
        demo.arrayUtilities();
        demo.interactiveArrayDemo();
    }
    
    /**
     * Demonstrates basic array operations
     */
    public void basicArrayOperations() {
        System.out.println("1. Basic Array Operations");
        System.out.println("-".repeat(30));
        
        // Array declaration and initialization
        int[] numbers = {10, 25, 5, 40, 15, 30, 8};
        String[] languages = {"Java", "Python", "JavaScript", "C++", "Go"};
        double[] scores = new double[5];
        
        // Populate scores array
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (i + 1) * 18.5;
        }
        
        System.out.println("Numbers array: " + Arrays.toString(numbers));
        System.out.println("Languages array: " + Arrays.toString(languages));
        System.out.println("Scores array: " + Arrays.toString(scores));
        
        // Array access and modification
        System.out.println("\nArray Access Examples:");
        System.out.println("First number: " + numbers[0]);
        System.out.println("Last language: " + languages[languages.length - 1]);
        
        // Modify array elements
        numbers[0] = 100;
        languages[2] = "TypeScript";
        System.out.println("After modification:");
        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Languages: " + Arrays.toString(languages));
        System.out.println();
    }
    
    /**
     * Shows different array initialization methods
     */
    public void arrayInitializationMethods() {
        System.out.println("2. Array Initialization Methods");
        System.out.println("-".repeat(35));
        
        // Method 1: Direct initialization
        int[] method1 = {1, 2, 3, 4, 5};
        
        // Method 2: Using new keyword
        int[] method2 = new int[]{10, 20, 30, 40, 50};
        
        // Method 3: Declaration then assignment
        int[] method3 = new int[5];
        for (int i = 0; i < method3.length; i++) {
            method3[i] = (i + 1) * 10;
        }
        
        // Method 4: Using Arrays.fill()
        int[] method4 = new int[5];
        Arrays.fill(method4, 99);
        
        System.out.println("Method 1 (direct): " + Arrays.toString(method1));
        System.out.println("Method 2 (new keyword): " + Arrays.toString(method2));
        System.out.println("Method 3 (loop assignment): " + Arrays.toString(method3));
        System.out.println("Method 4 (Arrays.fill): " + Arrays.toString(method4));
        System.out.println();
    }
    
    /**
     * Demonstrates multidimensional arrays
     */
    public void multidimensionalArrays() {
        System.out.println("3. Multidimensional Arrays");
        System.out.println("-".repeat(30));
        
        // 2D Array - Matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D Matrix:");
        printMatrix(matrix);
        
        // 3D Array
        int[][][] cube = new int[2][3][3];
        int value = 1;
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = value++;
                }
            }
        }
        
        System.out.println("\n3D Cube:");
        for (int i = 0; i < cube.length; i++) {
            System.out.println("Layer " + i + ":");
            printMatrix(cube[i]);
        }
        
        // Jagged Array
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Row " + i + ": " + Arrays.toString(jaggedArray[i]));
        }
        System.out.println();
    }
    
    /**
     * Demonstrates common array algorithms
     */
    public void arrayAlgorithms() {
        System.out.println("4. Array Algorithms");
        System.out.println("-".repeat(25));
        
        int[] data = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("Original array: " + Arrays.toString(data));
        
        // Find maximum and minimum
        int max = findMax(data);
        int min = findMin(data);
        System.out.println("Maximum: " + max + ", Minimum: " + min);
        
        // Calculate sum and average
        int sum = calculateSum(data);
        double average = (double) sum / data.length;
        System.out.println("Sum: " + sum + ", Average: " + String.format("%.2f", average));
        
        // Search algorithms
        int target = 25;
        int linearResult = linearSearch(data, target);
        System.out.println("Linear search for " + target + ": " + 
                          (linearResult != -1 ? "Found at index " + linearResult : "Not found"));
        
        // Sort and binary search
        int[] sortedData = data.clone();
        bubbleSort(sortedData);
        System.out.println("Sorted array: " + Arrays.toString(sortedData));
        
        int binaryResult = binarySearch(sortedData, target);
        System.out.println("Binary search for " + target + ": " + 
                          (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));
        
        // Reverse array
        int[] reversed = reverseArray(data.clone());
        System.out.println("Reversed array: " + Arrays.toString(reversed));
        System.out.println();
    }
    
    /**
     * Shows Java array utility methods
     */
    public void arrayUtilities() {
        System.out.println("5. Array Utilities");
        System.out.println("-".repeat(20));
        
        int[] original = {5, 2, 8, 1, 9, 3};
        System.out.println("Original: " + Arrays.toString(original));
        
        // Arrays.sort()
        int[] sorted = original.clone();
        Arrays.sort(sorted);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        
        // Arrays.binarySearch()
        int index = Arrays.binarySearch(sorted, 8);
        System.out.println("Binary search for 8: index " + index);
        
        // Arrays.equals()
        int[] copy = original.clone();
        System.out.println("Arrays equal: " + Arrays.equals(original, copy));
        
        // Arrays.fill()
        int[] filled = new int[5];
        Arrays.fill(filled, 42);
        System.out.println("Filled array: " + Arrays.toString(filled));
        
        // Arrays.copyOf() and Arrays.copyOfRange()
        int[] copyOf = Arrays.copyOf(original, 3);
        int[] copyRange = Arrays.copyOfRange(original, 1, 4);
        System.out.println("Copy of first 3: " + Arrays.toString(copyOf));
        System.out.println("Copy range [1,4): " + Arrays.toString(copyRange));
        System.out.println();
    }
    
    /**
     * Interactive demo for user input
     */
    public void interactiveArrayDemo() {
        System.out.println("6. Interactive Array Demo");
        System.out.println("-".repeat(28));
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        
        int[] userArray = new int[size];
        System.out.println("Enter " + size + " numbers:");
        
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            userArray[i] = scanner.nextInt();
        }
        
        System.out.println("\nYour array: " + Arrays.toString(userArray));
        System.out.println("Sum: " + calculateSum(userArray));
        System.out.println("Average: " + String.format("%.2f", 
                          (double) calculateSum(userArray) / userArray.length));
        System.out.println("Max: " + findMax(userArray));
        System.out.println("Min: " + findMin(userArray));
        
        Arrays.sort(userArray);
        System.out.println("Sorted: " + Arrays.toString(userArray));
    }
    
    // Helper methods for algorithms
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }
    
    private int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    private int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    private int calculateSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
    
    private int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    private int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    private int[] reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }
}