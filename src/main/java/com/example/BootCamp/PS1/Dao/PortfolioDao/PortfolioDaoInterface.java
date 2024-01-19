package com.example.BootCamp.PS1.Dao.PortfolioDao;

import com.example.BootCamp.PS1.Model.CombinationPrimaryKey.UserStockId;
import com.example.BootCamp.PS1.Model.Portfolio;

import java.util.List;
import java.util.Optional;

public interface PortfolioDaoInterface {
    public Optional<Portfolio> gettingUserStockDataById(UserStockId userStockId);
    public int updatingPortfolio(Portfolio updatedPortfolio);

    public List<Portfolio> gettingHoldingsListByUserId(long userId);

    public int deletingHoldingByUserStockId(UserStockId userStockId);
}
