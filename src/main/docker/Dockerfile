FROM openjdk:8-jdk-alpine
COPY . /usr/src/javaapp
WORKDIR /usr/java/app
ADD *.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]