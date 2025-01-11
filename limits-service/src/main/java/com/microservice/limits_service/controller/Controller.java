package com.microservice.limits_service.controller;

import com.microservice.limits_service.bean.Limits;
import com.microservice.limits_service.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Configuration configuration;

   @GetMapping("/limits")
    public Limits retrieveLimits(){

       return new Limits(Configuration.getMinimum(), Configuration.getMaximum());
      // return new Limits(1, 1000);

   }



}
