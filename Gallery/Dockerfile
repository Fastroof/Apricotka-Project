FROM openjdk:8-alpine
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} gallery.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/gallery.war"]