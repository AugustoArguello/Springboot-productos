FROM openjdk:17
VOLUME /tmp
ADD ./target/springboot-servicios-usuarios-0.0.1-SNAPSHOT.jar usuarios.jar
ENTRYPOINT ["java","-jar","/usuarios.jar"]