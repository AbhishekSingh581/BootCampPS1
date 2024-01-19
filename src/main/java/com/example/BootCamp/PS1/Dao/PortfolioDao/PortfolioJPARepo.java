package com.example.BootCamp.PS1.Dao.PortfolioDao;

import com.example.BootCamp.PS1.Model.CombinationPrimaryKey.UserStockId;
import com.example.BootCamp.PS1.Model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioJPARepo extends JpaRepository<Portfolio, UserStockId> {
    List<Portfolio> findByUserStockIdUserId(long userId);
}
