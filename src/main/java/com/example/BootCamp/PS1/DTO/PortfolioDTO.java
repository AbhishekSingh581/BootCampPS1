package com.example.BootCamp.PS1.DTO;

import com.example.BootCamp.PS1.Model.Portfolio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;

@Data

public class PortfolioDTO {
    private List<HoldingsDTO> holdingsDTOList;
    private long totalPortfoliioHoldings;
    private BigDecimal buyPrice;
    private BigDecimal profitLossPercentage;

    public PortfolioDTO(){}
    public PortfolioDTO(List<HoldingsDTO> holdingsDTOList, long totalPortfoliioHoldings, BigDecimal buyPrice, BigDecimal profitLossPercentage) {
        super();
        this.holdingsDTOList = holdingsDTOList;
        this.totalPortfoliioHoldings = totalPortfoliioHoldings;
        this.buyPrice = buyPrice;
        this.profitLossPercentage = profitLossPercentage;
    }
}
