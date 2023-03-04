# binance-exchange-trading-gateway
Binance Trading Gateway

## What's inside
With this gateway application, you can automate your trading strategy for binance cryptocurrency pairs.
It also provides trading for perpetual operations.

##How to call the api
Inside the source code, you can find the NewOrderController class to understand one and only Rest API.
Exposed path is /new.
With the Json payload below, one can sell or buy cryptocurrencies on binance.

```yaml
{
   exchange: "BINANCE",
   ticker: "",
   closePrice: 0,
   volume: 0,
   action: "BUY",
   contractCount: "100",
   orderId: "userFirstOrderId",
   coinType: "NORMAL"
}
```

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
