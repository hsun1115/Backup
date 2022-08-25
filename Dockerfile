#define base image
FROM openjdk:8
LABEL maintainer="bakcup.net"
ADD target/Backup-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]