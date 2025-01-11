package com.microservices.currency_exchange_microservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {

    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private Float conversion;
    private String environment;

    public Currency() {
    }

    public Currency(Long id, String from, String to, Float conversion) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversion = conversion;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Float getConversion() {
        return conversion;
    }

    public void setConversion(Float conversion) {
        this.conversion = conversion;
    }
}
