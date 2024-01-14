package com.alkan.flightsearch.library.rest;

import org.springframework.data.domain.Page;

import java.util.List;

public class BaseController {
    public <T> Response<DataResponse<T>> respond(List<T> items) {
        return ResponseBuilder.build(items);
    }

    public <T> Response<T> respond(T item) {
        return ResponseBuilder.build(item);
    }

    public Response<MetaResponse> respond(MetaResponse metaResponse){
        return ResponseBuilder.build(metaResponse);
    }
}
