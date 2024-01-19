package com.example.BootCamp.PS1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class HoldingsDTO {
    private String stockId;
    private String stockName;
    private int quantity;
    private BigDecimal buyPrice;
    private BigDecimal currentPrice;
    private BigDecimal GainOrLoss;

    public HoldingsDTO(){}
    public HoldingsDTO(String stockId, String stockName, int quantity, BigDecimal buyPrice, BigDecimal currentPrice, BigDecimal gainOrLoss) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.currentPrice = currentPrice;
        GainOrLoss = gainOrLoss;
    }
}
