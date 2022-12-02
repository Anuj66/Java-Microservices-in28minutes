package com.in28minutes.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.in28minutes.microservices.currencyconversionservice.dto.CurrencyConversion;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  CurrencyConversion retrieveExchangeValue(
      @PathVariable String from,
      @PathVariable String to);

}
