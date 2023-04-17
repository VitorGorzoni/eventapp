FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /target/eventapp-0.0.1-SNAPSHOT.jar eventapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","eventapp.jar"]
