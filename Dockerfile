FROM openjdk:11K
COPY target/bamcoreport.jar bamcoreport.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]