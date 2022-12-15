FROM openjdk:17

EXPOSE 8080

COPY ADD target/Mnbd-0.0.1-SNAPSHOT.jar Mnbd-0.0.1-SNAPSHOT.jar.original

ENTRYPOINT ["java", "-jar", "Mnbd-0.0.1-SNAPSHOT.jar"]
