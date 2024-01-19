package com.example.BootCamp.PS1.ApiResponse;

import lombok.Data;

@Data
public class PostTradeResponse {
    private String status;
    private String message;

    public PostTradeResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
