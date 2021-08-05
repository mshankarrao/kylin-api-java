package com.kylin.api.kylinapi.adapter;

import com.kylin.api.kylinapi.model.CoingeckoResponse;
import com.kylin.api.kylinapi.model.SourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptocompareAdapter {

    @Autowired
    private RestTemplate restTemplate;

    public SourceResponse getData(String pair) {
        String value = restTemplate.getForObject("https://min-api.cryptocompare.com/data/price?fsym=btc&tsyms=usd",
                String.class);
        SourceResponse sourceResponse = new SourceResponse();
        sourceResponse.setActualPrice(value.split(":")[1].replaceAll("}", ""));
        sourceResponse.setTradingPair(pair);
        return sourceResponse;
    }

}
