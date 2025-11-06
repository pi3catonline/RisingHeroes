# Setup script to configure Java 17 for Rising Heroes mod
# Run this script after installing Java 17

Write-Host "Checking for Java 17 installation..." -ForegroundColor Cyan

# Common Java 17 installation locations
$possiblePaths = @(
    "C:\Program Files\Java\jdk-17",
    "C:\Program Files\Java\jdk-17.0.2",
    "C:\Program Files\Java\jdk-17.0.3",
    "C:\Program Files\Java\jdk-17.0.4",
    "C:\Program Files\Java\jdk-17.0.5",
    "C:\Program Files\Java\jdk-17.0.6",
    "C:\Program Files\Java\jdk-17.0.7",
    "C:\Program Files\Java\jdk-17.0.8",
    "C:\Program Files\Java\jdk-17.0.9",
    "C:\Program Files\Java\jdk-17.0.10",
    "C:\Program Files\Java\jdk-17.0.11",
    "C:\Program Files\Eclipse Adoptium\jdk-17*",
    "C:\Program Files\Eclipse Adoptium\jdk-17.0*",
    "$env:LOCALAPPDATA\Programs\Eclipse Adoptium\jdk-17*",
    "C:\Program Files\AdoptOpenJDK\jdk-17*",
    "C:\Program Files\Microsoft\jdk-17*"
)

$java17Found = $null

foreach ($path in $possiblePaths) {
    $resolvedPaths = Get-ChildItem $path -ErrorAction SilentlyContinue -Directory | Where-Object { 
        $_.Name -match 'jdk-17' 
    } | Select-Object -First 1
    
    if ($resolvedPaths) {
        $javaHome = $resolvedPaths.FullName
        $javaExe = Join-Path $javaHome "bin\java.exe"
        
        if (Test-Path $javaExe) {
            $version = & $javaExe -version 2>&1 | Select-String "version"
            if ($version -match '"17') {
                $java17Found = $javaHome
                Write-Host "Found Java 17 at: $javaHome" -ForegroundColor Green
                Write-Host "Version: $version" -ForegroundColor Green
                break
            }
        }
    }
}

if (-not $java17Found) {
    Write-Host "Java 17 not found!" -ForegroundColor Red
    Write-Host ""
    Write-Host "Please install Java 17 from one of these sources:" -ForegroundColor Yellow
    Write-Host "  - Adoptium (Recommended): https://adoptium.net/temurin/releases/?version=17" -ForegroundColor Yellow
    Write-Host "  - Oracle JDK: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html" -ForegroundColor Yellow
    Write-Host ""
    Write-Host "After installing, run this script again." -ForegroundColor Yellow
    exit 1
}

# Set JAVA_HOME for current session
$env:JAVA_HOME = $java17Found
Write-Host ""
Write-Host "Setting JAVA_HOME for current session: $env:JAVA_HOME" -ForegroundColor Cyan

# Verify it works
Write-Host ""
Write-Host "Verifying Java version..." -ForegroundColor Cyan
$currentJava = & "$env:JAVA_HOME\bin\java.exe" -version 2>&1
Write-Host $currentJava

Write-Host ""
Write-Host "Java 17 is now configured for this PowerShell session!" -ForegroundColor Green
Write-Host ""
Write-Host "To use Java 17 permanently, add this to your system environment variables:" -ForegroundColor Yellow
Write-Host "  JAVA_HOME = $java17Found" -ForegroundColor Yellow
Write-Host ""
Write-Host "Or run this command in your PowerShell session:" -ForegroundColor Yellow
Write-Host "  `$env:JAVA_HOME = '$java17Found'" -ForegroundColor Cyan
Write-Host ""
Write-Host "You can now run: .\gradlew.bat build" -ForegroundColor Green

