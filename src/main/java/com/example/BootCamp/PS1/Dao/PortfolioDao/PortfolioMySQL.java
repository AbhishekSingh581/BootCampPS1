package com.example.BootCamp.PS1.Dao.PortfolioDao;

import com.example.BootCamp.PS1.Model.CombinationPrimaryKey.UserStockId;
import com.example.BootCamp.PS1.Model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PortfolioMySQL")
public class PortfolioMySQL implements PortfolioDaoInterface{

    @Autowired
    private PortfolioJPARepo portfolioJPARepo;
    @Override
    public Optional<Portfolio> gettingUserStockDataById(UserStockId userStockId) {
        return portfolioJPARepo.findById(userStockId);
    }

    @Override
    public int updatingPortfolio(Portfolio updatedPortfolio) {
        try{
            portfolioJPARepo.save(updatedPortfolio);
            return 1;
        }
        catch (Exception e){
            System.err.println("Error: "+e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Portfolio> gettingHoldingsListByUserId(long userId) {
//        Optional<List<Portfolio>> listOptional=portfolioJPARepo.
        return portfolioJPARepo.findByUserStockIdUserId(userId);
    }

    @Override
    public int deletingHoldingByUserStockId(UserStockId userStockId) {
        try{
            portfolioJPARepo.deleteById(userStockId);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }


}
