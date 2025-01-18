package com.example.currency_conversion_service.Controller;

import com.example.currency_conversion_service.Entity.CurrencyConversion;
import com.example.currency_conversion_service.Entity.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveQuantity(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/eur/to/usd", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getQuantity(), currencyConversion.getConversionMultiple(), currencyConversion.getConversionMultiple(), currencyConversion.getEnvironment());
    }


    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveQuantityFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = proxy.retrieveValue(from, to);
        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getQuantity(), currencyConversion.getConversionMultiple(), currencyConversion.getConversionMultiple(), currencyConversion.getEnvironment());
    }

}
