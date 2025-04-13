FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar
COPY src/main/resources/application.properties application.properties

EXPOSE 8080

CMD ["java", "-jar", "app.jar", "--spring.config.location=file:application.properties"]