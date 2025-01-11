package com.example.currency_conversion_service.Controller;

import com.example.currency_conversion_service.Entity.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {


    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveQuantity(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        return new CurrencyConversion(1001L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
    }

}
