package com.alkan.flightsearch.library.rest;

public class Response <T>{
    private T data;
    private MetaResponse meta;

    public Response(MetaResponse meta) {
        // Entity silme - Exception Senaryosu
            this.meta = meta;
    }

    public Response(T data) {
            this.data = data;
            this.meta = MetaResponse.success();
    }

    public Response() {
    }

    public Response(T data, MetaResponse meta) {
        this.data = data;
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public MetaResponse getMeta() {
        return meta;
    }
}
