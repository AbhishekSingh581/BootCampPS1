package com.example.BootCamp.PS1.Model.CombinationPrimaryKey;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserStockId implements Serializable {
    @Column(name = "User_Id")
    private long userId;
    @Column(name = "Stock_Id")
    private String stockId;

    public UserStockId(){}
    public UserStockId(long userId, String stockId) {
        super();
        this.userId = userId;
        this.stockId = stockId;
    }
}
