# Stage 1: Build the Java application
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Create a runtime image
# FROM eclipse-temurin:17
FROM amazoncorretto:21.0.1-alpine
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/url-shortener-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
