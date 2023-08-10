#Packaging
FROM openjdk:latest
VOLUME /tmp
COPY /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]


