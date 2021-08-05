package com.kylin.api.kylinapi.adapter;

import org.springframework.stereotype.Service;

import com.kylin.api.kylinapi.model.CoingeckoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


@Service
public class LivecoinAdapter {

    @Autowired
    private RestTemplate restTemplate;

    public String getData(String pair) {
        CoingeckoResponse value = restTemplate.getForObject(
                "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd", CoingeckoResponse.class);

        return value.toString();
    }

}
