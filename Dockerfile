FROM openjdk:14
RUN mkdir /code
ADD ./target/gateway-0.0.1-SNAPSHOT.jar /code
WORKDIR /code
CMD ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]
