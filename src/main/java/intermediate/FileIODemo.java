package intermediate;

/**
 * File I/O Demo
 * 
 * Comprehensive demonstration of file input/output operations in Java including:
 * - Character streams (Reader/Writer)
 * - Byte streams (InputStream/OutputStream)
 * - Buffered I/O for performance
 * - Try-with-resources for proper resource management
 * - File and directory operations
 * - Serialization and deserialization
 * - Modern NIO.2 API (java.nio.file)
 */

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Serializable class for demonstration
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int id;
    private double gpa;
    private transient String password; // transient field won't be serialized
    
    public Student(String name, int id, double gpa, String password) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.password = password;
    }
    
    // Getters
    public String getName() { return name; }
    public int getId() { return id; }
    public double getGpa() { return gpa; }
    public String getPassword() { return password; }
    
    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', gpa=%.2f, password=%s}", 
                           id, name, gpa, password != null ? "'***'" : "null");
    }
}

// Custom file utilities
class FileUtils {
    
    /**
     * Read entire file content as string using modern NIO.2 API
     */
    public static String readFileAsString(Path filePath) throws IOException {
        return Files.readString(filePath, StandardCharsets.UTF_8);
    }
    
    /**
     * Write string content to file using NIO.2 API
     */
    public static void writeStringToFile(Path filePath, String content) throws IOException {
        Files.writeString(filePath, content, StandardCharsets.UTF_8, 
                         StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
    
    /**
     * Copy file using NIO.2 API
     */
    public static void copyFile(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
    
    /**
     * Get file information
     */
    public static void printFileInfo(Path filePath) throws IOException {
        if (Files.exists(filePath)) {
            System.out.println("File: " + filePath.getFileName());
            System.out.println("Size: " + Files.size(filePath) + " bytes");
            System.out.println("Last Modified: " + Files.getLastModifiedTime(filePath));
            System.out.println("Readable: " + Files.isReadable(filePath));
            System.out.println("Writable: " + Files.isWritable(filePath));
            System.out.println("Directory: " + Files.isDirectory(filePath));
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }
}

// Log file manager
class LogManager {
    private final Path logFile;
    
    public LogManager(String logFileName) {
        this.logFile = Paths.get(logFileName);
        createLogFileIfNotExists();
    }
    
    private void createLogFileIfNotExists() {
        try {
            if (!Files.exists(logFile)) {
                Files.createFile(logFile);
                System.out.println("Created log file: " + logFile);
            }
        } catch (IOException e) {
            System.err.println("Failed to create log file: " + e.getMessage());
        }
    }
    
    public void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String logEntry = String.format("[%s] %s: %s%n", timestamp, level, message);
        
        try (BufferedWriter writer = Files.newBufferedWriter(logFile, 
             StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
    
    public void info(String message) { log("INFO", message); }
    public void warn(String message) { log("WARN", message); }
    public void error(String message) { log("ERROR", message); }
    
    public void readLogFile() {
        try {
            System.out.println("=== Log File Contents ===");
            List<String> lines = Files.readAllLines(logFile, StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Failed to read log file: " + e.getMessage());
        }
    }
}

public class FileIODemo {
    
    public static void main(String[] args) {
        System.out.println("=== File I/O Demonstrations ===\n");
        
        try {
            demonstrateBasicFileOperations();
            demonstrateCharacterStreams();
            demonstrateByteStreams();
            demonstrateBufferedIO();
            demonstrateNIOFileOperations();
            demonstrateDirectoryOperations();
            demonstrateSerialization();
            demonstrateCSVFileProcessing();
            demonstrateLogFileManagement();
            demonstrateFileWatching();
            
        } catch (Exception e) {
            System.err.println("Demo failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            cleanupDemoFiles();
        }
    }
    
    /**
     * 1. Basic File Operations
     */
    private static void demonstrateBasicFileOperations() throws IOException {
        System.out.println("1. Basic File Operations");
        System.out.println("-".repeat(40));
        
        // Create a test file
        String fileName = "basic-test.txt";
        String content = "Hello, File I/O!\nThis is a test file.\nWith multiple lines.";
        
        // Write to file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("✓ File written: " + fileName);
        }
        
        // Read from file
        try (FileReader reader = new FileReader(fileName)) {
            StringBuilder fileContent = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                fileContent.append((char) character);
            }
            System.out.println("✓ File content read:");
            System.out.println(fileContent.toString());
        }
        
        // Check file properties
        File file = new File(fileName);
        System.out.println("✓ File exists: " + file.exists());
        System.out.println("✓ File size: " + file.length() + " bytes");
        System.out.println("✓ Can read: " + file.canRead());
        System.out.println("✓ Can write: " + file.canWrite());
        
        System.out.println();
    }
    
    /**
     * 2. Character Streams (Reader/Writer)
     */
    private static void demonstrateCharacterStreams() throws IOException {
        System.out.println("2. Character Streams");
        System.out.println("-".repeat(40));
        
        String fileName = "character-streams-test.txt";
        
        // Writing with PrintWriter
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("=== Character Streams Demo ===");
            writer.println("Line 1: Hello World");
            writer.printf("Line 2: Number = %d, Float = %.2f%n", 42, 3.14159);
            writer.println("Line 3: Unicode: 🌟 ❤️ 🚀");
            System.out.println("✓ File written using PrintWriter");
        }
        
        // Reading with BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("✓ File content read using BufferedReader:");
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.printf("%2d: %s%n", lineNumber++, line);
            }
        }
        
        System.out.println();
    }
    
    /**
     * 3. Byte Streams (InputStream/OutputStream)
     */
    private static void demonstrateByteStreams() throws IOException {
        System.out.println("3. Byte Streams");
        System.out.println("-".repeat(40));
        
        String sourceFile = "byte-source.dat";
        String targetFile = "byte-target.dat";
        
        // Create binary data
        byte[] data = {0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, // "Hello "
                       0x57, 0x6F, 0x72, 0x6C, 0x64, 0x21}; // "World!"
        
        // Write bytes to file
        try (FileOutputStream fos = new FileOutputStream(sourceFile)) {
            fos.write(data);
            System.out.println("✓ Binary data written to: " + sourceFile);
        }
        
        // Copy file using byte streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("✓ File copied using byte streams: " + targetFile);
        }
        
        // Read and display as text
        try (FileInputStream fis = new FileInputStream(targetFile)) {
            byte[] readData = fis.readAllBytes();
            String text = new String(readData, StandardCharsets.UTF_8);
            System.out.println("✓ Binary data as text: " + text);
        }
        
        System.out.println();
    }
    
    /**
     * 4. Buffered I/O for Performance
     */
    private static void demonstrateBufferedIO() throws IOException {
        System.out.println("4. Buffered I/O Performance");
        System.out.println("-".repeat(40));
        
        String fileName = "performance-test.txt";
        int lineCount = 10000;
        
        // Measure unbuffered write performance
        long startTime = System.nanoTime();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 1; i <= lineCount; i++) {
                writer.write("Line " + i + ": This is a performance test line.\n");
            }
        }
        long unbufferedTime = System.nanoTime() - startTime;
        
        // Measure buffered write performance
        String bufferedFileName = "buffered-performance-test.txt";
        startTime = System.nanoTime();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedFileName))) {
            for (int i = 1; i <= lineCount; i++) {
                writer.write("Line " + i + ": This is a performance test line.\n");
            }
        }
        long bufferedTime = System.nanoTime() - startTime;
        
        System.out.printf("✓ Unbuffered write time: %.2f ms%n", unbufferedTime / 1_000_000.0);
        System.out.printf("✓ Buffered write time: %.2f ms%n", bufferedTime / 1_000_000.0);
        System.out.printf("✓ Performance improvement: %.1fx faster%n", 
                         (double) unbufferedTime / bufferedTime);
        
        // Count lines using buffered reader
        try (BufferedReader reader = new BufferedReader(new FileReader(bufferedFileName))) {
            long lines = reader.lines().count();
            System.out.println("✓ Lines counted: " + lines);
        }
        
        System.out.println();
    }
    
    /**
     * 5. Modern NIO.2 File Operations
     */
    private static void demonstrateNIOFileOperations() throws IOException {
        System.out.println("5. Modern NIO.2 File Operations");
        System.out.println("-".repeat(40));
        
        Path filePath = Paths.get("nio-test.txt");
        String content = "NIO.2 API Demo\nModern file operations\nJava 7+ features";
        
        // Write using NIO.2
        Files.writeString(filePath, content, StandardCharsets.UTF_8);
        System.out.println("✓ File written using NIO.2 API");
        
        // Read using NIO.2
        String readContent = Files.readString(filePath, StandardCharsets.UTF_8);
        System.out.println("✓ File content:");
        System.out.println(readContent);
        
        // File attributes
        FileUtils.printFileInfo(filePath);
        
        // Read all lines
        List<String> lines = Files.readAllLines(filePath);
        System.out.println("✓ All lines:");
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("  %d: %s%n", i + 1, lines.get(i));
        }
        
        // Process lines with streams
        System.out.println("✓ Lines containing 'Java':");
        try (Stream<String> lineStream = Files.lines(filePath)) {
            lineStream.filter(line -> line.contains("Java"))
                     .forEach(line -> System.out.println("  " + line));
        }
        
        System.out.println();
    }
    
    /**
     * 6. Directory Operations
     */
    private static void demonstrateDirectoryOperations() throws IOException {
        System.out.println("6. Directory Operations");
        System.out.println("-".repeat(40));
        
        Path testDir = Paths.get("test-directory");
        Path subDir = testDir.resolve("sub-directory");
        
        // Create directories
        Files.createDirectories(subDir);
        System.out.println("✓ Created directory structure: " + subDir);
        
        // Create files in directories
        Files.writeString(testDir.resolve("file1.txt"), "File 1 content");
        Files.writeString(testDir.resolve("file2.txt"), "File 2 content");
        Files.writeString(subDir.resolve("subfile.txt"), "Sub file content");
        
        // List directory contents
        System.out.println("✓ Directory contents:");
        try (Stream<Path> paths = Files.list(testDir)) {
            paths.forEach(path -> {
                try {
                    String type = Files.isDirectory(path) ? "[DIR]" : "[FILE]";
                    System.out.printf("  %s %s%n", type, path.getFileName());
                } catch (Exception e) {
                    System.err.println("Error checking: " + path);
                }
            });
        }
        
        // Walk directory tree
        System.out.println("✓ All files in tree:");
        try (Stream<Path> paths = Files.walk(testDir)) {
            paths.filter(Files::isRegularFile)
                 .forEach(path -> System.out.println("  " + path));
        }
        
        System.out.println();
    }
    
    /**
     * 7. Object Serialization
     */
    private static void demonstrateSerialization() throws IOException, ClassNotFoundException {
        System.out.println("7. Object Serialization");
        System.out.println("-".repeat(40));
        
        String fileName = "student.ser";
        
        // Create and serialize objects
        List<Student> students = Arrays.asList(
            new Student("Alice Johnson", 101, 3.8, "secret123"),
            new Student("Bob Smith", 102, 3.5, "password456"),
            new Student("Carol Davis", 103, 3.9, "mypassword")
        );
        
        // Serialize to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("✓ Objects serialized to: " + fileName);
        }
        
        // Deserialize from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Student> deserializedStudents = (List<Student>) ois.readObject();
            
            System.out.println("✓ Objects deserialized:");
            for (Student student : deserializedStudents) {
                System.out.println("  " + student);
            }
        }
        
        System.out.println();
    }
    
    /**
     * 8. CSV File Processing
     */
    private static void demonstrateCSVFileProcessing() throws IOException {
        System.out.println("8. CSV File Processing");
        System.out.println("-".repeat(40));
        
        String csvFile = "students.csv";
        
        // Write CSV data
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            writer.println("ID,Name,GPA,Major");
            writer.println("101,Alice Johnson,3.8,Computer Science");
            writer.println("102,Bob Smith,3.5,Mathematics");
            writer.println("103,Carol Davis,3.9,Physics");
            writer.println("104,David Wilson,3.2,Chemistry");
            System.out.println("✓ CSV file created: " + csvFile);
        }
        
        // Read and parse CSV data
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String headerLine = reader.readLine();
            System.out.println("✓ CSV Header: " + headerLine);
            
            System.out.println("✓ Student Records:");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4) {
                    System.out.printf("  ID: %s, Name: %s, GPA: %s, Major: %s%n",
                                    fields[0], fields[1], fields[2], fields[3]);
                }
            }
        }
        
        // Process CSV with streams
        System.out.println("✓ High GPA students (>= 3.7):");
        try (Stream<String> lines = Files.lines(Paths.get(csvFile))) {
            lines.skip(1) // Skip header
                 .map(line -> line.split(","))
                 .filter(fields -> fields.length >= 3 && Double.parseDouble(fields[2]) >= 3.7)
                 .forEach(fields -> System.out.printf("  %s (GPA: %s)%n", fields[1], fields[2]));
        }
        
        System.out.println();
    }
    
    /**
     * 9. Log File Management
     */
    private static void demonstrateLogFileManagement() {
        System.out.println("9. Log File Management");
        System.out.println("-".repeat(40));
        
        LogManager logger = new LogManager("application.log");
        
        // Generate sample log entries
        logger.info("Application started");
        logger.warn("Low memory warning");
        logger.info("User login: admin");
        logger.error("Database connection failed");
        logger.info("Retrying database connection");
        logger.info("Database connection successful");
        logger.info("Application shutdown");
        
        System.out.println("✓ Log entries written");
        
        // Read and display log
        logger.readLogFile();
        
        System.out.println();
    }
    
    /**
     * 10. File Watching (WatchService)
     */
    private static void demonstrateFileWatching() throws IOException {
        System.out.println("10. File Watching (WatchService)");
        System.out.println("-".repeat(40));
        
        Path watchDir = Paths.get("watch-test");
        Files.createDirectories(watchDir);
        
        // Note: This is a simplified demonstration
        // In a real application, WatchService would run in a separate thread
        System.out.println("✓ File watching setup (simplified demo)");
        System.out.println("  In a real application, WatchService would monitor:");
        System.out.println("  - File creation events");
        System.out.println("  - File modification events");
        System.out.println("  - File deletion events");
        
        // Create a test file to simulate an event
        Path testFile = watchDir.resolve("watched-file.txt");
        Files.writeString(testFile, "This file is being watched");
        System.out.println("✓ Created watched file: " + testFile.getFileName());
        
        System.out.println();
    }
    
    /**
     * Cleanup demo files
     */
    private static void cleanupDemoFiles() {
        System.out.println("🧹 Cleaning up demo files...");
        
        String[] filesToDelete = {
            "basic-test.txt", "character-streams-test.txt", "byte-source.dat",
            "byte-target.dat", "performance-test.txt", "buffered-performance-test.txt",
            "nio-test.txt", "student.ser", "students.csv", "application.log"
        };
        
        for (String fileName : filesToDelete) {
            try {
                Files.deleteIfExists(Paths.get(fileName));
            } catch (IOException e) {
                System.err.println("Failed to delete: " + fileName);
            }
        }
        
        // Clean up directories
        try {
            Path testDir = Paths.get("test-directory");
            if (Files.exists(testDir)) {
                Files.walk(testDir)
                     .sorted(Comparator.reverseOrder())
                     .forEach(path -> {
                         try {
                             Files.delete(path);
                         } catch (IOException e) {
                             System.err.println("Failed to delete: " + path);
                         }
                     });
            }
            
            Files.deleteIfExists(Paths.get("watch-test/watched-file.txt"));
            Files.deleteIfExists(Paths.get("watch-test"));
            
        } catch (IOException e) {
            System.err.println("Failed to cleanup directories: " + e.getMessage());
        }
        
        System.out.println("✓ Cleanup completed");
    }
}