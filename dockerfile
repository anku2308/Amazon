FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Pre-download dependencies to speed up execution
RUN mvn clean install -DskipTests

# Run Maven tests and pass the environment flag to our BaseTest
CMD ["mvn", "test", "-Dexecution_env=docker"]