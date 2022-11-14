FROM eclipse-temurin:17
RUN mkdir -p /opt/app
ARG FILE=target/*.jar
COPY ${FILE} /opt/app
CMD ["java", "-jar", "/opt/app/${FILE}"]

