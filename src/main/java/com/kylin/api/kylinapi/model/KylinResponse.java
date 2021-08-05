package com.kylin.api.kylinapi.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KylinResponse {
    private HashMap<String, SourceResponse> dataFeeds;

    public HashMap<String, SourceResponse> getDataFeeds() {
        return dataFeeds;
    }

    public void setDataFeeds(HashMap<String, SourceResponse> dataFeeds) {
        this.dataFeeds = dataFeeds;
    }

}
