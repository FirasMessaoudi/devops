FROM openjdk:8-jdk-alpine
LABEL maintainer ="firas_messaoudi@outlook.fr"
ARG JAR_FILE=target/docker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8089
