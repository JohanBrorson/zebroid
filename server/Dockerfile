FROM openjdk:11

COPY target/zebroid-server-*.jar /home/zebroid-server.jar
CMD ["java", "-Ddatabase.host=redis", "-jar", "/home/zebroid-server.jar"]
