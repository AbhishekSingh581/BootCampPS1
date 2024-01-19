package com.example.BootCamp.PS1.Dao.StocksDao;

import com.example.BootCamp.PS1.ApiResponse.gettingStockOptionalResponse;
import com.example.BootCamp.PS1.Model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StocksMySQL")
public class StocksMySQL implements StocksDaoInterface{
    @Autowired
    private StocksJPARepo stocksJPARepo;
    @Override
    public void updateStockTable(List<Stock> stockList) {
        try {
            stocksJPARepo.saveAll(stockList);
            System.out.println("stock Data Updated");
        }
        catch(Exception e){
            System.err.println("Can't update in Database: "+e.getMessage());
        }
    }

    @Override
    public gettingStockOptionalResponse gettingStockByStockId(String stockId) {
        try{
            return new gettingStockOptionalResponse(stocksJPARepo.findById(stockId));
        }
        catch(Exception e){
            System.err.println("Can't able to fetch data from DB"+e.getMessage());
            return new gettingStockOptionalResponse(e.getMessage());
        }
    }
}
