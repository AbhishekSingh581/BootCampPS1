package com.example.BootCamp.PS1.Service;

import com.example.BootCamp.PS1.DTO.HoldingsDTO;
import com.example.BootCamp.PS1.DTO.PortfolioDTO;
import com.example.BootCamp.PS1.Dao.PortfolioDao.PortfolioDaoInterface;
import com.example.BootCamp.PS1.Model.CombinationPrimaryKey.UserStockId;
import com.example.BootCamp.PS1.Model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    @Qualifier("PortfolioMySQL")
    private PortfolioDaoInterface portfolioDaoInterface;

    public Optional<Portfolio> gettingPortfolioDataByID(UserStockId userStockId){
        return portfolioDaoInterface.gettingUserStockDataById(userStockId);
    }

    public int updatingPortfolio(Portfolio updatedPortfolio){
        return portfolioDaoInterface.updatingPortfolio(updatedPortfolio);
    }

    public ResponseEntity<PortfolioDTO> gettingUserPortfolioByUserId(long userId){
        List<Portfolio> portfolioList= portfolioDaoInterface.gettingHoldingsListByUserId(userId);
        List<HoldingsDTO> holdingsDTOList=new ArrayList<>();
        long totalPortfolioHoldings=0;
        BigDecimal totalBuyPrice=BigDecimal.ZERO;
        BigDecimal totalCurrentPrice=BigDecimal.ZERO;
        for(Portfolio portfolio:portfolioList){
            HoldingsDTO holding=new HoldingsDTO(portfolio.getStock().getStockId(),portfolio.getStock().getStockName(),
                    portfolio.getQuantity(),portfolio.getBuyPrice(),portfolio.getStock().getClosePrice(),portfolio.getBuyPrice().subtract(portfolio.getStock().getClosePrice()));
            holdingsDTOList.add(holding);
            totalPortfolioHoldings=totalPortfolioHoldings+portfolio.getQuantity();
            totalBuyPrice=totalBuyPrice.add(portfolio.getBuyPrice().multiply(BigDecimal.valueOf(portfolio.getQuantity())));
            totalCurrentPrice=totalCurrentPrice.add(portfolio.getStock().getClosePrice().multiply(BigDecimal.valueOf(portfolio.getQuantity())));
//            System.out.println(holding);
        }
        BigDecimal profitLossPercentage = totalCurrentPrice.subtract(totalBuyPrice);
        profitLossPercentage = profitLossPercentage.divide(totalBuyPrice,  MathContext.DECIMAL128);
        profitLossPercentage = profitLossPercentage.multiply(BigDecimal.valueOf(100));
        PortfolioDTO portfolioDTO=new PortfolioDTO(holdingsDTOList,totalPortfolioHoldings,totalBuyPrice,profitLossPercentage);
        return ResponseEntity.ok(portfolioDTO);
    }

    public int deletingPortFolioByUserStockId(UserStockId userStockId){
        return portfolioDaoInterface.deletingHoldingByUserStockId(userStockId);
    }
}
