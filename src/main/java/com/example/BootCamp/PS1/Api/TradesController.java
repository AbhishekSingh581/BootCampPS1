package com.example.BootCamp.PS1.Api;

import com.example.BootCamp.PS1.ApiResponse.PostTradeResponse;
import com.example.BootCamp.PS1.Model.Enum.TradeType;
import com.example.BootCamp.PS1.Model.Trade;
import com.example.BootCamp.PS1.Service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trade")
public class TradesController {
    @Autowired
    private TradesService tradesService;
    @PostMapping("{newTrade}")
    public ResponseEntity<PostTradeResponse> postingTradeData(@RequestBody Trade trade){
        if(trade!=null && trade.getUserId()!=0 && trade.getQuantity()!=0 && trade.getStockId()!=null
        && trade.getTradeType()!=null){
            TradeType tradeType = TradeType.valueOf(trade.getTradeType().name());
            if(tradeType==TradeType.Buy || tradeType==TradeType.Sell){
                return tradesService.insertingTradeTransaction(trade);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new PostTradeResponse("Failed","Trade type input is invalid"));
            }
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new PostTradeResponse("Failed","some values is not there or invalid inputs"));
        }

    }
}
