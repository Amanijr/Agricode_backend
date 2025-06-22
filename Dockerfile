# ----- Stage 1: Build with Maven -----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom and src first
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# ----- Stage 2: Run the application with only JDK -----
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy built jar from the previous stage
COPY --from=build /app/target/AgricodeApp-*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
