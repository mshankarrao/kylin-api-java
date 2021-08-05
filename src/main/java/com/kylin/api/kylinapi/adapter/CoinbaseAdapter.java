package com.kylin.api.kylinapi.adapter;

import com.kylin.api.kylinapi.model.CoinbaseResponse;
import com.kylin.api.kylinapi.model.SourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinbaseAdapter {
    @Autowired
    private RestTemplate restTemplate;

    public SourceResponse getData(String pair) {
        String pairs[] = pair.split("_");
        String url = String.format("https://api.pro.coinbase.com/products/%s-%s/ticker", pairs[0].toUpperCase(),
                pairs[1].toUpperCase());
        CoinbaseResponse value = restTemplate.getForObject(url, CoinbaseResponse.class);
        SourceResponse sourceResponse = new SourceResponse();
        sourceResponse.setActualPrice(value.getPrice());
        sourceResponse.setTradingPair(pair);
        return sourceResponse;
    }
}
