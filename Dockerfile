#Build Stage
FROM gradle:latest
RUN gradle build

#Beta
FROM openjdk:latest
EXPOSE 8080
ADD build/libs/OneForAll-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
