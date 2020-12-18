FROM openjdk:8-alpine
EXPOSE 8091
ARG WORKSPACE
RUN mkdir -p /u01/data
COPY $WORKSPACE/target/restaurent-service-0.0.1-SNAPSHOT.jar /u01/data
RUN chmod -R 777 /u01
ENTRYPOINT ["java","-jar","/u01/data/restaurent-service-0.0.1-SNAPSHOT.jar"]
