FROM openjdk:latest

COPY ./target/jenkins-demo-java-0.0.1-SNAPSHOT.jar /

WORKDIR /

CMD ["java", "-jar", "jenkins-demo-java-0.0.1-SNAPSHOT.jar"]