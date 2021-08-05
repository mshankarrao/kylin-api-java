package com.kylin.api.kylinapi.adapter;

import com.kylin.api.kylinapi.model.CoingeckoResponse;
import com.kylin.api.kylinapi.model.SourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoingeckoAdapter {

    @Autowired
    private RestTemplate restTemplate;

    public SourceResponse getData(String pair)
    {
        SourceResponse value = restTemplate.getForObject(
					"https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd", CoingeckoResponse.class);
		
        return value;
    }

}

