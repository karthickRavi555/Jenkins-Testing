FROM openjdk:8
MAINTAINER karthick <karthiravi02@gmail.com>
ADD target/docker-account.jar docker-account.jar
EXPOSE 9009
ENTRYPOINT ["java", "-jar", "docker-account.jar"]


