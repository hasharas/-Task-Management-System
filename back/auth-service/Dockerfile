FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/auth-service-0.0.1-SNAPSHOT.jar app.jar

#port hare
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
