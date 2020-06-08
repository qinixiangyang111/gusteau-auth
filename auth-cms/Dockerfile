FROM harbor.xinhuaapp.com/noah/openjdk-font:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar