# Java 21 LTS Environment Setup Script for PowerShell
# Run this script to permanently configure Java 21 environment variables

Write-Host "======================================" -ForegroundColor Green
Write-Host "  Java 21 LTS Environment Setup" -ForegroundColor Green  
Write-Host "======================================" -ForegroundColor Green
Write-Host ""

# Function to set environment variable permanently
function Set-EnvironmentVariable {
    param(
        [string]$Name,
        [string]$Value,
        [string]$Target = "User"
    )
    
    try {
        [Environment]::SetEnvironmentVariable($Name, $Value, $Target)
        Write-Host "✅ Set $Name = $Value" -ForegroundColor Green
        
        # Also set for current session
        Set-Item -Path "env:$Name" -Value $Value
    }
    catch {
        Write-Host "❌ Failed to set $Name" -ForegroundColor Red
        Write-Host $_.Exception.Message -ForegroundColor Red
    }
}

# Check if running as Administrator
$isAdmin = ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator")

if ($isAdmin) {
    Write-Host "Running as Administrator - will set system-wide variables" -ForegroundColor Yellow
    $envTarget = "Machine"
} else {
    Write-Host "Running as User - will set user-specific variables" -ForegroundColor Cyan
    $envTarget = "User"
}

Write-Host ""

# Detect Java 21 installation
Write-Host "🔍 Detecting Java 21 installation..." -ForegroundColor Cyan

$java21Paths = @(
    "C:\Program Files\Java\jdk-21",
    "C:\Program Files\Java\jdk-21.0.1",
    "C:\Program Files\OpenJDK\jdk-21",
    "C:\Program Files (x86)\Java\jdk-21",
    "${env:ProgramFiles}\Java\jdk-21",
    "${env:ProgramFiles(x86)}\Java\jdk-21"
)

$java21Path = $null
foreach ($path in $java21Paths) {
    if (Test-Path "$path\bin\java.exe") {
        $java21Path = $path
        break
    }
}

if (-not $java21Path) {
    Write-Host "❌ Java 21 not found in standard locations" -ForegroundColor Red
    Write-Host "Please install Java 21 LTS from:" -ForegroundColor Yellow
    Write-Host "  - Oracle: https://www.oracle.com/java/technologies/downloads/#java21" -ForegroundColor Cyan
    Write-Host "  - OpenJDK: https://openjdk.org/projects/jdk/21/" -ForegroundColor Cyan
    Write-Host ""
    
    # Allow manual path input
    $manualPath = Read-Host "Enter Java 21 installation path (or press Enter to exit)"
    if ($manualPath -and (Test-Path "$manualPath\bin\java.exe")) {
        $java21Path = $manualPath
    } else {
        Write-Host "❌ Exiting - Java 21 installation required" -ForegroundColor Red
        exit 1
    }
}

Write-Host "✅ Found Java 21 at: $java21Path" -ForegroundColor Green

# Set JAVA_HOME
Set-EnvironmentVariable -Name "JAVA_HOME" -Value $java21Path -Target $envTarget

# Update PATH
$currentPath = [Environment]::GetEnvironmentVariable("PATH", $envTarget)
$javaBinPath = "$java21Path\bin"

if ($currentPath -notlike "*$javaBinPath*") {
    $newPath = "$javaBinPath;$currentPath"
    Set-EnvironmentVariable -Name "PATH" -Value $newPath -Target $envTarget
    Write-Host "✅ Added Java 21 bin to PATH" -ForegroundColor Green
} else {
    Write-Host "ℹ️  Java 21 bin already in PATH" -ForegroundColor Blue
}

Write-Host ""

# Verify Java installation
Write-Host "🧪 Verifying Java 21 installation..." -ForegroundColor Cyan
try {
    $javaVersion = & "$java21Path\bin\java.exe" -version 2>&1
    if ($javaVersion -match "21\.") {
        Write-Host "✅ Java 21 verification successful" -ForegroundColor Green
        Write-Host $javaVersion[0] -ForegroundColor Gray
    } else {
        Write-Host "⚠️  Warning: Java version might not be 21" -ForegroundColor Yellow
    }
} catch {
    Write-Host "❌ Failed to verify Java installation" -ForegroundColor Red
}

Write-Host ""

# Check Maven
Write-Host "🔍 Checking Maven installation..." -ForegroundColor Cyan
try {
    $mavenVersion = mvn -version 2>&1
    if ($mavenVersion -like "*Apache Maven*") {
        Write-Host "✅ Maven is installed" -ForegroundColor Green
        
        # Check if Maven is using Java 21
        if ($mavenVersion -match "Java version: 21\.") {
            Write-Host "✅ Maven is using Java 21" -ForegroundColor Green
        } else {
            Write-Host "⚠️  Maven might not be using Java 21" -ForegroundColor Yellow
            Write-Host "   Restart your terminal/IDE to pick up new JAVA_HOME" -ForegroundColor Cyan
        }
    }
} catch {
    Write-Host "⚠️  Maven not found - install from https://maven.apache.org/download.cgi" -ForegroundColor Yellow
}

Write-Host ""

# Final instructions
Write-Host "========================================" -ForegroundColor Green
Write-Host "  Setup Complete!" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""

Write-Host "📋 Next Steps:" -ForegroundColor Cyan
Write-Host "1. Restart your terminal/command prompt" -ForegroundColor Gray
Write-Host "2. Restart your IDE (VS Code, IntelliJ, Eclipse)" -ForegroundColor Gray
Write-Host "3. Navigate to your java-programs directory" -ForegroundColor Gray
Write-Host "4. Run: mvn clean compile" -ForegroundColor Gray
Write-Host "5. Run: java -cp target/classes com.bishalgoutam.environment.Java21EnvironmentValidator" -ForegroundColor Gray
Write-Host ""

Write-Host "🎉 Your Java 21 LTS environment is ready!" -ForegroundColor Green
Write-Host ""

# Pause to let user see the results
Read-Host "Press Enter to exit"