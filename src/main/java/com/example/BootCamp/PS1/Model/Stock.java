package com.example.BootCamp.PS1.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class Stock {
    @Id
    @Column(name = "Stock_Id")
    private String stockId;
    @Column(name = "Stock_Name")
    private String stockName;
    @Column(name = "Low_Price")
    private BigDecimal lowPrice;
    @Column(name = "High_Price")
    private BigDecimal highPrice;
    @Column(name = "Open_Price")
    private BigDecimal openPrice;
    @Column(name = "Close_Price")
    private BigDecimal closePrice;

    public Stock(){};
    public Stock(String stockId,String stockName, BigDecimal lowPrice, BigDecimal highPrice, BigDecimal openPrice, BigDecimal closePrice) {
        super();
        this.stockId=stockId;
        this.stockName = stockName;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
    }
}
