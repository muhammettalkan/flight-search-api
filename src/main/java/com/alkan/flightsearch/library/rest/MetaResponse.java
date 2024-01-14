package com.alkan.flightsearch.library.rest;

import com.alkan.flightsearch.library.enums.MessageCodes;


public class MetaResponse {
    private String code;
    private String description;

    public static MetaResponse of(String code, String description) {
        return new MetaResponse(code, description);
    }

    public static MetaResponse success() {
        return new MetaResponse(MessageCodes.SUCCESS.getCode(), MessageCodes.SUCCESS.getMessage());
    }

    public MetaResponse() {
    }

    public MetaResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


}
