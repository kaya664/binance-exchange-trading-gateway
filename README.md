# binance-exchange-trading-gateway
Binance Trading Gateway

## Environment Setup
In order to run the project, you need to have JDK 11, Maven, and Docker.

Build the project:
```shell
mvn package -DskipTests=true
```

Dockerize application:
```shell
docker build -t binance-trading-gateway:latest .
```
