package com.in28minutes.microservices.currentexchangeservice.controller;

import com.in28minutes.microservices.currentexchangeservice.dto.ExchangeCurrency;
import com.in28minutes.microservices.currentexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeCurrency retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to
    ) {
        logger.info("API called with {} to {}", from, to);
        ExchangeCurrency exchangeCurrency = currencyExchangeRepository.findByFromAndTo(from, to);
        if(exchangeCurrency == null) throw new RuntimeException("Data not found");
        String port = environment.getProperty("local.server.port");
        exchangeCurrency.setEnvironment(port);
        return exchangeCurrency;
    }

}
