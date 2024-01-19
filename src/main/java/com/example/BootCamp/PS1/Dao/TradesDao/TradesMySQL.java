package com.example.BootCamp.PS1.Dao.TradesDao;

import com.example.BootCamp.PS1.ApiResponse.PostTradeResponse;
import com.example.BootCamp.PS1.Model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository("TradesMySQL")
public class TradesMySQL implements TradesDaoInterface{

    @Autowired
    private TradesJPARepo tradesJPARepo;
    @Override
    public ResponseEntity<PostTradeResponse> addingTradetransaction(Trade trade) {
        try{
            tradesJPARepo.save(trade);
            return ResponseEntity.ok(new PostTradeResponse("Success","The trade transaction is added to the db"));
        }
        catch(Exception e){
            System.err.println("Can't able to add in table"+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PostTradeResponse("Failed",e.getMessage()));
        }
    }
}
