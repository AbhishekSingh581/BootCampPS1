package com.example.BootCamp.PS1.Api;

import com.example.BootCamp.PS1.DTO.PortfolioDTO;
import com.example.BootCamp.PS1.Model.Portfolio;
import com.example.BootCamp.PS1.Service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;
    @GetMapping(path = "{userId}")
    public ResponseEntity<PortfolioDTO> gettingUserPortfolioById(@PathVariable("userId") long userId){
        return portfolioService.gettingUserPortfolioByUserId(userId);
    }
}
