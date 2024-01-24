In application.properties
Enter you mysql password to run the application.

Updating Stocks {PUT API}: localhost:8080/api/v1/stocks/updatingStocks

Getting Stock by StockId {GET API}: localhost:8080/api/v1/stocks/{stockId}

Posting Trade data {POST API}: localhost:8080/api/v1/trade/newTrade

Getting Portfolio of User by UserId {GET API}: localhost:8080/api/v1/portfolio/{userId}


Created a Enum which is TradeType:
The trade type in posting trade object takes only 
  1) 0: Buy
  2) 1: Sell
