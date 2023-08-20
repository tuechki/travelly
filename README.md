# Travelly Project

Welcome to the Travelly project! This repository contains a Java Spring Maven project for a travel management application.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Clone the Repository](#clone-the-repository)
  - [Configure the Database](#configure-the-database)
  - [Build the Project](#build-the-project)
  - [Run the Application](#run-the-application)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [Git](https://git-scm.com/downloads)

## Getting Started

Follow these steps to set up and run the project locally:

### Clone the Repository

```bash
git clone https://github.com/tuechki/travelly.git
cd travelly

### Configure the Database

1. Create a MySQL database named travelly_db.
2. Update the database configuration in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/travelly_db
spring.datasource.username=your_username
spring.datasource.password=your_password


### Build the Project
Navigate to the project root directory and build the application using Maven:
mvn clean package


### Run the Application
Once the project is built, you can run the application:
java -jar target/travelly-*.jar


The application should now be accessible at http://localhost:8080.


## Contributing
Contributions are welcome! If you find any issues or have improvements to suggest, please open an issue or create a pull request.

## License
This project is licensed under the MIT License.
