FROM eclipse-temurin:17
mkdir /opt/app
FILE=target/*.jar
COPY $FILE /opt/app
CMD ["java", "-jar", "/opt/app/$FILE"]

