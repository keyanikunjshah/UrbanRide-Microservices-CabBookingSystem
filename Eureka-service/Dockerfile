FROM openjdk:21

COPY Eureka-service/target/Eureka-service-0.0.1-SNAPSHOT.jar Eureka-service.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/Eureka-service.jar"]
