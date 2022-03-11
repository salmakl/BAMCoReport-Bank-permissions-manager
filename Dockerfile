FROM openjdk:11
COPY target/bamcoreport.jar bamcoreport.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]