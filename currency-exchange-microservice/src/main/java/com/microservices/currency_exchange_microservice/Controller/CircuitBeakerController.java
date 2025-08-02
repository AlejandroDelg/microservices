package com.microservices.currency_exchange_microservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBeakerController {
    @GetMapping("/sample-api")
    public String sampleApi(){
        return "Sample API";
    }
}
