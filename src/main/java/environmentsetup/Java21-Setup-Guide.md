# Java 21 LTS Setup Guide

This guide helps you set up and configure Java 21 LTS for the java-programs repository.

## 🎯 Java 21 LTS Features

Java 21 is the latest Long Term Support (LTS) release with significant improvements and new features:

### Core Language Features
- **Pattern Matching for switch** (Preview → Standard)
- **Record Patterns** (Preview → Standard)  
- **String Templates** (Preview)
- **Unnamed Patterns and Variables** (Preview)
- **Pattern Matching for instanceof** (Standard since Java 16)

### Performance & Memory
- **Generational ZGC** - Low-latency garbage collector
- **Virtual Threads** (Standard since Java 21)
- **Structured Concurrency** (Preview)
- **Improved startup time** and **reduced memory footprint**

### Developer Experience
- **Text Blocks** (Standard since Java 15)
- **Records** (Standard since Java 16)
- **Sealed Classes** (Standard since Java 17)
- **Local Variable Type Inference** (var keyword)

## 🛠️ Environment Setup

### Prerequisites
- Windows 10/11, macOS 10.14+, or Linux
- 4GB RAM minimum (8GB recommended)
- 2GB free disk space

### Step 1: Install Java 21 LTS

#### Option A: Oracle JDK (Recommended)
1. Download from [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/#java21)
2. Run the installer and follow the setup wizard
3. Default installation path: `C:\Program Files\Java\jdk-21`

#### Option B: OpenJDK
1. Download from [OpenJDK.org](https://openjdk.org/projects/jdk/21/)
2. Extract to your preferred location
3. Set JAVA_HOME manually

### Step 2: Configure Environment Variables

#### Windows (PowerShell)
```powershell
# Set JAVA_HOME for current session
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"

# Add to PATH
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"

# Verify installation
java -version
javac -version
```

#### Windows (Permanent Setup)
1. Open System Properties → Advanced → Environment Variables
2. Create/Update `JAVA_HOME`: `C:\Program Files\Java\jdk-21`
3. Update `PATH`: Add `%JAVA_HOME%\bin`

#### macOS/Linux
```bash
# Add to ~/.bashrc or ~/.zshrc
export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home"
export PATH="$JAVA_HOME/bin:$PATH"

# Reload configuration
source ~/.bashrc  # or ~/.zshrc

# Verify installation
java -version
javac -version
```

### Step 3: Install Maven (Build Tool)

#### Windows
1. Download from [Maven Downloads](https://maven.apache.org/download.cgi)
2. Extract to `C:\Program Files\Apache\apache-maven-3.9.x`
3. Add `C:\Program Files\Apache\apache-maven-3.9.x\bin` to PATH

#### macOS
```bash
# Using Homebrew
brew install maven

# Verify installation
mvn -version
```

#### Linux
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install maven

# CentOS/RHEL
sudo yum install maven

# Verify installation
mvn -version
```

### Step 4: Verify Java 21 Setup

Run the environment validator:
```bash
# Navigate to project directory
cd java-programs

# Compile the project
mvn clean compile

# Run the validator
java -cp target/classes com.bishalgoutam.environment.Java21EnvironmentValidator
```

Expected output should show:
- ✅ Running on Java 21+ LTS - All features available!
- Successful demonstration of all Java 21 features

## 🔧 IDE Configuration

### IntelliJ IDEA
1. File → Project Structure → Project
2. Set Project SDK to Java 21
3. Set Project Language Level to "21 - Pattern matching for switch"
4. File → Settings → Build → Compiler → Java Compiler
5. Set Project bytecode version to 21

### Eclipse
1. Project → Properties → Java Build Path
2. Libraries → Modulepath/Classpath → JRE System Library
3. Remove old JRE and add JRE 21
4. Project → Properties → Java Compiler
5. Set Compiler compliance level to 21

### Visual Studio Code
1. Install "Extension Pack for Java"
2. Open Command Palette (Ctrl+Shift+P)
3. Type "Java: Configure Java Runtime"
4. Set the JDK path to your Java 21 installation

## 📦 Maven Configuration

The project includes a `pom.xml` configured for Java 21:

```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <maven.compiler.release>21</maven.compiler.release>
</properties>
```

### Common Maven Commands
```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package the application
mvn package

# Run a specific class
mvn exec:java -Dexec.mainClass="com.bishalgoutam.environment.Java21EnvironmentValidator"
```

## 🚀 Quick Start

1. **Clone and setup:**
   ```bash
   git clone https://github.com/bishalgoutam/java-programs.git
   cd java-programs
   ```

2. **Verify Java 21:**
   ```bash
   java -version
   # Should show: java version "21.0.x"
   ```

3. **Build the project:**
   ```bash
   mvn clean compile
   ```

4. **Run examples:**
   ```bash
   # Environment validator
   java -cp target/classes com.bishalgoutam.environment.Java21EnvironmentValidator
   
   # Pattern matching examples
   java -cp target/classes com.bishalgoutam.features.PatternMatchingExamples
   ```

## 🧪 Testing Java 21 Features

The repository includes examples demonstrating:

### Pattern Matching for switch
```java
String result = switch (obj) {
    case String s when s.length() > 10 -> "Long string: " + s;
    case String s -> "Short string: " + s;
    case Integer i when i < 0 -> "Negative: " + i;
    case Integer i -> "Positive: " + i;
    case null -> "Null value";
    default -> "Unknown type";
};
```

### Record Patterns
```java
switch (shape) {
    case Circle(var radius) -> "Circle with radius " + radius;
    case Rectangle(var width, var height) -> "Rectangle " + width + "x" + height;
    case Point(var x, var y) -> "Point at (" + x + ", " + y + ")";
}
```

### Text Blocks
```java
String json = """
    {
        "name": "Java 21 LTS",
        "version": "21.0.1",
        "lts": true
    }
    """;
```

## 🐛 Troubleshooting

### Issue: "release version 21 not supported"
**Solution:** Ensure Maven is using Java 21:
```bash
# Check Maven's Java version
mvn -version

# Set JAVA_HOME if needed
export JAVA_HOME="/path/to/jdk-21"  # macOS/Linux
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"  # Windows
```

### Issue: IDE shows compilation errors for Java 21 features
**Solution:** 
1. Update IDE to latest version
2. Configure IDE to use Java 21 SDK
3. Set project language level to 21
4. Restart IDE

### Issue: Virtual threads not working
**Solution:** Virtual threads require runtime flags:
```bash
java --enable-preview -cp target/classes YourClass
```

### Issue: Pattern matching compilation errors
**Solution:** Ensure you're using Java 21 with correct compiler settings:
```xml
<compilerArgs>
    <arg>--enable-preview</arg>
</compilerArgs>
```

## 📚 Additional Resources

- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [OpenJDK 21](https://openjdk.org/projects/jdk/21/)
- [Java 21 Release Notes](https://jdk.java.net/21/release-notes)
- [Pattern Matching Tutorial](https://docs.oracle.com/en/java/javase/21/language/pattern-matching.html)
- [Virtual Threads Guide](https://docs.oracle.com/en/java/javase/21/core/virtual-threads.html)

## 🎉 Success!

If you can run the examples without errors, you have successfully upgraded to Java 21 LTS! 

Your development environment is now ready to take advantage of:
- Modern pattern matching
- Enhanced switch expressions
- Records and sealed classes
- Virtual threads for scalable applications
- Text blocks for readable string literals
- And much more!

Happy coding with Java 21! ☕