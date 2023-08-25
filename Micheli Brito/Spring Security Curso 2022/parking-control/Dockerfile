FROM openjdk:19
COPY /target/parking-control-0.0.1-SNAPSHOT.jar /usr/src/parking-control/
WORKDIR /usr/src/parking-control/
EXPOSE 8080:8080
ENTRYPOINT java -jar parking-control-0.0.1-SNAPSHOT.jar