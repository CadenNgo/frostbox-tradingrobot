package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TradingBotRunner {

    @Autowired
    private TwelveDataStockService twelveDataService;

    @PostConstruct
    public void startBot(){

        String symbol = "AAPL";
        //Optional<Object> test = twelveDataService.getRealTimePrice(symbol);

        //System.out.println(test);
    }
}
