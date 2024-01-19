package com.example.BootCamp.PS1.Model;

import com.example.BootCamp.PS1.Model.CombinationPrimaryKey.UserStockId;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class Portfolio {
    @EmbeddedId
    private UserStockId userStockId;

    @ManyToOne
    @JoinColumn(name = "Stock_Id", referencedColumnName = "Stock_Id", insertable = false, updatable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Stock stock;

    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Buy_Price")
    private BigDecimal buyPrice;
    public Portfolio(){};

    public Portfolio(UserStockId userStockId, int quantity, BigDecimal buyPrice) {
        this.userStockId = userStockId;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
    }
}
