FROM openjdk:17-jdk-alpine
EXPOSE 3000
ADD ./target/weatherAPI-springboot.jar weatherAPI-springboot.jar

ENTRYPOINT [ "java", "-jar", "/weatherAPI-springboot.jar" ]