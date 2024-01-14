package com.alkan.flightsearch.domain.airport.impl;

import com.alkan.flightsearch.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Airport extends AbstractEntity {

    private String IATA;
    private String city;

    public Airport() {
    }

    public Airport(String IATA, String city) {
        this.IATA = IATA;
        this.city = city;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
