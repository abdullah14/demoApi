FROM java:8
EXPOSE 8080
ADD /target/demo.api-0.0.1-SNAPSHOT.jar demo.api.jar
ENTRYPOINT ["java", "-jar", "demo.api.jar"]