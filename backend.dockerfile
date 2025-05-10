FROM maven:3.9.9-eclipse-temurin-23 AS builder
WORKDIR /backend
COPY ./pom.xml /backend
RUN mvn dependency:go-offline
COPY . /backend
RUN mvn package

FROM openjdk:23-slim-bookworm
WORKDIR /backend
COPY --from=builder /backend/target/backend-api.jar /backend/backend-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/backend/backend-api.jar"]