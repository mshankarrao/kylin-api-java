package com.kylin.api.kylinapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoWatchResponse extends SourceResponse {
    private CryptoWatchResult result;

    public CryptoWatchResult getResult() {
        return result;
    }

    public void setResult(CryptoWatchResult result) {
        this.result = result;
    }

}
