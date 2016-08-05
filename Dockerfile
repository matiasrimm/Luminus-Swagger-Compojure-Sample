FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/abc.jar /abc/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/abc/app.jar"]
