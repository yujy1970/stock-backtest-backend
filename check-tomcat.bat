@echo off
echo === Tomcat Startup Diagnosis ===
echo.

echo 1. Check port occupancy:
echo Check port 8080:
netstat -ano | findstr :8080
echo.
echo Check port 8081:
netstat -ano | findstr :8081
echo.

echo 2. Check Spring Boot Web dependency:
mvn dependency:tree | findstr spring-boot-starter-web
echo.

echo 3. Check Tomcat dependency:
mvn dependency:tree | findstr tomcat
echo.

echo 4. Try to compile:
mvn clean compile -q
if %errorlevel% equ 0 (
    echo Compilation successful
) else (
    echo Compilation failed
)
echo.

echo Diagnosis completed
pause