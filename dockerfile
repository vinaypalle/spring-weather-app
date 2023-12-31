FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY ${JAR_FILE} /app/weatherprediction-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/weatherprediction-0.0.1-SNAPSHOT.jar"]