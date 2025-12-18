# Stop all running Spring Boot services
Write-Host "Stopping all Spring Boot services..." -ForegroundColor Yellow
Get-Process -Name "java" -ErrorAction SilentlyContinue | Where-Object { $_.CommandLine -like "*spring-boot*" } | Stop-Process -Force
Write-Host "All services stopped!" -ForegroundColor Green

# Wait a moment
Start-Sleep -Seconds 2

# Start Discovery Service first
Write-Host "`nStarting Discovery Service (Eureka)..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\FerraaSara\Documents\GitHub\JEE\discovery-service'; ..\mvnw spring-boot:run"

# Wait for Discovery Service to start
Write-Host "Waiting 20 seconds for Discovery Service to initialize..." -ForegroundColor Yellow
Start-Sleep -Seconds 20

# Start Gateway Service
Write-Host "`nStarting Gateway Service..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\FerraaSara\Documents\GitHub\JEE\gateway-service'; ..\mvnw spring-boot:run"

# Wait a bit
Start-Sleep -Seconds 5

# Start Customer Service
Write-Host "`nStarting Customer Service..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\FerraaSara\Documents\GitHub\JEE\customer-service'; ..\mvnw spring-boot:run"

# Start Inventory Service
Write-Host "`nStarting Inventory Service..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\FerraaSara\Documents\GitHub\JEE\inventory-service'; ..\mvnw spring-boot:run"

# Start Compte Service
Write-Host "`nStarting Compte Service..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\FerraaSara\Documents\GitHub\JEE\compte-service'; ..\mvnw spring-boot:run"

Write-Host "`n========================================" -ForegroundColor Green
Write-Host "All services are starting!" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host "`nCheck Eureka Dashboard in 30-60 seconds:" -ForegroundColor Yellow
Write-Host "http://localhost:8761" -ForegroundColor Cyan
Write-Host "`nService Ports:" -ForegroundColor Yellow
Write-Host "  - Discovery (Eureka): 8761" -ForegroundColor White
Write-Host "  - Gateway:            8888" -ForegroundColor White
Write-Host "  - Customer:           8082" -ForegroundColor White
Write-Host "  - Inventory:          8083" -ForegroundColor White
Write-Host "  - Compte:             8081" -ForegroundColor White
