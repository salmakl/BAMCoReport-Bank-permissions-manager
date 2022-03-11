FROM openjdk:11
COPY jar/bamcoreport.jar /bamcoreport.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]