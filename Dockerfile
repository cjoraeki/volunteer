FROM openjdk:11
EXPOSE 8080
ADD target/volunteer-images.jar volunteer-images.jar
ENTRYPOINT ["java", "-jar", "volunteer-images.jar"]
