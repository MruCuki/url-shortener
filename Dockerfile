# Use AdoptOpenJDK 17 as base image
FROM openjdk:17

# Copy the JAR file into the container
COPY ./target/*.jar url-shortener.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8081

# Command to run the Spring Boot application
CMD ["java", "-jar", "/url-shortener.jar"]
