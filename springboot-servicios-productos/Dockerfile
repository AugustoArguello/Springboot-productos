FROM openjdk:17
VOLUME /tmp
ADD ./target/springboot-servicios-productos-0.0.1-SNAPSHOT.jar servicio-productos.jar
ENTRYPOINT ["java","-jar","/servicio-productos.jar"]