package com.microservices.currency_exchange_microservice.Repository;

import com.microservices.currency_exchange_microservice.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<Currency, Long> {

    Currency findByFromAndTo(String from, String to);
}
