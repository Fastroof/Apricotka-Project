FROM openjdk:8-alpine
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} storage.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/storage.war"]