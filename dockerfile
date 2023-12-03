FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY ${JAR_FILE} weatherprediction-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/weatherprediction-0.0.1-SNAPSHOT.jar"]