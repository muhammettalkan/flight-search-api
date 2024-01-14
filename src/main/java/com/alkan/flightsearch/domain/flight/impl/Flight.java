package com.alkan.flightsearch.domain.flight.impl;

import com.alkan.flightsearch.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Flight extends AbstractEntity {

    private String departureAirportIATA;
    private String arrivalAirportIATA;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;

    public Flight() {
    }

    public Flight(String departureAirportIATA, String arrivalAirportIATA, LocalDateTime departureTime, LocalDateTime arrivalTime, double price) {
        this.departureAirportIATA = departureAirportIATA;
        this.arrivalAirportIATA = arrivalAirportIATA;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }



    public String getDepartureAirportIATA() {
        return departureAirportIATA;
    }

    public void setDepartureAirportIATA(String departureAirportId) {
        this.departureAirportIATA = departureAirportId;
    }

    public String getArrivalAirportIATA() {
        return arrivalAirportIATA;
    }

    public void setArrivalAirportIATA(String arrivalAirportId) {
        this.arrivalAirportIATA = arrivalAirportId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
