FROM openjdk:14-jdk-alpine

WORKDIR /app

ADD build/libs/*.jar ReactiveRESTStarterApp-1.0.jar

EXPOSE 8083

ENV JAVA_XMS=-Xms1024m
ENV JAVA_XMX=-Xmx1024m

ENTRYPOINT java -Djava.security.egd=file:/dev/urandom $JAVA_XMS $JAVA_XMX -jar ReactiveRESTStarterApp-1.0.jar