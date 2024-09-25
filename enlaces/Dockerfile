FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/enlaces-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_enlaces.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_enlaces.jar"]