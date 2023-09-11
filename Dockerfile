FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/clinic_history_ms.jar clinic_history_ms.jar
ENTRYPOINT ["java", "-jar", "/clinic_history_ms.jar"]
