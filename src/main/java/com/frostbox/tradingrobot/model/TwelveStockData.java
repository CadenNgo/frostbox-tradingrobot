package com.frostbox.tradingrobot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Use Lombok to reduce Boilerplate repetitive, standard code you write all the time such as setter, getter.

@Entity
@Data
@AllArgsConstructor //Creates a constructor with all fields as parameters:
@NoArgsConstructor
public class TwelveStockData {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    
    @Id
    private String symbol;
    private String name;
    private String currency;
    private String  exchange;
    private String  mic_code;    
    private String  country;    
    private String  type;    
    private String  figi_code;    
    private String  cfi_code;    
    private String  isin;
}
