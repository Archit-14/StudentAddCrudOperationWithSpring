A full-stack Student Management System built with Spring Boot (backend) and HTML/CSS/JS (frontend).
It supports CRUD operations, search, partial updates, and dynamic table-based display of students.

*** Features

Add new students (with auto-generated custom IDs)
Fetch all students
Search by Name or Course
Update entire student record
Update course only (partial update)
Delete a single student
Delete all students
Dynamic table display on frontend
Responsive UI with basic CSS styling




*** Technology Stack

Layer	Technology 
Backend	:-- Java, Spring Boot, Spring Data JPA, Hibernate
Database :--	PostgreSQL / H2 (any relational DB can be used)
Frontend :--	HTML, CSS, JavaScript (Fetch API)
Build Tool :--	Maven



*****Project Structure
student-management/
│
├─ src/main/java/com/jsp/studentadd/
│   ├─ controller/
│   ├─ service/
│   ├─ repository/
│   ├─ entity/
│   ├─ exception/
│   └─ configuration/
│
├─ src/main/resources/static/
│   ├─ index.html
│   ├─ css/student.css
│   └─ js/student.js
│
├─ src/main/resources/application.properties
└─ pom.xml



***Notes

IDs are auto-generated using Hibernate + a custom ID generator.
CORS is enabled in the controller for local development.
The project is for learning and practice; not production-ready.
