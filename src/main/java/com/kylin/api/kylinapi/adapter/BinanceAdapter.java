package com.kylin.api.kylinapi.adapter;

import com.kylin.api.kylinapi.model.SourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceAdapter {

    @Autowired
    private RestTemplate restTemplate;

    public SourceResponse getData(String pair) {
        SourceResponse sourceResponse = restTemplate.getForObject("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDC",
                SourceResponse.class);
         
        return sourceResponse;
    }

}
