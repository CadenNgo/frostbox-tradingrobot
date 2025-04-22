package com.frostbox.tradingrobot.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Use Lombok to reduce Boilerplate repetitive, standard code you write all the time such as setter, getter.

@Data
@AllArgsConstructor //Creates a constructor with all fields as parameters:
@NoArgsConstructor
public class StockInfo {
    private String symbol;
    private String name;
    private BigDecimal  price;
    private BigDecimal  changePercent;    
}
