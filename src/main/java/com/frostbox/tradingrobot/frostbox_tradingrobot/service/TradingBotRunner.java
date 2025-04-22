package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frostbox.tradingrobot.model.StockInfo;

import jakarta.annotation.PostConstruct;

@Component
public class TradingBotRunner {

    @Autowired
    private YahooStockService yahooStockService;

    @PostConstruct
    public void startBot(){

        String symbol = "INTC";
        Optional<StockInfo> stock = yahooStockService.getStockInfo(symbol);

        stock.ifPresent(info -> {
            System.out.println(info.getSymbol() + ":" + info.getPrice());
        });
    }
    
}
