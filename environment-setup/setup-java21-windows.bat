@echo off
echo ===============================================
echo   Java 21 LTS Environment Setup for Windows
echo ===============================================
echo.

echo Checking Java 21 installation...
java -version 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 21 LTS from Oracle or OpenJDK
    echo Download: https://www.oracle.com/java/technologies/downloads/#java21
    pause
    exit /b 1
)

echo.
echo Checking Java version compatibility...
for /f "tokens=3" %%g in ('java -version 2^>^&1 ^| findstr /i "version"') do (
    set JAVA_VERSION=%%g
)
echo Current Java version: %JAVA_VERSION%

echo.
echo Setting JAVA_HOME to Java 21...
for /f "tokens=2*" %%i in ('reg query "HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\JDK" /s /v JavaHome 2^>nul ^| findstr "21\."') do (
    set "JAVA_HOME=%%j"
)

if not defined JAVA_HOME (
    echo Warning: Could not automatically detect Java 21 installation
    echo Please set JAVA_HOME manually to your Java 21 installation path
    echo Example: set JAVA_HOME=C:\Program Files\Java\jdk-21
    echo.
    set /p JAVA_HOME=Enter Java 21 installation path: 
)

echo JAVA_HOME set to: %JAVA_HOME%
set PATH=%JAVA_HOME%\bin;%PATH%

echo.
echo Checking Maven installation...
mvn -version 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Maven is not installed or not in PATH
    echo Please install Maven 3.9+ from: https://maven.apache.org/download.cgi
    pause
    exit /b 1
)

echo.
echo Building Java 21 project...
mvn clean compile
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Failed to build the project
    echo Please check your Java 21 and Maven configuration
    pause
    exit /b 1
)

echo.
echo Running Java 21 environment validation...
java -cp target/classes com.bishalgoutam.environment.Java21EnvironmentValidator
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Failed to run environment validator
    pause
    exit /b 1
)

echo.
echo ================================================
echo   Java 21 LTS Environment Setup Complete!
echo ================================================
echo.
echo You can now:
echo - Compile and run Java 21 programs
echo - Use modern Java features like pattern matching
echo - Build projects with Maven
echo.
echo Quick commands:
echo   mvn clean compile     - Build the project
echo   mvn test             - Run tests
echo   java -cp target/classes [ClassName] - Run a class
echo.
pause