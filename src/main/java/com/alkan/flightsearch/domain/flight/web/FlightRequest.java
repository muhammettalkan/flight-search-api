package com.alkan.flightsearch.domain.flight.web;

import java.time.LocalDateTime;
import java.util.Date;

public class FlightRequest {
    private String departureAirportIATA;
    private String arrivalAirportIATA;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;

    public FlightRequest() {
    }

    public FlightRequest(String departureAirportIATA, String arrivalAirportIATA, LocalDateTime departureTime, LocalDateTime arrivalTime, double price) {
        this.departureAirportIATA = departureAirportIATA;
        this.arrivalAirportIATA = arrivalAirportIATA;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getDepartureAirportIATA() {
        return departureAirportIATA;
    }

    public void setDepartureAirportIATA(String departureAirportIATA) {
        this.departureAirportIATA = departureAirportIATA;
    }

    public String getArrivalAirportIATA() {
        return arrivalAirportIATA;
    }

    public void setArrivalAirportIATA(String arrivalAirportIATA) {
        this.arrivalAirportIATA = arrivalAirportIATA;
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
