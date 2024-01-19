package com.example.BootCamp.PS1.Dao.TradesDao;

import com.example.BootCamp.PS1.ApiResponse.PostTradeResponse;
import com.example.BootCamp.PS1.Model.Trade;
import org.springframework.http.ResponseEntity;

public interface TradesDaoInterface {
    public ResponseEntity<PostTradeResponse> addingTradetransaction(Trade trade);
}
