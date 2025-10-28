@echo off
echo === 后端服务验证 ===
echo.

echo 1. 检查服务状态...
curl -s http://localhost:8080/status | findstr "status"
if %errorlevel% neq 0 (
    echo ❌ 服务状态检查失败
) else (
    echo ✅ 服务状态正常
)
echo.

echo 2. 检查中国数据接口...
curl -s http://localhost:8080/api/chart-data/cn | findstr "indices"
if %errorlevel% neq 0 (
    echo ℹ️ 中国数据接口返回空数据（正常，尚未上传数据）
) else (
    echo ✅ 中国数据接口正常
)
echo.

echo 3. 检查首页...
curl -s http://localhost:8080/ | findstr "股票回溯策略"
if %errorlevel% neq 0 (
    echo ❌ 首页加载失败
) else (
    echo ✅ 首页加载正常
)
echo.

echo 验证完成！
echo 现在可以在浏览器中访问：
echo - 主页: http://localhost:8080/
echo - API测试: http://localhost:8080/api-test
echo - 服务状态: http://localhost:8080/status

pause