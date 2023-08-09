#Build Stage
FROM gradle:latest AS build
COPY . .
RUN gradle build

#Packaging
FROM openjdk:latest
COPY --from=build /target/OneForAll-0.0.1-SNAPSHOT.jar app.jar

#Environment Config
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]


