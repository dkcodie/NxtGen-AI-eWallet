FROM openjdk:21-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ewallet.jar
ENTRYPOINT ["java", "-jar", "/ewallet.jar"]
