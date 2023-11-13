# Link Shortener Spring Boot Application

## Description
This is a simple Spring Boot application designed for shortening URLs. 
It allows users to generate short links for long URLs, making them easier to share.

## Features
- Shorten long URLs to unique, easily shareable short links.
- Redirect users from short links to the original long URLs.

## Prerequisites
- Java 8 or later
- Maven (for building and packaging)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/orkhan-mammadov/linkShortener
    ```

2. Navigate to the project directory:

    ```bash
    cd linkShortener
    ```

3. Build the application:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/linkShortener-0.0.1-SNAPSHOT.jar
    ```

## Configuration

### Database Configuration
H2 database is configured by default.
But you may configure the database connection settings in `src/main/resources/application.properties`.
You may need to create a database schema before running the application in case of custom configuration.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/link_shortener
spring.datasource.username=root
spring.datasource.password=root_password
```

### Usage
Access the application at http://localhost:8080/.
Shorten a URL by providing the original URL.
Copy and share the generated short link.

### Contact
For issues or inquiries, please contact the project maintainers:

### Contributors
Orkhan Mammadov: orkhan.mammadov19@gmail.com
