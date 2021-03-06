FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
EXPOSE 8080
COPY build/libs/RestApiDemo-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]