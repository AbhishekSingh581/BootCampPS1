package com.example.BootCamp.PS1.Api;

import com.example.BootCamp.PS1.ApiResponse.gettingStockOptionalResponse;
import com.example.BootCamp.PS1.ApiResponse.gettingStockResponse;
import com.example.BootCamp.PS1.Model.Stock;
import com.example.BootCamp.PS1.Service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {

    @Autowired
    private StocksService stockService;
    @PutMapping(path = "/updatingStocks")
    public void updatingStocks(@RequestParam("file") MultipartFile file){
        if (file != null && !file.isEmpty()) {
            stockService.updatingStocks(file);
        } else {
            throw new IllegalArgumentException("File is null or empty");
        }
    }

    @GetMapping(path = "/{stockId}")
    public ResponseEntity<gettingStockResponse> gettingStockByStockId(@PathVariable("stockId") String stockId){
        gettingStockOptionalResponse response= stockService.gettingStockByStockId(stockId);
        if(response.getErrorMessage()!= null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new gettingStockResponse("Failure",response.getErrorMessage()));
        }
        else if(response.getStockOptional().isPresent()){
            return ResponseEntity.ok(new gettingStockResponse(response.getStockOptional().orElse(null),"Success"));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new gettingStockResponse("Failure","No Such StockId is in Db"));
        }
    }

}
