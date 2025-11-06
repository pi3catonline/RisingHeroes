# How to Run Rising Heroes Mod in Minecraft

## Prerequisites
- **Java 17 or higher** installed and set as default
- **Minecraft 1.19.2** (optional - will be downloaded automatically)

## Quick Start

### Option 1: Run Minecraft Client (Recommended for Development)
```powershell
.\gradlew.bat runClient
```
This will:
- Download Minecraft 1.19.2 if needed
- Download Fabric Loader and Fabric API
- Build your mod
- Launch Minecraft with your mod loaded

### Option 2: Run Minecraft Server
```powershell
.\gradlew.bat runServer
```
This will launch a test server with your mod loaded.

### Option 3: Build the Mod JAR
```powershell
.\gradlew.bat build
```
The compiled mod JAR will be in `build/libs/risingheroes-1.0.0.jar`

## First Time Setup

1. **Ensure Java 17 is installed and set as default:**
   ```powershell
   java -version
   ```
   Should show version 17 or higher.

2. **If Java 17 isn't default, set JAVA_HOME:**
   ```powershell
   $env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
   ```

3. **Run the client:**
   ```powershell
   .\gradlew.bat runClient
   ```

## What to Expect

- First run will download dependencies (this may take a few minutes)
- Minecraft will launch with Fabric Loader
- Your mod will be automatically loaded
- Look for the "Rising Heroes" creative tab with your Cardinal items!

## Troubleshooting

**Java version error:**
- Install Java 17 from [Adoptium](https://adoptium.net/)
- Set JAVA_HOME environment variable

**Build fails:**
- Make sure you're in the project directory
- Run `.\gradlew.bat clean` then try again

**Mod not showing in game:**
- Check the logs in the `run/logs/` folder
- Make sure all items are registered correctly

