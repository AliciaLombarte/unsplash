FROM openjdk:11

MAINTAINER Alicia Lombarte <alicia.lombarte.garcia@gmail.com>

WORKDIR /usr/app

COPY ./target/collections-0.0.1-SNAPSHOT.jar backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/app/backend.jar"]