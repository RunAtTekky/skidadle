# Multi-stage build for Spring Boot backend

# Stage 1: Build the application
FROM gradle:8.11-jdk21 AS build

WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradle gradle
COPY gradlew .
COPY settings.gradle .
COPY build.gradle .

# Make gradlew executable
RUN chmod +x gradlew

# Download dependencies (this layer will be cached)
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build the application (creates jar in build/libs/)
RUN ./gradlew bootJar --no-daemon

# Stage 2: Runtime image
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
