FROM openjdk:8
ADD build/libs/gradle-build-scan-quickstart.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","gradle-build-scan-quickstart.jar"]

