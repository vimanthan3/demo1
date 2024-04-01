FROM openjdk:8
ADD build/libs/gradle-build-scan-quickstart.jar sample.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","sample.jar"]

