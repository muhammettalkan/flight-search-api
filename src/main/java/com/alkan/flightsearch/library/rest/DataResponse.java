package com.alkan.flightsearch.library.rest;

import java.util.List;


public class DataResponse<T> {
    private List<T> items = List.of();
    private Integer numberOfItems;

    public DataResponse() {
    }

    public DataResponse(List<T> items, Integer numberOfItems) {
        this.items = items;
        this.numberOfItems = numberOfItems;
    }

    public List<T> getItems() {
        return items;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }
}
