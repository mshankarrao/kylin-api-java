package com.kylin.api.kylinapi.adapter;

import com.kylin.api.kylinapi.model.CoingeckoResponse;
import com.kylin.api.kylinapi.model.CryptoWatchResponse;
import com.kylin.api.kylinapi.model.SourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitfinixAdapter {

    @Autowired
    private RestTemplate restTemplate;

    public SourceResponse getData(String pair) {
        CryptoWatchResponse value = restTemplate.getForObject("https://api.cryptowat.ch/markets/bitfinex/btcusd/price",
                CryptoWatchResponse.class);

        SourceResponse sourceResponse = new SourceResponse();
        sourceResponse.setActualPrice(value.getResult().getPrice());
        sourceResponse.setTradingPair(pair);
        return sourceResponse;
    }

}
