package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwelveDataStockService {

    @Autowired
    private RestAPIBuilder apiBuilder;

    @Value("${apikey}")
    private String apikey;

    private final String twelveDataBaseUrl = "https://api.twelvedata.com";

    public Optional<Object> getRealTimePrice(String symbol)
    {
        Object response = apiBuilder.setUrl(twelveDataBaseUrl + "/price")
                    .setHeaders("Authorization", "apikey "+apikey)
                    .setUrlParams("symbol", symbol)
                    .getMethod();
                    
        return Optional.of(response);
    }
}
