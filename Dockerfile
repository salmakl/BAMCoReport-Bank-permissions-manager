FROM openjdk:17
COPY target/bamcoreport.jar bamcoreport.jar
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]