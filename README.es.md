# Users Service

<br>

## 📌 Introducción

El Users Service es responsable de gestionar los datos relacionados con los usuarios dentro del ecosistema de microservicios de la tienda online.

Se encarga de la creación, actualización, eliminación y obtención de usuarios, actuando como la **fuente de la verdad** para la identidad del usuario y su información básica de perfil.

* Este servicio está diseñado siguiendo una arquitectura clásica MVC (Model–View–Controller), adaptada a un contexto de API REST, y cumple con el principio de **Database per Service**.
* El servicio no es dueño de los datos de otros servicios y se comunica mediante service discovery cuando se ejecuta detrás de un API Gateway.

<br>

## 🛠️ Tecnologías

* Java 17  
* Spring Boot 4.0.1  
* Spring Web MVC  
* Spring Data JPA  
* Hibernate  
* Spring Cloud (Netflix Eureka Client)  
* MySQL  
* Lombok  
* Springdoc OpenAPI (Swagger UI)  
* Maven  

<br>

## ✨ Funcionalidades

* Crear un usuario individual
* Creación masiva de usuarios
* Actualizar datos del perfil del usuario
* Eliminar usuarios por ID
* Obtener un usuario por ID
* Obtener todos los usuarios
* Manejo de request/response basado en DTOs
* Documentación Swagger/OpenAPI
* Registro como Eureka Client para descubrimiento de servicios

<br>

## 📎 Nota Importante de Diseño

> **Este servicio no gestiona carritos de compra.**
>
> Solo se almacenan los IDs de los carritos asociados a un usuario, garantizando un bajo acoplamiento entre microservicios.

<br>

## 🧱 Arquitectura (MVC)

El servicio sigue una arquitectura MVC clásica, separando claramente las responsabilidades:

* **Capa Controller**: Expone los endpoints REST y maneja las solicitudes HTTP.
* **Capa Service**: Contiene la lógica de negocio y gestiona las transformaciones DTO ↔ Entity.
* **Capa Repository**: Maneja la persistencia utilizando Spring Data JPA.

Esta estructura mejora la mantenibilidad, escalabilidad y claridad, manteniendo el servicio enfocado como un microservicio CRUD simple.

<br>

## ⚙️ Configuración (application.properties)

El proyecto ya incluye un archivo `application.properties` completamente configurado.
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
⚠️ **Asegurate de que la base de datos `users_service` exista antes de ejecutar el servicio.**

<br>

## ▶️ Cómo Ejecutar el Servicio

### ✅ Requisitos

- Java 17
- Maven
- MySQL
- Eureka Server corriendo en `http://localhost:8761`

<br>

### ▶️ Ejecutar la Aplicación

Desde la raíz del proyecto:

```bash
mvn spring-boot:run
```

<br>

El servicio se iniciará en: http://localhost:8084

<br>

## 🌐 Acceso a los Endpoints

### 🔹 Con API Gateway

Si el API Gateway está en ejecución, las solicitudes deben enrutar a través de él.

Ejemplo:

http://localhost:8080/users-service/users


Este es el enfoque recomendado en un entorno completo de microservicios.

### 🔹 Sin API Gateway (Standalone)

Si el API Gateway no está en ejecución, el servicio puede probarse directamente usando su puerto expuesto.

Ejemplo:

http://localhost:8084/users


Esto es útil para desarrollo, pruebas o para ejecutar el servicio de forma aislada.

<br>

## 📘 Documentación de la API (Swagger)

Una vez que el servicio esté en ejecución, se puede acceder a Swagger UI en:

http://localhost:8084/swagger-ui.html


Todos los endpoints, esquemas de request/response y ejemplos se generan automáticamente usando **Springdoc OpenAPI**.

<br>

## 📚 Lo que Aprendí

- Reforcé el uso de la arquitectura **MVC** en un contexto de microservicios
- Practiqué el diseño de un servicio **CRUD simple y enfocado**
- Gané experiencia práctica documentando APIs con **Swagger/OpenAPI**
- Mejoré la comprensión del uso de **DTOs** y los límites de responsabilidad
- Confirmé el valor de mantener microservicios **pequeños, explícitos y mantenibles**

Aunque técnicamente simple, este servicio ayudó a consolidar principios fundamentales de backend que escalan correctamente en sistemas distribuidos.

<br>

## 🚀 Posibles Mejoras

- Implementar manejo global de excepciones
- Asegurar los endpoints con autenticación y autorización
- Agregar tests unitarios y de integración
