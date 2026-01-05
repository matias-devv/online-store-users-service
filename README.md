# 👤 Users Service

<br>

## 📌 Introduction

The Users Service is responsible for managing user-related data within the Online Store microservices ecosystem.

It handles user creation, updates, deletion, and retrieval, acting as the source of truth for user identity and basic profile information.

* This service is designed following a classic MVC (Model–View–Controller) architecture, adapted to a REST API context, and adheres to the **Database per Service** principle.
* The service does not own data from other services and communicates through service discovery when running behind an API Gateway.

<br>

## 🛠️ Technologies

* Java 17
* Spring Boot 4.0.1
* Spring Web MVC
* Spring Data JPA
* Hibernate
* Spring Cloud Netflix Eureka Client
* MySQL
* Lombok
* Springdoc OpenAPI (Swagger UI)
* Maven

<br>

## ✨ Features

* Create a single user
* Batch creation of users
* Update user profile data
* Delete users by ID
* Retrieve a user by ID
* Retrieve all users
* DTO-based request/response handling
* Swagger/OpenAPI documentation
* Eureka Client registration for service discovery

<br>

## 📎 Important Design Note

> **This service does not manage shopping carts.**
>
> Only the IDs of shopping carts associated with a user are stored, ensuring loose coupling between microservices.

<br>

## 🧱 Architecture (MVC)

The service follows a classic MVC architecture, clearly separating responsibilities:

* **Controller layer**: Exposes REST endpoints and handles HTTP requests.
* **Service layer**: Contains business logic and manages DTO ↔ Entity transformations.
* **Repository layer**: Handles persistence using Spring Data JPA.

This structure improves maintainability, scalability, and clarity while keeping the service focused as a simple CRUD microservice.

<br>

## ⚙️ Configuration (application.properties)

The project already includes a fully configured `application.properties` file.
<br>
<br>
```properties
# SQL
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/users_service?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Eureka
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

# SpringDoc OpenAPI
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
```

> ⚠️ **Make sure the database `users_service` exists before running the service.**

<br>

## ▶️ How to Run the Service


### ✅ Requirements

* Java 17
* Maven
* MySQL
* Eureka Server running on `http://localhost:8761`

<br>

### ▶️ Run the Application

From the project root:

```bash
mvn spring-boot:run
```

The service will start on:

```
http://localhost:8084
```

<br>

## 🌐 Accessing the Endpoints

### 🔹 With API Gateway

If the API Gateway is running, requests should be routed through it.

Example:

```
http://localhost:8080/users-service/users
```

This is the recommended approach in a full microservices environment.

<br>

### 🔹 Without API Gateway (Standalone)

If the API Gateway is not running, the service can be tested directly using its exposed port.

Example:

```
http://localhost:8084/users
```

This is useful for development, testing, or running the service in isolation.

<br>


## 📘 API Documentation (Swagger)

Once the service is running, access Swagger UI at:

```
http://localhost:8084/swagger-ui.html
```

All endpoints, request/response schemas, and examples are generated automatically using Springdoc OpenAPI.

<br>

## 📚 What I Learned

* Reinforced the use of MVC architecture in a microservice context
* Practiced designing a simple, focused CRUD service
* Gained hands-on experience with Swagger/OpenAPI documentation
* Improved understanding of DTO usage and responsibility boundaries
* Confirmed the value of keeping microservices small, explicit, and maintainable

Although technically simple, this service helped solidify core backend principles that scale well in distributed systems.

## 🚀 Possible Improvements
   
- [ ] Implement global exception handling
- [ ] Secure endpoints with authentication and authorization
- [ ] Add unit and integration tests 
