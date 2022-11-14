FROM eclipse-temurin:17
RUN mkdir /opt/app
ARG FILE=target/*.jar
COPY $FILE /opt/app
CMD ["java", "-jar", "/opt/app/$FILE"]

