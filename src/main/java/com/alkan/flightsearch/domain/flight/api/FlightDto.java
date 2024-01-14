package com.alkan.flightsearch.domain.flight.api;

import java.time.LocalDateTime;
import java.util.Date;

public class FlightDto {

    private String id;
    private Date created;
    private Date modified;
    private String departureAirportIATA;
    private String arrivalAirportIATA;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;

    public FlightDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
