package com.frostbox.tradingrobot.frostbox_tradingrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.frostbox.tradingrobot.model")
public class FrostboxTradingrobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrostboxTradingrobotApplication.class, args);
	}

}
