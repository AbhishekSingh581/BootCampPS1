package com.example.BootCamp.PS1.Controller;

import com.example.BootCamp.PS1.ApiResponse.gettingStockOptionalResponse;
import com.example.BootCamp.PS1.ApiResponse.gettingStockResponse;
import com.example.BootCamp.PS1.Model.Stock;
import com.example.BootCamp.PS1.Service.StocksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StocksController {

    @Mock
    private StocksService stocksService;

    @InjectMocks
    private com.example.BootCamp.PS1.Api.StocksController stocksController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void gettingStockByStockIdTest(){
        Stock expectedStock=new Stock("INF959L01HI3","NAVINIFTY", BigDecimal.valueOf(216.80),BigDecimal.valueOf(222.00),
                BigDecimal.valueOf(219.00),BigDecimal.valueOf(218.50));
        gettingStockResponse gettingStockResponse=new gettingStockResponse(expectedStock,"Success");
        ResponseEntity<gettingStockResponse> gettingStockResponseResponseEntity=
                ResponseEntity.ok(gettingStockResponse);

        gettingStockOptionalResponse gettingStockOptionalResponse=new gettingStockOptionalResponse(Optional.of(expectedStock));
        when(stocksService.gettingStockByStockId("INF959L01HI3")).thenReturn(gettingStockOptionalResponse);

        ResponseEntity<gettingStockResponse> result=stocksController.gettingStockByStockId("INF959L01HI3");

        assertEquals(gettingStockResponseResponseEntity,result);
        verify(stocksService,times(1)).gettingStockByStockId("INF959L01HI3");

    }
}
