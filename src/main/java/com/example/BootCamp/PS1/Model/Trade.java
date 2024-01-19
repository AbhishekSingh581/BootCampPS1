package com.example.BootCamp.PS1.Model;

import com.example.BootCamp.PS1.Model.Enum.TradeType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table
@Data
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_Id")
    private long transactionId;
    @Column(name = "User_Id")
    private long userId;
    @Column(name = "Trade_type")
    private TradeType tradeType;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Stock_Id")
    private String stockId;

    @ManyToOne
    @JoinColumn(name = "Stock_Id",referencedColumnName = "Stock_Id",insertable = false,updatable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Stock stock;

    public Trade(){}
    public Trade(long userId, TradeType tradeType, int quantity, String stockId) {
        super();
        this.userId = userId;
        this.tradeType = tradeType;
        this.quantity = quantity;
        this.stockId = stockId;
    }

}
