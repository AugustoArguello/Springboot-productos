FROM openjdk:17
VOLUME /tmp
EXPOSE 8090
ADD ./target/springboot-servicios-getway-server-0.0.1-SNAPSHOT.jar getway-server.jar
ENTRYPOINT ["java","-jar","/getway-server.jar"]