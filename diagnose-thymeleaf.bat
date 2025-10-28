@echo off
echo === Thymeleaf 诊断 ===
echo.

echo 1. 检查模板目录...
dir src\main\resources\templates\*.html /b
echo.

echo 2. 检查 Thymeleaf 依赖...
mvn dependency:tree | findstr thymeleaf
echo.

echo 3. 测试 REST 端点...
curl -s http://localhost:8080/ | findstr "status"
if %errorlevel% equ 0 (
    echo ✅ REST 端点正常
) else (
    echo ❌ REST 端点异常
)
echo.

echo 4. 测试模板端点...
curl -s http://localhost:8080/home | findstr "DOCTYPE"
if %errorlevel% equ 0 (
    echo ✅ 模板端点返回 HTML
) else (
    echo ❌ 模板端点异常
    curl -s http://localhost:8080/home | head -5
)
echo.

echo 诊断完成！
pause