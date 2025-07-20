# -------- Stage 1: Build --------
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# -------- Stage 2: Runtime --------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
#ENTRYPOINT ["sh", "-c", "env && sleep 3600"]
ENTRYPOINT ["java", "-jar", "app.jar"]
