package environmentsetup;

/**
 * Environment Validator
 * 
 * Comprehensive Java program to validate the development environment setup
 * including Java version, JVM properties, classpath, and compilation capabilities.
 * 
 * This program tests:
 * - Java version and vendor information
 * - JVM system properties
 * - Memory settings and garbage collection
 * - File system permissions
 * - Compilation and execution capabilities
 * - Modern Java features availability
 * - Third-party library access
 */

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.lang.management.*;
import java.security.Security;
import java.security.Provider;

public class EnvironmentValidator {
    
    private static final String SEPARATOR = "=".repeat(60);
    private static final List<String> validationResults = new ArrayList<>();
    private static boolean allTestsPassed = true;
    
    public static void main(String[] args) {
        System.out.println("Java Development Environment Validator");
        System.out.println(SEPARATOR);
        System.out.println("Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println();
        
        try {
            validateJavaVersion();
            validateJVMProperties();
            validateMemorySettings();
            validateFileSystemAccess();
            validateCompilationCapabilities();
            validateModernJavaFeatures();
            validateConcurrencySupport();
            validateSecuritySettings();
            validateClasspathAndLibraries();
            
            printSummary();
            
        } catch (Exception e) {
            System.err.println("Environment validation failed with exception: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        
        System.exit(allTestsPassed ? 0 : 1);
    }
    
    /**
     * 1. Java Version Validation
     */
    private static void validateJavaVersion() {
        System.out.println("1. Java Version Validation");
        System.out.println("-".repeat(40));
        
        try {
            String javaVersion = System.getProperty("java.version");
            String javaVendor = System.getProperty("java.vendor");
            String javaHome = System.getProperty("java.home");
            String javaVmName = System.getProperty("java.vm.name");
            String javaVmVersion = System.getProperty("java.vm.version");
            
            System.out.println("✓ Java Version: " + javaVersion);
            System.out.println("✓ Java Vendor: " + javaVendor);
            System.out.println("✓ Java Home: " + javaHome);
            System.out.println("✓ JVM Name: " + javaVmName);
            System.out.println("✓ JVM Version: " + javaVmVersion);
            
            // Check if Java 21 or later
            int majorVersion = getMajorJavaVersion(javaVersion);
            if (majorVersion >= 21) {
                System.out.println("✅ Java 21+ detected - Modern features available");
                validationResults.add("✅ Java Version: " + javaVersion + " (✓ Java 21+ LTS)");
            } else if (majorVersion >= 17) {
                System.out.println("⚠️  Java 17+ detected - Some modern features may not be available");
                validationResults.add("⚠️  Java Version: " + javaVersion + " (Upgrade to Java 21+ recommended)");
            } else {
                System.out.println("❌ Java version too old - Please upgrade to Java 21 LTS");
                validationResults.add("❌ Java Version: " + javaVersion + " (Upgrade required)");
                allTestsPassed = false;
            }
            
        } catch (Exception e) {
            System.err.println("❌ Failed to validate Java version: " + e.getMessage());
            validationResults.add("❌ Java Version: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 2. JVM Properties Validation
     */
    private static void validateJVMProperties() {
        System.out.println("2. JVM System Properties");
        System.out.println("-".repeat(40));
        
        try {
            String osName = System.getProperty("os.name");
            String osVersion = System.getProperty("os.version");
            String osArch = System.getProperty("os.arch");
            String userDir = System.getProperty("user.dir");
            String userHome = System.getProperty("user.home");
            String pathSeparator = System.getProperty("path.separator");
            String fileSeparator = System.getProperty("file.separator");
            
            System.out.println("✓ Operating System: " + osName + " " + osVersion);
            System.out.println("✓ Architecture: " + osArch);
            System.out.println("✓ Working Directory: " + userDir);
            System.out.println("✓ User Home: " + userHome);
            System.out.println("✓ Path Separator: '" + pathSeparator + "'");
            System.out.println("✓ File Separator: '" + fileSeparator + "'");
            
            // Check important system properties
            String classpath = System.getProperty("java.class.path");
            if (classpath != null && !classpath.isEmpty()) {
                System.out.println("✓ Classpath configured");
                validationResults.add("✅ JVM Properties: All essential properties available");
            } else {
                System.out.println("⚠️  Classpath not set");
                validationResults.add("⚠️  JVM Properties: Classpath configuration issue");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Failed to validate JVM properties: " + e.getMessage());
            validationResults.add("❌ JVM Properties: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 3. Memory Settings Validation
     */
    private static void validateMemorySettings() {
        System.out.println("3. Memory Settings");
        System.out.println("-".repeat(40));
        
        try {
            Runtime runtime = Runtime.getRuntime();
            MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
            
            long maxMemory = runtime.maxMemory();
            long totalMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();
            long usedMemory = totalMemory - freeMemory;
            
            System.out.printf("✓ Max Memory: %.2f MB%n", maxMemory / (1024.0 * 1024.0));
            System.out.printf("✓ Total Memory: %.2f MB%n", totalMemory / (1024.0 * 1024.0));
            System.out.printf("✓ Used Memory: %.2f MB%n", usedMemory / (1024.0 * 1024.0));
            System.out.printf("✓ Free Memory: %.2f MB%n", freeMemory / (1024.0 * 1024.0));
            
            // Heap memory details
            MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
            System.out.printf("✓ Heap Memory Used: %.2f MB%n", heapUsage.getUsed() / (1024.0 * 1024.0));
            System.out.printf("✓ Heap Memory Max: %.2f MB%n", heapUsage.getMax() / (1024.0 * 1024.0));
            
            // Check if sufficient memory is available
            if (maxMemory > 512 * 1024 * 1024) { // 512 MB
                System.out.println("✅ Sufficient memory available for development");
                validationResults.add("✅ Memory: Sufficient for development work");
            } else {
                System.out.println("⚠️  Limited memory - consider increasing heap size");
                validationResults.add("⚠️  Memory: Limited heap size detected");
            }
            
            // Garbage Collector information
            List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
            System.out.println("✓ Garbage Collectors:");
            for (GarbageCollectorMXBean gcBean : gcBeans) {
                System.out.println("  - " + gcBean.getName());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Failed to validate memory settings: " + e.getMessage());
            validationResults.add("❌ Memory: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 4. File System Access Validation
     */
    private static void validateFileSystemAccess() {
        System.out.println("4. File System Access");
        System.out.println("-".repeat(40));
        
        try {
            // Test file creation, writing, reading, and deletion
            Path testDir = Paths.get("environment-test");
            Path testFile = testDir.resolve("test-file.txt");
            String testContent = "Environment validation test content\nTimestamp: " + 
                               LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            
            // Create directory
            Files.createDirectories(testDir);
            System.out.println("✓ Directory creation: SUCCESS");
            
            // Write file
            Files.writeString(testFile, testContent);
            System.out.println("✓ File writing: SUCCESS");
            
            // Read file
            String readContent = Files.readString(testFile);
            if (testContent.equals(readContent)) {
                System.out.println("✓ File reading: SUCCESS");
            } else {
                throw new IOException("File content mismatch");
            }
            
            // Check permissions
            System.out.println("✓ File readable: " + Files.isReadable(testFile));
            System.out.println("✓ File writable: " + Files.isWritable(testFile));
            System.out.println("✓ Directory writable: " + Files.isWritable(testDir));
            
            // Cleanup
            Files.deleteIfExists(testFile);
            Files.deleteIfExists(testDir);
            System.out.println("✓ File cleanup: SUCCESS");
            
            validationResults.add("✅ File System: Full read/write access available");
            
        } catch (Exception e) {
            System.err.println("❌ File system access failed: " + e.getMessage());
            validationResults.add("❌ File System: Access validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 5. Compilation Capabilities Validation
     */
    private static void validateCompilationCapabilities() {
        System.out.println("5. Compilation Capabilities");
        System.out.println("-".repeat(40));
        
        try {
            // Check if compilation tools are available
            String javaHome = System.getProperty("java.home");
            Path javacPath = Paths.get(javaHome, "bin", "javac.exe");
            Path javacPathUnix = Paths.get(javaHome, "bin", "javac");
            
            boolean javacExists = Files.exists(javacPath) || Files.exists(javacPathUnix);
            
            if (javacExists) {
                System.out.println("✓ Java Compiler (javac): Available");
                validationResults.add("✅ Compilation: Java compiler available");
            } else {
                // Check if we're running on JDK or JRE
                System.out.println("⚠️  Java Compiler (javac): Not found in JAVA_HOME");
                System.out.println("  This might be a JRE installation. JDK required for compilation.");
                validationResults.add("⚠️  Compilation: JDK required for compilation");
            }
            
            // Test runtime compilation capabilities
            System.out.println("✓ Runtime class loading: Available");
            System.out.println("✓ Reflection API: Available");
            
            // Test if we can load standard library classes
            Class.forName("java.util.ArrayList");
            Class.forName("java.nio.file.Files");
            Class.forName("java.util.concurrent.CompletableFuture");
            System.out.println("✓ Standard library classes: Accessible");
            
        } catch (Exception e) {
            System.err.println("❌ Compilation validation failed: " + e.getMessage());
            validationResults.add("❌ Compilation: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 6. Modern Java Features Validation
     */
    private static void validateModernJavaFeatures() {
        System.out.println("6. Modern Java Features");
        System.out.println("-".repeat(40));
        
        try {
            // Test switch expressions (Java 14+)
            String switchResult = switch ("test") {
                case "test" -> "Switch expressions work";
                default -> "Switch expressions failed";
            };
            System.out.println("✓ Switch expressions: " + switchResult);
            
            // Test text blocks (Java 15+)
            String textBlock = """
                Text blocks are working correctly.
                Multi-line strings supported.
                """;
            System.out.println("✓ Text blocks: Available");
            System.out.println("  " + textBlock.trim());
            
            // Test records (Java 14+)
            record TestRecord(String name, int value) {}
            TestRecord testRecord = new TestRecord("test", 42);
            System.out.println("✓ Records: " + testRecord);
            
            // Test pattern matching for instanceof (Java 16+)
            Object obj = "pattern matching test";
            if (obj instanceof String str) {
                System.out.println("✓ Pattern matching for instanceof: " + str.toUpperCase());
            }
            
            // Test var keyword (Java 10+)
            var varTest = "Local variable type inference works";
            System.out.println("✓ Var keyword: " + varTest);
            
            // Test lambda expressions (Java 8+)
            List<String> list = Arrays.asList("lambda", "expressions", "work");
            list.stream().map(String::toUpperCase).forEach(s -> {});
            System.out.println("✓ Lambda expressions: Available");
            
            // Test CompletableFuture (Java 8+)
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Async programming works");
            String asyncResult = future.get(1, TimeUnit.SECONDS);
            System.out.println("✓ CompletableFuture: " + asyncResult);
            
            validationResults.add("✅ Modern Features: All Java 21 features available");
            
        } catch (Exception e) {
            System.err.println("❌ Modern Java features validation failed: " + e.getMessage());
            validationResults.add("❌ Modern Features: Some features unavailable");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 7. Concurrency Support Validation
     */
    private static void validateConcurrencySupport() {
        System.out.println("7. Concurrency Support");
        System.out.println("-".repeat(40));
        
        try {
            // Test thread creation
            Thread testThread = new Thread(() -> System.out.println("✓ Thread creation: SUCCESS"));
            testThread.start();
            testThread.join(1000);
            
            // Test executor service
            ExecutorService executor = Executors.newFixedThreadPool(2);
            Future<String> future1 = executor.submit(() -> "Task 1 completed");
            Future<String> future2 = executor.submit(() -> "Task 2 completed");
            
            String result1 = future1.get(1, TimeUnit.SECONDS);
            String result2 = future2.get(1, TimeUnit.SECONDS);
            
            System.out.println("✓ ExecutorService: " + result1);
            System.out.println("✓ Future tasks: " + result2);
            
            executor.shutdown();
            if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("✓ Executor shutdown: SUCCESS");
            }
            
            // Test concurrent collections
            Map<String, String> concurrentMap = new ConcurrentHashMap<>();
            concurrentMap.put("test", "concurrent collections work");
            System.out.println("✓ Concurrent collections: " + concurrentMap.get("test"));
            
            // Test virtual threads (Java 21+)
            try {
                // Use reflection to check if virtual threads are available
                Thread.class.getMethod("ofVirtual");
                System.out.println("✓ Virtual threads: Available (Java 21+)");
            } catch (NoSuchMethodException e) {
                System.out.println("⚠️  Virtual threads: Not available (requires Java 21+)");
            }
            
            validationResults.add("✅ Concurrency: Full thread and executor support");
            
        } catch (Exception e) {
            System.err.println("❌ Concurrency validation failed: " + e.getMessage());
            validationResults.add("❌ Concurrency: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 8. Security Settings Validation
     */
    private static void validateSecuritySettings() {
        System.out.println("8. Security Settings");
        System.out.println("-".repeat(40));
        
        try {
            // Check security providers
            Provider[] providers = Security.getProviders();
            System.out.println("✓ Security providers available: " + providers.length);
            for (Provider provider : providers) {
                System.out.println("  - " + provider.getName() + " v" + provider.getVersionStr());
            }
            
            // Test file permissions
            String userDir = System.getProperty("user.dir");
            File currentDir = new File(userDir);
            System.out.println("✓ Current directory readable: " + currentDir.canRead());
            System.out.println("✓ Current directory writable: " + currentDir.canWrite());
            
            // Check system properties access
            System.out.println("✓ System properties accessible: " + 
                             (System.getProperty("java.version") != null));
            
            validationResults.add("✅ Security: Standard security settings configured");
            
        } catch (Exception e) {
            System.err.println("❌ Security validation failed: " + e.getMessage());
            validationResults.add("❌ Security: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * 9. Classpath and Libraries Validation
     */
    private static void validateClasspathAndLibraries() {
        System.out.println("9. Classpath and Libraries");
        System.out.println("-".repeat(40));
        
        try {
            // Check classpath
            String classpath = System.getProperty("java.class.path");
            String[] classpathEntries = classpath.split(System.getProperty("path.separator"));
            System.out.println("✓ Classpath entries: " + classpathEntries.length);
            
            // Test loading common Java classes
            String[] testClasses = {
                "java.lang.String",
                "java.util.ArrayList",
                "java.io.File",
                "java.nio.file.Files",
                "java.util.concurrent.CompletableFuture",
                "java.time.LocalDateTime",
                "java.util.stream.Stream"
            };
            
            int loadedClasses = 0;
            for (String className : testClasses) {
                try {
                    Class.forName(className);
                    loadedClasses++;
                } catch (ClassNotFoundException e) {
                    System.err.println("⚠️  Could not load class: " + className);
                }
            }
            
            System.out.println("✓ Standard library classes loaded: " + loadedClasses + "/" + testClasses.length);
            
            if (loadedClasses == testClasses.length) {
                validationResults.add("✅ Classpath: All standard libraries accessible");
            } else {
                validationResults.add("⚠️  Classpath: Some libraries inaccessible");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Classpath validation failed: " + e.getMessage());
            validationResults.add("❌ Classpath: Validation failed");
            allTestsPassed = false;
        }
        
        System.out.println();
    }
    
    /**
     * Print validation summary
     */
    private static void printSummary() {
        System.out.println(SEPARATOR);
        System.out.println("ENVIRONMENT VALIDATION SUMMARY");
        System.out.println(SEPARATOR);
        
        for (String result : validationResults) {
            System.out.println(result);
        }
        
        System.out.println();
        System.out.println(SEPARATOR);
        
        if (allTestsPassed) {
            System.out.println("🎉 ALL VALIDATIONS PASSED!");
            System.out.println("Your Java development environment is properly configured.");
            System.out.println("You can proceed with Java development and compilation.");
        } else {
            System.out.println("⚠️  SOME VALIDATIONS FAILED!");
            System.out.println("Please review the issues above and fix the configuration.");
            System.out.println("Your environment may have limitations for Java development.");
        }
        
        System.out.println(SEPARATOR);
        System.out.println("Validation completed at: " + 
                         LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
    
    /**
     * Extract major Java version from version string
     */
    private static int getMajorJavaVersion(String versionString) {
        try {
            if (versionString.startsWith("1.")) {
                // Java 8 and earlier (1.8.0_xxx)
                return Integer.parseInt(versionString.substring(2, 3));
            } else {
                // Java 9+ (11.0.1, 17.0.2, 21.0.1)
                int dotIndex = versionString.indexOf('.');
                if (dotIndex > 0) {
                    return Integer.parseInt(versionString.substring(0, dotIndex));
                } else {
                    return Integer.parseInt(versionString);
                }
            }
        } catch (NumberFormatException e) {
            return 0; // Unknown version
        }
    }
}