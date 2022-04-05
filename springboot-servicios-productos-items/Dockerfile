FROM openjdk:17
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-servicios-productos-items-0.0.1-SNAPSHOT.jar productos-items.jar
ENTRYPOINT ["java","-jar","/productos-items.jar"]