package com.example.BootCamp.PS1.Dao.StocksDao;

import com.example.BootCamp.PS1.ApiResponse.gettingStockOptionalResponse;
import com.example.BootCamp.PS1.Model.Stock;

import java.util.List;

public interface StocksDaoInterface {
    public void updateStockTable(List<Stock> stockList);
    public gettingStockOptionalResponse gettingStockByStockId(String stockId);
}
