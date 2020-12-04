# Author: Giri Jeedigunta
# Git: https://github.com/giri-jeedigunta/java-spring-mongo-starter-reactive
# Multi-Stage Docker

FROM openjdk:14-jdk-alpine as builder

WORKDIR /app

ENV GRADLE_USER_HOME /cache

COPY gradle/ ./gradle/
COPY gradlew ./
RUN ./gradlew --no-daemon wrapper

COPY build.gradle settings.gradle ./
COPY src/ src/
RUN ./gradlew --no-daemon assemble

FROM openjdk:14-jdk-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar .
#ADD build/libs/*.jar ReactiveRESTfulStarterApp-1.0.jar

EXPOSE 4000

ENV JAVA_XMS=-Xms1024m
ENV JAVA_XMX=-Xmx1024m

ENTRYPOINT java $JAVA_XMS $JAVA_XMX -jar SpringReactiveRESTApiServer-1.0.jar