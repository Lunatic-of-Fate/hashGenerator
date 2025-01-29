FROM openjdk:22-jdk-slim
COPY build/libs/hashGenerator.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]