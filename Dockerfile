FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/* ./docker-spring-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","docker-spring-1.0-SNAPSHOT.jar"]