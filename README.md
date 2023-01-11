# Spring Boot Bootstrap Starter Template

## Description
- Its a spring boot starter template with db connections, controllers, services, repositories, exception handling, error and log handling
- It uses postgres as the database
- It includes CRUD Apis and health api to check the status of the application
- It also includes Global Response and Exception handlers

## Getting Started

### Requriements
- Java 8

### Dependencies
- Spring Boot
- Spring Data JPA
- Spring Web
- postgresql
- lombok

### Installing
- Clone the repository
- Create the configuration file and add these variables as environment variables 
-------------------
- DATABASE_URL = your postgres db url. it running from local you can use this url if your postgres runs on `5432` port `jdbc:postgresql://localhost:5432`
- DATABASE_USERNAME = your postgres db username
- DATABASE_PASSWORD = your postgres db password
- DATABASE_NAME = your postgres db name
-------------------

- Run the application
