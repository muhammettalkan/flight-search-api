package com.alkan.flightsearch.domain.airport.api;

import java.util.Date;

public class AirportDto {

    private String id;
    private Date created;
    private Date modified;
    private String IATA;
    private String city;

    public AirportDto() {
    }

    public AirportDto(String IATA, String city) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
