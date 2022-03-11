FROM openjdk:1.8
COPY target/bamcoreport.jar bamcoreport.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]