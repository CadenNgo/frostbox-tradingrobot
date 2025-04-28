package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frostbox.tradingrobot.frostbox_tradingrobot.service.Utilities.PostgreSQLBuilder;
import com.frostbox.tradingrobot.model.TwelveStockData;

@Service
public class TradingBotInitialSetup {

    @Autowired
    private TwelveDataAPIService twelveDataService;

    @Autowired
    private PostgreSQLBuilder postgreSQLBuilder;

    public void setup() {

        Optional<TwelveStockData[]> test = twelveDataService.getStockList();

        try {
            postgreSQLBuilder.insertIntoDatabase(test.get());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
