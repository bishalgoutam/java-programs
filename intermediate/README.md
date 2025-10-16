# Intermediate Java Programming

This folder contains comprehensive examples of intermediate Java programming concepts. These examples bridge the gap between fundamental language features and advanced programming techniques.

## 📁 Contents

### 1. Collections Framework (`CollectionsDemo.java`)
**Comprehensive demonstration of Java Collections Framework**

- **List implementations**: ArrayList, LinkedList, Vector
- **Set implementations**: HashSet, LinkedHashSet, TreeSet
- **Map implementations**: HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap
- **Queue implementations**: ArrayDeque, PriorityQueue, LinkedList as Queue
- **Collection utilities**: Collections.sort(), shuffle(), reverse(), etc.
- **Performance comparisons** and **best practices**

**Key Features:**
- ArrayList vs LinkedList performance analysis
- Set uniqueness demonstrations
- Map key-value operations and iteration
- Collection algorithms and transformations
- Thread-safe collection usage

### 2. Exception Handling (`ExceptionHandlingDemo.java`)
**Complete guide to exception handling in Java**

- **Basic try-catch blocks** with multiple exception types
- **Custom exception classes** with inheritance hierarchy
- **Try-with-resources** for automatic resource management
- **Exception propagation** and method signatures
- **Chained exceptions** for root cause analysis
- **Best practices** for robust error handling

**Key Features:**
- InsufficientFundsException for banking operations
- InvalidEmailException for user validation
- DatabaseConnectionException with cause chaining
- File I/O exception handling
- Producer-consumer exception scenarios

### 3. File I/O Operations (`FileIODemo.java`)
**Comprehensive file input/output operations**

- **Character streams**: FileReader, FileWriter, BufferedReader, PrintWriter
- **Byte streams**: FileInputStream, FileOutputStream with buffering
- **Modern NIO.2 API**: Files class, Path interface, Stream operations
- **Serialization**: Object persistence with Serializable interface
- **Performance optimization** with buffered I/O
- **Directory operations** and file tree traversal

**Key Features:**
- CSV file processing with parsing
- Log file management system
- File watching capabilities (WatchService)
- Performance comparisons (buffered vs unbuffered)
- Binary data handling and text encoding

### 4. Multithreading (`MultithreadingDemo.java`)
**Advanced multithreading and concurrent programming**

- **Thread creation**: Extending Thread class, implementing Runnable
- **Thread synchronization**: synchronized methods/blocks, ReentrantLock
- **Thread communication**: wait/notify, producer-consumer pattern
- **Thread pools**: ExecutorService, ScheduledExecutorService
- **Concurrent collections**: ConcurrentHashMap, BlockingQueue
- **Asynchronous programming**: CompletableFuture, Future

**Key Features:**
- Bank account thread safety demonstration
- Producer-consumer with shared buffer
- Prime number calculation with parallel processing
- Thread lifecycle and state management
- Virtual threads support (Java 21+)

## 🚀 Running the Examples

### Prerequisites
- Java 21 LTS or later
- Command line interface or IDE

### Compilation and Execution

```bash
# Navigate to the intermediate directory
cd intermediate

# Compile individual examples
javac CollectionsDemo.java
javac ExceptionHandlingDemo.java
javac FileIODemo.java
javac MultithreadingDemo.java

# Run the examples
java CollectionsDemo
java ExceptionHandlingDemo
java FileIODemo
java MultithreadingDemo
```

### Using Maven (from project root)

```bash
# Compile the entire project
mvn compile

# Run specific examples
java -cp target/classes CollectionsDemo
java -cp target/classes ExceptionHandlingDemo
java -cp target/classes FileIODemo
java -cp target/classes MultithreadingDemo
```

## 📚 Learning Objectives

### Collections Framework
- **Data Structure Selection**: Choose appropriate collection types for different use cases
- **Performance Analysis**: Understand time complexity of collection operations
- **Iterator Patterns**: Safe iteration over collections with concurrent modifications
- **Generics Usage**: Type-safe collections with parameterized types
- **Collection Algorithms**: Built-in sorting, searching, and transformation methods

### Exception Handling
- **Error Recovery**: Graceful handling of exceptional conditions
- **Resource Management**: Proper cleanup with try-with-resources
- **Exception Design**: Creating meaningful custom exception hierarchies
- **Debugging Skills**: Stack trace analysis and root cause identification
- **API Design**: Method signatures with appropriate exception declarations

### File I/O
- **Stream Concepts**: Understanding byte vs character streams
- **Resource Management**: Proper file handle cleanup
- **Performance Optimization**: Buffering strategies for large files
- **Data Persistence**: Object serialization for state preservation
- **Modern APIs**: NIO.2 advantages over legacy I/O classes

### Multithreading
- **Concurrency Control**: Preventing race conditions and data corruption
- **Thread Coordination**: Synchronization primitives and communication
- **Performance Tuning**: Thread pool sizing and task distribution
- **Deadlock Prevention**: Safe resource acquisition patterns
- **Async Programming**: Non-blocking operations with CompletableFuture

## 🛠️ Key Java Features Demonstrated

### Modern Java Features
- **Try-with-resources** (Java 7+): Automatic resource management
- **Lambda expressions** (Java 8+): Functional programming constructs
- **Stream API** (Java 8+): Declarative data processing
- **CompletableFuture** (Java 8+): Asynchronous programming
- **Switch expressions** (Java 14+): Modern control flow
- **Records** (Java 14+): Immutable data carriers
- **Virtual threads** (Java 21+): Lightweight concurrency

### Design Patterns
- **Producer-Consumer**: Inter-thread communication pattern
- **Observer Pattern**: Event-driven programming
- **Strategy Pattern**: Algorithm selection at runtime
- **Factory Pattern**: Object creation abstraction
- **Singleton Pattern**: Single instance management

### Best Practices
- **Resource Management**: Always close resources (files, streams, connections)
- **Exception Handling**: Catch specific exceptions, avoid catching Exception
- **Thread Safety**: Use concurrent collections for shared data
- **Performance**: Profile before optimizing, measure actual bottlenecks
- **Code Organization**: Separate concerns, single responsibility principle

## 🔧 Troubleshooting

### Common Issues

1. **OutOfMemoryError with large files**
   - Use buffered streams for large file operations
   - Process files in chunks rather than loading entirely
   - Consider memory-mapped files for very large datasets

2. **ConcurrentModificationException**
   - Use iterator.remove() instead of collection.remove() during iteration
   - Use concurrent collections for multi-threaded access
   - Create defensive copies when needed

3. **Deadlock in multithreaded code**
   - Always acquire locks in the same order
   - Use timeout-based lock acquisition
   - Prefer higher-level concurrency utilities

4. **Resource leaks**
   - Always use try-with-resources for AutoCloseable objects
   - Properly shutdown ExecutorService instances
   - Close database connections and streams

### Performance Tips

1. **Collections Performance**
   - ArrayList: Fast random access, slow insertion/deletion in middle
   - LinkedList: Fast insertion/deletion, slow random access
   - HashMap: O(1) average lookup, TreeMap: O(log n) sorted lookup

2. **I/O Performance**
   - Use BufferedReader/Writer for character-based I/O
   - Use NIO.2 Files class for modern file operations
   - Consider memory-mapped files for large file processing

3. **Threading Performance**
   - Size thread pools based on task characteristics (CPU vs I/O bound)
   - Use virtual threads for I/O-intensive applications (Java 21+)
   - Minimize lock contention with concurrent data structures

## 📖 Further Reading

### Documentation
- [Oracle Java Collections Tutorial](https://docs.oracle.com/javase/tutorial/collections/)
- [Oracle Concurrency Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Java NIO.2 File API](https://docs.oracle.com/javase/tutorial/essential/io/fileio.html)

### Books
- "Effective Java" by Joshua Bloch
- "Java Concurrency in Practice" by Brian Goetz
- "Java: The Complete Reference" by Herbert Schildt

### Practice Exercises
1. Implement a thread-safe cache using ConcurrentHashMap
2. Create a file-based logging system with rotation
3. Build a producer-consumer system with bounded buffer
4. Design a custom collection that implements multiple interfaces
5. Implement a parallel file processor using CompletableFuture

---

**Author**: Bishal Goutam  
**Language**: Java 21 LTS  
**Purpose**: Educational examples for intermediate Java programming concepts