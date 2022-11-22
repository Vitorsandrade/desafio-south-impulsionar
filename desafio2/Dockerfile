FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/projeto-south-vitor.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
