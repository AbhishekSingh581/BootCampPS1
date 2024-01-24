package com.example.BootCamp.PS1.Controller;

import com.example.BootCamp.PS1.Api.PortfolioController;
import com.example.BootCamp.PS1.DTO.HoldingsDTO;
import com.example.BootCamp.PS1.DTO.PortfolioDTO;
import com.example.BootCamp.PS1.Service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PortFolioContollerTest {

    @Mock
    private PortfolioService portfolioService;

    @InjectMocks
    private PortfolioController portfolioController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void gettingUserPortfolioByIdTest(){
        List<HoldingsDTO> holdingsDTOList= Arrays.asList(new HoldingsDTO("INF959L01HI3","NAVINIFTY",4, BigDecimal.valueOf(220.15)
        , BigDecimal.valueOf(218.50),BigDecimal.valueOf(1.65)));

        PortfolioDTO portfolioDTO=new PortfolioDTO(holdingsDTOList,4,BigDecimal.valueOf(880.60),
                BigDecimal.valueOf(-0.749488984783102430161253690665455400));
        ResponseEntity<PortfolioDTO> portfolioDTOResponseEntity= ResponseEntity.ok(portfolioDTO);

        when(portfolioService.gettingUserPortfolioByUserId(1)).thenReturn(portfolioDTOResponseEntity);

        ResponseEntity<PortfolioDTO> result=portfolioController.gettingUserPortfolioById(1);
        assertEquals(portfolioDTOResponseEntity,result);
        verify(portfolioService,times(1)).gettingUserPortfolioByUserId(1);
    }
}
