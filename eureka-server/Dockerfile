FROM openjdk:17-jdk-alpine
LABEL authors="Eugene Elantsev"
MAINTAINER blinktreeman@gmail.com

COPY target/eureka-server-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]