/**
 * Multithreading Demo
 * 
 * Comprehensive demonstration of multithreading in Java including:
 * - Thread creation (extending Thread, implementing Runnable)
 * - Thread lifecycle and states
 * - Synchronization (synchronized methods/blocks)
 * - Thread communication (wait/notify)
 * - ExecutorService and thread pools
 * - Concurrent collections
 * - CompletableFuture for asynchronous programming
 * - Virtual threads (Java 21+ feature)
 */

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Simple counter for demonstration
class Counter {
    private int count = 0;
    
    // Synchronized method
    public synchronized void increment() {
        count++;
    }
    
    // Synchronized block
    public void decrement() {
        synchronized(this) {
            count--;
        }
    }
    
    public synchronized int getCount() {
        return count;
    }
}

// Thread-safe counter using AtomicInteger
class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger(0);
    
    public void increment() {
        count.incrementAndGet();
    }
    
    public void decrement() {
        count.decrementAndGet();
    }
    
    public int getCount() {
        return count.get();
    }
}

// Producer-Consumer example
class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    private final Object lock = new Object();
    
    public Buffer(int capacity) {
        this.capacity = capacity;
    }
    
    public void produce(int item) throws InterruptedException {
        synchronized(lock) {
            while (queue.size() == capacity) {
                System.out.println("Buffer full, producer waiting...");
                lock.wait();
            }
            queue.add(item);
            System.out.println("Produced: " + item + " (Buffer size: " + queue.size() + ")");
            lock.notifyAll();
        }
    }
    
    public int consume() throws InterruptedException {
        synchronized(lock) {
            while (queue.isEmpty()) {
                System.out.println("Buffer empty, consumer waiting...");
                lock.wait();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item + " (Buffer size: " + queue.size() + ")");
            lock.notifyAll();
            return item;
        }
    }
}

// Bank account for demonstrating synchronization
class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        lock.lock();
        try {
            double newBalance = balance + amount;
            // Simulate some processing time
            Thread.sleep(1);
            balance = newBalance;
            System.out.printf("Deposited $%.2f, New Balance: $%.2f%n", amount, balance);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
    
    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                double newBalance = balance - amount;
                // Simulate some processing time
                Thread.sleep(1);
                balance = newBalance;
                System.out.printf("Withdrew $%.2f, New Balance: $%.2f%n", amount, balance);
                return true;
            } else {
                System.out.printf("Insufficient funds for withdrawal of $%.2f%n", amount);
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            lock.unlock();
        }
    }
    
    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

// Custom thread extending Thread class
class NumberPrinter extends Thread {
    private final String threadName;
    private final int maxCount;
    
    public NumberPrinter(String threadName, int maxCount) {
        this.threadName = threadName;
        this.maxCount = maxCount;
        setName(threadName);
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= maxCount; i++) {
            System.out.printf("[%s] Count: %d%n", threadName, i);
            try {
                Thread.sleep(100); // Pause for 100ms
            } catch (InterruptedException e) {
                System.out.printf("[%s] Interrupted!%n", threadName);
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.printf("[%s] Finished counting%n", threadName);
    }
}

// Runnable task
class DownloadTask implements Runnable {
    private final String fileName;
    private final int fileSize;
    
    public DownloadTask(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    
    @Override
    public void run() {
        System.out.printf("Starting download: %s (%d MB)%n", fileName, fileSize);
        
        for (int downloaded = 0; downloaded < fileSize; downloaded += 10) {
            try {
                Thread.sleep(200); // Simulate download time
                int progress = Math.min(downloaded + 10, fileSize);
                int percentage = (progress * 100) / fileSize;
                System.out.printf("[%s] Downloaded: %d%% (%d/%d MB)%n", 
                                fileName, percentage, progress, fileSize);
            } catch (InterruptedException e) {
                System.out.printf("[%s] Download interrupted!%n", fileName);
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.printf("[%s] Download completed!%n", fileName);
    }
}

// CPU-intensive task for demonstrating parallel processing
class PrimeCalculator implements Callable<List<Integer>> {
    private final int start;
    private final int end;
    
    public PrimeCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        System.out.printf("Found %d primes in range [%d, %d]%n", primes.size(), start, end);
        return primes;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class MultithreadingDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Multithreading Demonstrations ===\n");
        
        try {
            demonstrateBasicThreads();
            demonstrateRunnableInterface();
            demonstrateThreadSynchronization();
            demonstrateProducerConsumer();
            demonstrateThreadPools();
            demonstrateCallableAndFuture();
            demonstrateConcurrentCollections();
            demonstrateCompletableFuture();
            demonstrateVirtualThreads();
            
        } catch (Exception e) {
            System.err.println("Demo failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 1. Basic Thread Creation and Lifecycle
     */
    private static void demonstrateBasicThreads() throws InterruptedException {
        System.out.println("1. Basic Thread Creation");
        System.out.println("-".repeat(40));
        
        // Creating threads by extending Thread class
        NumberPrinter thread1 = new NumberPrinter("Thread-1", 5);
        NumberPrinter thread2 = new NumberPrinter("Thread-2", 5);
        
        System.out.println("Thread states before starting:");
        System.out.println("Thread-1 state: " + thread1.getState());
        System.out.println("Thread-2 state: " + thread2.getState());
        
        // Start threads
        thread1.start();
        thread2.start();
        
        System.out.println("\nThread states after starting:");
        System.out.println("Thread-1 state: " + thread1.getState());
        System.out.println("Thread-2 state: " + thread2.getState());
        
        // Wait for threads to complete
        thread1.join();
        thread2.join();
        
        System.out.println("\nThread states after completion:");
        System.out.println("Thread-1 state: " + thread1.getState());
        System.out.println("Thread-2 state: " + thread2.getState());
        
        System.out.println();
    }
    
    /**
     * 2. Implementing Runnable Interface
     */
    private static void demonstrateRunnableInterface() throws InterruptedException {
        System.out.println("2. Runnable Interface");
        System.out.println("-".repeat(40));
        
        // Creating threads using Runnable interface
        DownloadTask download1 = new DownloadTask("file1.zip", 50);
        DownloadTask download2 = new DownloadTask("file2.pdf", 30);
        DownloadTask download3 = new DownloadTask("file3.mp4", 100);
        
        Thread t1 = new Thread(download1);
        Thread t2 = new Thread(download2);
        Thread t3 = new Thread(download3);
        
        // Set thread names
        t1.setName("Download-Thread-1");
        t2.setName("Download-Thread-2");
        t3.setName("Download-Thread-3");
        
        // Start all downloads
        t1.start();
        t2.start();
        t3.start();
        
        // Wait for all downloads to complete
        t1.join();
        t2.join();
        t3.join();
        
        System.out.println("All downloads completed!\n");
    }
    
    /**
     * 3. Thread Synchronization
     */
    private static void demonstrateThreadSynchronization() throws InterruptedException {
        System.out.println("3. Thread Synchronization");
        System.out.println("-".repeat(40));
        
        // Demonstrate race condition and synchronization
        Counter counter = new Counter();
        AtomicCounter atomicCounter = new AtomicCounter();
        
        // Create multiple threads that increment counters
        List<Thread> threads = new ArrayList<>();
        int numThreads = 5;
        int incrementsPerThread = 1000;
        
        System.out.println("Testing synchronized counter:");
        
        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                    atomicCounter.increment();
                }
            });
            threads.add(t);
            t.start();
        }
        
        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.printf("Expected count: %d%n", numThreads * incrementsPerThread);
        System.out.printf("Synchronized counter: %d%n", counter.getCount());
        System.out.printf("Atomic counter: %d%n", atomicCounter.getCount());
        
        // Demonstrate bank account synchronization
        System.out.println("\nTesting bank account synchronization:");
        BankAccount account = new BankAccount(1000.0);
        
        List<Thread> bankThreads = new ArrayList<>();
        
        // Create deposit threads
        for (int i = 0; i < 3; i++) {
            Thread depositThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    account.deposit(10.0);
                }
            });
            bankThreads.add(depositThread);
        }
        
        // Create withdrawal threads
        for (int i = 0; i < 2; i++) {
            Thread withdrawThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    account.withdraw(15.0);
                }
            });
            bankThreads.add(withdrawThread);
        }
        
        // Start all bank operations
        bankThreads.forEach(Thread::start);
        
        // Wait for all operations to complete
        for (Thread t : bankThreads) {
            t.join();
        }
        
        System.out.printf("Final account balance: $%.2f%n", account.getBalance());
        System.out.println();
    }
    
    /**
     * 4. Producer-Consumer Pattern
     */
    private static void demonstrateProducerConsumer() throws InterruptedException {
        System.out.println("4. Producer-Consumer Pattern");
        System.out.println("-".repeat(40));
        
        Buffer buffer = new Buffer(3); // Buffer capacity of 3
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(200); // Produce every 200ms
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(300); // Consume every 300ms (slower than producer)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
        
        System.out.println("Producer-Consumer demo completed!\n");
    }
    
    /**
     * 5. Thread Pools and ExecutorService
     */
    private static void demonstrateThreadPools() throws InterruptedException {
        System.out.println("5. Thread Pools and ExecutorService");
        System.out.println("-".repeat(40));
        
        // Fixed thread pool
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        System.out.println("Submitting tasks to fixed thread pool (size=3):");
        
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.printf("Task %d executed by %s%n", taskId, threadName);
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        fixedPool.shutdown();
        if (!fixedPool.awaitTermination(15, TimeUnit.SECONDS)) {
            fixedPool.shutdownNow();
        }
        
        // Cached thread pool
        System.out.println("\nUsing cached thread pool:");
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedPool.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.printf("Quick Task %d executed by %s%n", taskId, threadName);
            });
        }
        
        cachedPool.shutdown();
        cachedPool.awaitTermination(5, TimeUnit.SECONDS);
        
        // Scheduled thread pool
        System.out.println("\nUsing scheduled thread pool:");
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // Schedule a task with fixed delay
        ScheduledFuture<?> future = scheduledPool.scheduleWithFixedDelay(() -> {
            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.printf("Scheduled task executed at %s%n", time);
        }, 1, 2, TimeUnit.SECONDS);
        
        // Let it run for 7 seconds then cancel
        Thread.sleep(7000);
        future.cancel(true);
        scheduledPool.shutdown();
        
        System.out.println();
    }
    
    /**
     * 6. Callable and Future
     */
    private static void demonstrateCallableAndFuture() throws InterruptedException, ExecutionException {
        System.out.println("6. Callable and Future");
        System.out.println("-".repeat(40));
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        // Submit Callable tasks to find prime numbers in different ranges
        List<Future<List<Integer>>> futures = new ArrayList<>();
        
        futures.add(executor.submit(new PrimeCalculator(1, 100)));
        futures.add(executor.submit(new PrimeCalculator(101, 200)));
        futures.add(executor.submit(new PrimeCalculator(201, 300)));
        futures.add(executor.submit(new PrimeCalculator(301, 400)));
        
        // Collect results
        List<Integer> allPrimes = new ArrayList<>();
        for (Future<List<Integer>> future : futures) {
            allPrimes.addAll(future.get()); // This blocks until the task completes
        }
        
        System.out.printf("Total primes found: %d%n", allPrimes.size());
        System.out.println("First 20 primes: " + allPrimes.subList(0, Math.min(20, allPrimes.size())));
        
        // Demonstrate timeout
        System.out.println("\nDemonstrating Future timeout:");
        Future<String> slowTask = executor.submit(() -> {
            Thread.sleep(5000); // 5 second task
            return "Slow task completed";
        });
        
        try {
            String result = slowTask.get(2, TimeUnit.SECONDS); // 2 second timeout
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Task timed out!");
            slowTask.cancel(true);
        }
        
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println();
    }
    
    /**
     * 7. Concurrent Collections
     */
    private static void demonstrateConcurrentCollections() throws InterruptedException {
        System.out.println("7. Concurrent Collections");
        System.out.println("-".repeat(40));
        
        // ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // BlockingQueue
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        
        // CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        
        ExecutorService executor = Executors.newFixedThreadPool(6);
        
        // Tasks that modify concurrent collections
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 5; j++) {
                    String key = "Thread-" + threadId + "-Item-" + j;
                    concurrentMap.put(key, j);
                    copyOnWriteList.add(key);
                    try {
                        blockingQueue.put(key);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        
        // Tasks that read from concurrent collections
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                try {
                    for (int j = 0; j < 5; j++) {
                        String item = blockingQueue.take(); // Blocks until item available
                        System.out.println("Consumed: " + item);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.printf("ConcurrentHashMap size: %d%n", concurrentMap.size());
        System.out.printf("CopyOnWriteArrayList size: %d%n", copyOnWriteList.size());
        System.out.printf("BlockingQueue size: %d%n", blockingQueue.size());
        
        System.out.println();
    }
    
    /**
     * 8. CompletableFuture for Asynchronous Programming
     */
    private static void demonstrateCompletableFuture() throws InterruptedException {
        System.out.println("8. CompletableFuture");
        System.out.println("-".repeat(40));
        
        // Simple async computation
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return "Hello";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted";
            }
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
                return "World";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted";
            }
        });
        
        // Combine futures
        CompletableFuture<String> combined = future1.thenCombine(future2, 
            (result1, result2) -> result1 + " " + result2 + "!");
        
        System.out.println("Waiting for async computation...");
        System.out.println("Result: " + combined.join());
        
        // Chain operations
        CompletableFuture<Integer> chainedFuture = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Step 1: Generate random number");
                return new Random().nextInt(100);
            })
            .thenApply(number -> {
                System.out.println("Step 2: Multiply by 2");
                return number * 2;
            })
            .thenApply(number -> {
                System.out.println("Step 3: Add 10");
                return number + 10;
            });
        
        System.out.println("Chained result: " + chainedFuture.join());
        
        // Handle exceptions
        CompletableFuture<String> exceptionFuture = CompletableFuture
            .supplyAsync(() -> {
                if (Math.random() < 0.5) {
                    throw new RuntimeException("Random failure!");
                }
                return "Success!";
            })
            .handle((result, exception) -> {
                if (exception != null) {
                    return "Error handled: " + exception.getMessage();
                }
                return result;
            });
        
        System.out.println("Exception handling result: " + exceptionFuture.join());
        
        System.out.println();
    }
    
    /**
     * 9. Virtual Threads (Java 21+ feature)
     */
    private static void demonstrateVirtualThreads() throws InterruptedException {
        System.out.println("9. Virtual Threads (Java 21+)");
        System.out.println("-".repeat(40));
        
        try {
            // Check if virtual threads are available using reflection
            Class<?> threadClass = Thread.class;
            @SuppressWarnings("unused")
            var ofVirtualMethod = threadClass.getMethod("ofVirtual");
            
            System.out.println("✓ Virtual threads are available!");
            
            // Since we can't use the API directly in older Java versions,
            // we'll demonstrate the concept using regular threads
            System.out.println("Demonstrating virtual thread concepts with regular threads:");
            
            List<Thread> threads = new ArrayList<>();
            
            for (int i = 1; i <= 5; i++) {
                final int taskId = i;
                Thread thread = new Thread(() -> {
                    System.out.printf("Task %d running on: %s%n", taskId, Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                        System.out.printf("Task %d completed%n", taskId);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                thread.setName("demo-thread-" + i);
                threads.add(thread);
                thread.start();
            }
            
            for (Thread thread : threads) {
                thread.join();
            }
            
            System.out.println("✓ Virtual threads concept demo completed");
            
        } catch (NoSuchMethodException e) {
            System.out.println("Virtual threads not available in this Java version");
            System.out.println("Virtual threads require Java 21 or later");
            System.out.println("\nVirtual Threads Features (Java 21+):");
            System.out.println("• Lightweight threads managed by the JVM");
            System.out.println("• Millions of virtual threads can be created");
            System.out.println("• Better resource utilization for I/O-bound tasks");
            System.out.println("• Simplified concurrent programming model");
            System.out.println("\nExample virtual thread usage:");
            System.out.println("  Thread.ofVirtual().name(\"virtual-1\").start(() -> {");
            System.out.println("      // Your task here");
            System.out.println("  });");
        }
        
        System.out.println();
    }
}