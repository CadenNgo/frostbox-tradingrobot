package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frostbox.tradingrobot.frostbox_tradingrobot.service.Utilities.PostgreSQLBuilder;
import com.frostbox.tradingrobot.model.TwelveStockData;

import jakarta.annotation.PostConstruct;

@Component
public class TradingBotRunner {

    @Autowired
    private TwelveDataAPIService twelveDataService;

    @Autowired
    private PostgreSQLBuilder postgreSQLBuilder;

    @PostConstruct
    public void startBot(){

        Optional<TwelveStockData[]> test = twelveDataService.getStockList();

        try{
            postgreSQLBuilder.insertIntoDatabase(test.get()[0]);
        }
        catch(Exception e){
            System.out.println(e);
        }

        //System.out.println(test.get()[0]);
    }
}
