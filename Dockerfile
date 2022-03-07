FROM openjdk:11-alpine
COPY target/bamcoreport.jar bamcoreport.jar
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]