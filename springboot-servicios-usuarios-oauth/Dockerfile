FROM openjdk:17
VOLUME /tmp
EXPOSE 9001
ADD ./target/springboot-servicios.usuarios.oauth-0.0.1-SNAPSHOT.jar usuarios.oauth.jar
ENTRYPOINT ["java","-jar","/usuarios.oauth.jar"]