FROM ubuntu:latest
LABEL authors="gulnarashaykhutdinova"
FROM openjdk:17-jdk
WORKDIR /app
COPY build/libs/transfer-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5500
ENTRYPOINT ["java", "-jar", "app.jar"]