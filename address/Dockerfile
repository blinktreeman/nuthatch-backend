FROM openjdk:17-jdk-alpine
LABEL authors="Eugene Elantsev"
MAINTAINER blinktreeman@gmail.com

COPY target/address-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/app.jar"]