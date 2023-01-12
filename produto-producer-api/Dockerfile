FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/producer
COPY ${JAR_FILE} producer-app.jar
ENTRYPOINT ["java","-jar","producer-app.jar"]
EXPOSE 8081
