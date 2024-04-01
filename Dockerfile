FROM openjdk:8
ADD build/libs/gradle-build-scan-quickstart.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]

