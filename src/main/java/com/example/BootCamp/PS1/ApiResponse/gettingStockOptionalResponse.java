package com.example.BootCamp.PS1.ApiResponse;

import com.example.BootCamp.PS1.Model.Stock;
import lombok.Data;

import java.util.Optional;

@Data
public class gettingStockOptionalResponse {
   private Optional<Stock> stockOptional;
   private String errorMessage;

    public gettingStockOptionalResponse(Optional<Stock> stockOptional) {
        this.stockOptional = stockOptional;
    }

    public gettingStockOptionalResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
