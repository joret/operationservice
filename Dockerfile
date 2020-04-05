FROM adoptopenjdk:11-jre-openj9
EXPOSE 8080
RUN mkdir /opt/app
COPY target/arithmeticservice-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/arithmeticservice-0.0.1-SNAPSHOT.jar"]


