package com.microservices.currency_exchange_microservice.Controller;


import com.microservices.currency_exchange_microservice.Entity.Currency;
import com.microservices.currency_exchange_microservice.Repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Currency retrieveValue(@PathVariable String from, @PathVariable String to){

        Currency currency = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currency == null){
            throw new RuntimeException("Unable to find data from " + from + " to " + to);
        }
        if(currency.getConversion() == null){
            currency.setConversion(1f);
        }
        currency.setEnvironment(environment.getProperty("server.port"));


        return currency;
    }
}
