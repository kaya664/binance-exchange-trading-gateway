# binance-exchange-trading-gateway
Binance Trading Gateway

## What's inside
With this gateway application, you can automate your trading strategy for binance cryptocurrency pairs.
It also provides trading for perpetual operations.

!!!IMPORTANT!!!
When you send BUY or SELL request with 100 contractCount, then application will calculate the commission fee directly and BUY and SELL the right amount.

##How to call the api
Inside the source code, you can find the NewOrderController class to understand one and only Rest API.
Exposed path is /new.

## With the Json payload below, one can sell or buy cryptocurrencies on Binance.

### Payload Fields
                    
Field Name  | Value
------------- | -------------
exchange  | Only supported exchange for now, BINANCE
ticker  | Send empty string
closePrice  |  Send 0
volume  |  Send 0
action  |  BUY or SELL
contractCount  |  Amount you want to buy or sell
orderId  |  User's predefined order id
coinType  | NORMAL or PERPETUAL

### Json Example

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
