# device-api

REST API for managing devices with CRUD operations
## Features
-create a new device
-update an existing device
-fetch a single device by id
-fetch devices by brand
-fetch devices by state
-delete a device

### Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- Maven

### How to Run
1. Start PostgreSQL (Docker), port 5432
2. Run application
3. Use Postman to test APIs

### API Endpoints

POST /devices  
GET /devices  
GET /devices/{id}
GET /devices/brand/{brand}
GET /devices/state/{state}
PUT /devices/{id}  
DELETE /devices/{id}  

### Business Rules
-Devices in IN_USE state cannot be deleted
-creationTime is automatically generated
-creationTime cannot be updated once created