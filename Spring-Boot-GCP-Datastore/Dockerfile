#
# Build stage
#
#FROM maven:3.5.2-jdk-8-alpine as BUILD
#FROM adoptopenjdk/openjdk11:latest as BUILD
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

#
# Package stage
#
#FROM openjdk:8-jre-alpine
#FROM adoptopenjdk/openjdk11:latest
FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar  application.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev,datastore", "/application.jar"]