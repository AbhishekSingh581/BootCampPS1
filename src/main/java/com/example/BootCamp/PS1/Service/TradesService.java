package com.example.BootCamp.PS1.Service;

import com.example.BootCamp.PS1.ApiResponse.PostTradeResponse;
import com.example.BootCamp.PS1.ApiResponse.gettingStockOptionalResponse;
import com.example.BootCamp.PS1.Dao.TradesDao.TradesDaoInterface;
import com.example.BootCamp.PS1.Model.CombinationPrimaryKey.UserStockId;
import com.example.BootCamp.PS1.Model.Enum.TradeType;
import com.example.BootCamp.PS1.Model.Portfolio;
import com.example.BootCamp.PS1.Model.Stock;
import com.example.BootCamp.PS1.Model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TradesService {
    @Autowired
    @Qualifier("TradesMySQL")
    private TradesDaoInterface tradesDaoInterface;

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private StocksService stocksService;

    public ResponseEntity<PostTradeResponse> insertingTradeTransaction(Trade trade){
        UserStockId userStockId=new UserStockId(trade.getUserId(),trade.getStockId());
        Optional<Portfolio> portfolioOptional=portfolioService.gettingPortfolioDataByID(userStockId);
        TradeType tradeType = TradeType.valueOf(trade.getTradeType().name());
        gettingStockOptionalResponse stockResponse= stocksService.gettingStockByStockId(trade.getStockId());
        if(stockResponse.getStockOptional().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new PostTradeResponse("Failed",stockResponse.getErrorMessage()));
        }
        Stock stock=stockResponse.getStockOptional().get();
        Portfolio portfolio;
        portfolio = portfolioOptional.orElseGet(() -> new Portfolio(userStockId, 0, BigDecimal.ZERO));
        if(tradeType==TradeType.Sell){
            if(portfolio.getQuantity()-trade.getQuantity()<0){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new PostTradeResponse("Failed","User don't hold sufficient stock's quantity."));
            }
            else if(portfolio.getQuantity()-trade.getQuantity()==0){
                portfolioService.deletingPortFolioByUserStockId(userStockId);
            }
            else{
                Portfolio updatedPortfolio=new Portfolio(userStockId,(portfolio.getQuantity()-trade.getQuantity()),portfolio.getBuyPrice());
                portfolioService.updatingPortfolio(updatedPortfolio);
            }
        }
        else{
            BigDecimal portfolioQuantity = BigDecimal.valueOf(portfolio.getQuantity());
            BigDecimal portfolioBuyPrice = portfolio.getBuyPrice();
            BigDecimal portfolioProduct = portfolioQuantity.multiply(portfolioBuyPrice);
            BigDecimal stockCurrentPrice=stock.getClosePrice();
            BigDecimal newStockQuantity=BigDecimal.valueOf(trade.getQuantity());
            BigDecimal newStockProduct=stockCurrentPrice.multiply(newStockQuantity);
            BigDecimal totalStockPrice=portfolioProduct.add(newStockProduct);
            BigDecimal averageStockPrice=totalStockPrice.divide(portfolioQuantity.add(newStockQuantity));
            Portfolio updatedPortfolio=new Portfolio(userStockId,(portfolio.getQuantity()+trade.getQuantity()),averageStockPrice);
            portfolioService.updatingPortfolio(updatedPortfolio);
        }
        System.out.println(trade);
        return tradesDaoInterface.addingTradetransaction(trade);
    }
}
