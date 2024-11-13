# Fitness Website

Maven-based Web Application
Project Setup
###Cloning the Repository

To start with the project, clone this repository to your local machine:

git clone (https://github.com/Abhishek-42/Webapp_prj)

## Project Structure

    src/main/java: Java source code, including the DAO classes for database operations.
    src/main/webapp: JSP files and static resources like CSS/JS.
    src/main/resources: Configuration files, including database settings.
    pom.xml: Maven configuration file with dependencies.

### Database Setup

    Create a new MySQL database.
    Run the provided SQL scripts (if available) to set up the tables and schema.
    Update the database credentials in the configuration files as needed.

## Project Requirements
### Prerequisites

    Java Development Kit (JDK): Version 8 or higher
    Maven: Version 3.x
    MySQL Server: For database management
    Apache Tomcat: Version 9 or compatible for local deployment
    IDE (e.g., Eclipse or IntelliJ): Optional but recommended

### Dependencies

All dependencies are managed by Maven. When you build the project, Maven will automatically download the necessary libraries, specified in pom.xml.
How to Run the Project

    Build the Project
    Open the terminal in the project’s root directory and use:

mvn clean install

### Configure Database
Ensure the MySQL database is running, and the necessary tables are created. Verify the database credentials are correctly set in the application configuration.

Deploy on Tomcat

    Deploy the project to a local Tomcat server from your IDE or manually copy the .war file to the Tomcat webapps directory.
    Start the Tomcat server.

Access the Application
Once the server is running, access the application in a web browser at:

  `http://localhost:8080/sitepkg/`

## Usage

Register in the website , such as:

    First go into login page then click on (not registered yet ) and go in registeration page .
    Then type your detailes and register to the website 
    Then the registration details will be stored in database . which you can see in workbench or cmd.
