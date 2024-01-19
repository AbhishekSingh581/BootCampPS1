package com.example.BootCamp.PS1.ApiResponse;

import com.example.BootCamp.PS1.DTO.PortfolioDTO;
import lombok.Data;

@Data
public class PortfolioResponse {
    private String status;
    private PortfolioDTO portfolioDTO;
    private String message;

    public PortfolioResponse(String status, PortfolioDTO portfolioDTO, String message) {
        this.status = status;
        this.portfolioDTO = portfolioDTO;
        this.message = message;
    }
}
