
FROM openjdk:21-jre-slim


WORKDIR /app


COPY target/jesustyle-1.0.jar /app/jesustyle-1.0.jar


CMD ["java", "-jar", "/app/jesustyle-1.0.jar"]
