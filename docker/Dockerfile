FROM openjdk:8-jdk-alpine

MAINTAINER "lostlang"

ARG JAR_FILE=docker-0.0.1-SNAPSHOT.jar
ARG PROFILE=qa
ENV PROFILE="${PROFILE}"

EXPOSE 8081

WORKDIR /app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

CMD ["--spring.profiles.active=${PROFILE}"]