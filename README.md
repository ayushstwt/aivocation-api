# AiVocation-api

## Overview

The **aivocation-api** project is a Spring Boot 4.0 RESTful service that provides company and contact management functionality. It includes JPA integration, validation, global exception handling, and CORS configuration.

## Build & Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The service starts on `http://localhost:8080` and prefixes all API endpoints with `/api` as configured in `WebConfig`.

## API Documentation (Swagger/OpenAPI)

We have integrated **springdoc‑openapi** to automatically generate OpenAPI specifications and a Swagger UI.

- Swagger UI: <http://localhost:8080/swagger-ui.html>
- OpenAPI JSON: <http://localhost:8080/v3/api-docs>

The documentation reflects all `@RestController` endpoints, including the `/api` prefix.

## Endpoints

- **Company** – CRUD operations for companies (`/api/company`)
- **Contact** – CRUD operations for contacts (`/api/contact`)

Further details can be explored via the Swagger UI.

## Testing

Run the test suite with:

```bash
mvn test
```

All tests should pass after adding the Swagger configuration.
" 
