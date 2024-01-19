package com.example.BootCamp.PS1.Service;

import com.example.BootCamp.PS1.ApiResponse.gettingStockOptionalResponse;
import com.example.BootCamp.PS1.Dao.StocksDao.StocksDaoInterface;
import com.example.BootCamp.PS1.Model.Stock;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class StocksService {
    @Autowired
    @Qualifier("StocksMySQL")
    private StocksDaoInterface stocksDaoInterface;
    public List<Stock> StocksListFromFile(MultipartFile file){
        List<Stock> stocksList=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVReader csvReader = new CSVReader(reader)) {
            csvReader.readNext();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Stock stock = new Stock(nextRecord[12],nextRecord[0],new BigDecimal(nextRecord[4])
                        ,new BigDecimal(nextRecord[3]),new BigDecimal(nextRecord[2]),
                        new BigDecimal(nextRecord[5]));
                stocksList.add(stock);
            }
        } catch (IOException e) {
            System.err.println("Error processing CSV record: " + e.getMessage());
        } catch (CsvValidationException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return stocksList;
    }
    public void updatingStocks(MultipartFile file){
        List<Stock> stockList=StocksListFromFile(file);
        stocksDaoInterface.updateStockTable(stockList);
    }

    public gettingStockOptionalResponse gettingStockByStockId(String stockId){
        return stocksDaoInterface.gettingStockByStockId(stockId);
    }
}
