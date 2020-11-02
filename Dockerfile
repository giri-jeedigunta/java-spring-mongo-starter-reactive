# Author: Giri Jeedigunta
# Git: https://github.com/giri-jeedigunta/java-spring-mongo-starter-reactive

FROM openjdk:14-jdk-alpine

WORKDIR /app

ADD build/libs/*.jar ReactiveRESTfulStarterApp-1.0.jar

EXPOSE 4000

ENV JAVA_XMS=-Xms1024m
ENV JAVA_XMX=-Xmx1024m

ENTRYPOINT java -Djava.security.egd=file:/dev/urandom $JAVA_XMS $JAVA_XMX -jar ReactiveRESTfulStarterApp-1.0.jar