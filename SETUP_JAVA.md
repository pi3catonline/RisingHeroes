# Setting Up Java 17 for Rising Heroes Mod

## Current Status
Your system currently has **Java 8** installed, but the mod requires **Java 17 or higher**.

## Quick Setup

### Option 1: Use the Setup Script (Recommended)
1. Install Java 17 from [Adoptium](https://adoptium.net/temurin/releases/?version=17) (Eclipse Temurin)
2. Run the setup script:
   ```powershell
   .\setup-java17.ps1
   ```
3. This will automatically find and configure Java 17

### Option 2: Manual Configuration

1. **Install Java 17:**
   - Download from: https://adoptium.net/temurin/releases/?version=17
   - Install using the default location (usually `C:\Program Files\Eclipse Adoptium\jdk-17.x.x`)

2. **Set JAVA_HOME for current session:**
   ```powershell
   $env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-17.0.10-hotspot"
   ```
   *(Adjust the path to match your installation)*

3. **Or set it permanently:**
   - Open System Properties → Environment Variables
   - Add new System Variable:
     - Name: `JAVA_HOME`
     - Value: `C:\Program Files\Eclipse Adoptium\jdk-17.0.10-hotspot`
   - Edit PATH variable and add: `%JAVA_HOME%\bin`

4. **Verify installation:**
   ```powershell
   java -version
   ```
   Should show version 17 or higher.

### Option 3: Configure Gradle Specifically

If Java 17 is installed but not in PATH, you can configure Gradle to use it directly:

1. Edit `gradle.properties`
2. Uncomment and set the Java home path:
   ```properties
   org.gradle.java.home=C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.10-hotspot
   ```
   *(Use double backslashes and adjust path to your installation)*

## After Setup

Once Java 17 is configured, you can run:
```powershell
.\gradlew.bat build
.\gradlew.bat runClient
```

## Troubleshooting

**Java version still shows 8:**
- Restart your PowerShell/terminal
- Check that JAVA_HOME is set correctly
- Verify the Java 17 installation path

**Gradle still can't find Java 17:**
- Use Option 3 above to set `org.gradle.java.home` in `gradle.properties`
- Make sure the path uses double backslashes: `C:\\Program Files\\...`

