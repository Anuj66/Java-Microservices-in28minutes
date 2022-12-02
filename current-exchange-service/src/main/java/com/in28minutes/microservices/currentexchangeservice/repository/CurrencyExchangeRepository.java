package com.in28minutes.microservices.currentexchangeservice.repository;

import com.in28minutes.microservices.currentexchangeservice.dto.ExchangeCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeCurrency, Long> {

    ExchangeCurrency findByFromAndTo(String from, String to);

}
