package com.example.BootCamp.PS1.ApiResponse;

import com.example.BootCamp.PS1.Model.Stock;
import lombok.Data;

@Data
public class gettingStockResponse {
    private Stock stock;
    private String status;
    private String errorMessage;

    public gettingStockResponse(Stock stock, String status) {
        this.stock = stock;
        this.status = status;
    }

    public gettingStockResponse(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
