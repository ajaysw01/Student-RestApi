# Student CRUD REST API

## Description

This project implements a RESTful API for managing student records using Spring Boot. It provides endpoints for performing CRUD operations on student data stored in a relational database.

## Features

- **Create**: Add a new student to the database.
- **Read**: Retrieve student details by ID or fetch all students.
- **Update**: Update existing student information.
- **Delete**: Remove a student from the database.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (for local development; can be configured for other RDBMS)
- Maven

## API Endpoints

### Students

- **POST /api/students**
  - Create a new student.
  - Request Body: JSON representing student details.

- **GET /api/students**
  - Retrieve all students.

- **GET /api/students/{id}**
  - Retrieve a student by ID.

- **PUT /api/students/{id}**
  - Update a student's details by ID.
  - Request Body: JSON representing updated student details.

- **DELETE /api/students/{id}**
  - Delete a student by ID.

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Student-RestApi.git
   cd repository
   ```

2. **Configure the database:**
   - Modify `application.properties` to set up your database configuration.

3. **Run the application:**
   - Use your IDE or Maven to build and run the application.

4. **Test the API:**
   - Use Postman or any HTTP client to test all endpoints.
   - Ensure proper HTTP methods, request bodies, and responses.

## Contributors

- [Ajay Wankhade](https://github.com/ajaysw01)
