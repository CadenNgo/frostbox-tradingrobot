package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.frostbox.tradingrobot.model.StockInfo;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service
public class YahooStockService {

    /**
     * Retrieves stock information for the given symbol using Yahoo Finance API.
     * 
     * @param symbol The stock symbol (e.g., AAPL, MSFT).
     * @return Optional containing StockInfo if successful, empty if failed
     */

    public Optional<StockInfo> getStockInfo(String symbol)
    {
        try{
        Stock stock = YahooFinance.get(symbol);

        if(stock ==null)
        {
            return Optional.empty();
        }
        
        return Optional.of(new StockInfo(
            stock.getSymbol(),
            stock.getName(),
            stock.getQuote().getPrice(),
            stock.getQuote().getChangeInPercent()
            ));
        } catch(IOException e) {
            System.err.println(e);
            System.err.println("Failed to fetch stock data for symbol: " + symbol);
            return Optional.empty();
        }
    }
}
