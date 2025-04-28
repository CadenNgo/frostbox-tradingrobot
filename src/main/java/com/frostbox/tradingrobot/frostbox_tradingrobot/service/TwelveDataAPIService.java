package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frostbox.tradingrobot.frostbox_tradingrobot.service.Utilities.LogBuilder;
import com.frostbox.tradingrobot.frostbox_tradingrobot.service.Utilities.RestAPIBuilder;
import com.frostbox.tradingrobot.model.TwelveStockData;

@Service
public class TwelveDataAPIService {

    @Autowired
    private RestAPIBuilder apiBuilder;

    @Value("${apikey}")
    private String apikey;

    @Autowired
    private LogBuilder logging;

    private final String twelveDataBaseUrl = "https://api.twelvedata.com";

    ObjectMapper objectMapper = new ObjectMapper();

    public Optional<TwelveStockData[]> getStockList() {
        try {
            Object response = apiBuilder.setUrl(twelveDataBaseUrl + "/stocks")
                    .setHeaders("Authorization", "apikey " + apikey)
                    .getMethod();
            
            TwelveStockData[] twelveDataStockArray = objectMapper.convertValue(response, TwelveStockData[].class);

            return Optional.of(twelveDataStockArray);
        } 
        catch (Exception e) {
            logging.error(e.toString());
            return null;
        }
    }

    public Optional<Object> getRealTimePrice(String symbol) {
        try {
            Object response = apiBuilder.setUrl(twelveDataBaseUrl + "/price")
                    .setHeaders("Authorization", "apikey " + apikey)
                    .setUrlParams("symbol", symbol)
                    .getMethod();

            return Optional.of(response);
        } 
        catch (Exception e) {
            
            logging.error(e.toString());
            return null;
        }
    }
}
