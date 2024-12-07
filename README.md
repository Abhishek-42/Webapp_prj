# Maven-Based Web Application

A dynamic web application built using **Java**, **JSP**, **MySQL**, and hosted on **Apache Tomcat**. This project demonstrates a modular approach to web development using the **Maven build tool** for dependency management and project structuring.

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Database Schema](#database-schema)

---

## Overview
This web application serves as a template for projects that involve dynamic content generation, database integration, and modular code structure. It includes:
- **DAO pattern** for database access.
- User-friendly **JSP** pages for front-end design.
- **REST-like architecture** for back-end operations.

---

## Features
- **Dynamic Content Management:** CRUD operations supported.
- **MySQL Database Integration:** Seamless data storage and retrieval.
- **Responsive UI:** JSP-based views for interactive user experience.
- **Modular Codebase:** DAO classes for easy maintainability.
- **Lightweight Hosting:** Runs efficiently on a local Tomcat server.

---

## Technologies Used
- **Programming Language:** Java
- **Front-End:** JSP, HTML, CSS
- **Database:** MySQL
- **Server:** Apache Tomcat
- **Build Tool:** Maven
- **IDE:** Eclipse (or VS Code with appropriate extensions)

---

## Project Structure
```markdown
```
maven-web-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.User.dao/       # Data Access Object classes
│   │   │   ├── com.User.model/     # POJO classes
│   │   │   ├── com.User.servlets/  # Servlet files
│   │   ├── resources/                 # Configuration files
│   │   ├── webapp/
│   │       ├── WEB-INF/               # Deployment descriptor
│   │       ├── views/                 # JSP files
│   ├── test/                          # Test cases
├── pom.xml                            # Maven build configuration
```
```

## Database Schema
### Table: `users`
| Column       | Type        | Description           |
|--------------|-------------|-----------------------|
| `id`         | INT (PK)    | Unique user ID        |
| `username`   | VARCHAR(50) | User's username       |
| `password`   | VARCHAR(100)| Encrypted password    |
| `email`      | VARCHAR(100)| User's email address  |


> The complete schema is located in the `sql/` folder.

### Code of table

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);
