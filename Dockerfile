FROM openjdk:8
MAINTAINER karthick <karthiravi02@gmail.com>
ARG JAR=target/AccountManagement-0.0.1-SNAPSHOT.jar
ADD ${JAR} AccountManagement.jar
ENTRYPOINT ["java", "-jar", "/AccountManagement.jar"]
EXPOSE 8761

