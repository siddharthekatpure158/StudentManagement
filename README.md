🎓 Student Management System (JDBC + Java)
📌 Project Overview

The Student Management System is a Java-based console/web application developed using Core Java and JDBC.
It allows users to perform complete CRUD operations (Create, Read, Update, Delete) on student records stored in a relational database.

This project demonstrates practical implementation of:

JDBC connectivity

SQL operations

Database integration

Exception handling

Clean layered architecture

🚀 Features

➕ Add new student

📋 View all students

🔍 Search student by ID

✏️ Update student details

❌ Delete student record

🔐 Input validation & exception handling

🗄️ MySQL database integration

🛠️ Tech Stack

Java (Core Java)

JDBC

MySQL

SQL

Eclipse IDE

Apache Tomcat (if web-based)

🗂️ Project Structure
StudentManagement/
│
├── src/
│   ├── model/
│   │   └── Student.java
│   ├── dao/
│   │   └── StudentDAO.java
│   ├── util/
│   │   └── DBConnection.java
│   └── main/
│       └── MainApp.java
│
└── database/
    └── student.sql
🗄️ Database Schema
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100),
    marks DOUBLE
);
🔗 JDBC Workflow Used

Load Driver

Establish Connection

Create PreparedStatement

Execute Query

Process ResultSet

Close Connection
