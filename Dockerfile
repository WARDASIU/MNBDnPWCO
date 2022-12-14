FROM openjdk:11
ADD target/Mnbd-0.0.1-SNAPSHOT.jar Mnbd-0.0.1-SNAPSHOT.jar.original
EXPOSE 8085
RUN ["javac", "JavaExample.java"]
ENTRYPOINT ["java", "-jar", "Mnbd-0.0.1-SNAPSHOT.jar"]