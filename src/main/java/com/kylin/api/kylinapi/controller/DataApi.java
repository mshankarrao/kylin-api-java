package com.kylin.api.kylinapi.controller;

import java.util.HashMap;
import java.util.List;

import com.kylin.api.kylinapi.adapter.BinanceAdapter;
import com.kylin.api.kylinapi.adapter.BitfinixAdapter;
import com.kylin.api.kylinapi.adapter.CoinbaseAdapter;
import com.kylin.api.kylinapi.adapter.CoingeckoAdapter;
import com.kylin.api.kylinapi.adapter.CryptocompareAdapter;
import com.kylin.api.kylinapi.adapter.KrakenAdapter;
import com.kylin.api.kylinapi.adapter.UniswapAdapter;
import com.kylin.api.kylinapi.model.KylinResponse;
import com.kylin.api.kylinapi.model.SourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataApi {

    @Autowired
    private CoingeckoAdapter coingeckoAdapter;
    @Autowired
    private CoinbaseAdapter coinbaseAdapter;
    @Autowired
    private BinanceAdapter binanceAdapter;
    @Autowired
    private KrakenAdapter krakenAdapter;
    @Autowired
    private UniswapAdapter uniswapAdapter;
    @Autowired
    private BitfinixAdapter bitfinixAdapter;
    @Autowired
    private CryptocompareAdapter cryptocompareAdapter;

    @GetMapping("/prices")
    public KylinResponse getPrices(@RequestParam(value = "pairs") List<String> pairs) {
        HashMap<String, SourceResponse> finalData = new HashMap<>();
        for (String pair : pairs) {

            finalData.put("Coinbase", coinbaseAdapter.getData(pair));
            //finalData.put("CoinGecko", coingeckoAdapter.getData(pair));
            //finalData.put("Binance", binanceAdapter.getData(pair));
            finalData.put("Kraken", krakenAdapter.getData(pair));
            finalData.put("Bitfinix", bitfinixAdapter.getData(pair));
            finalData.put("Uniswap-v2", uniswapAdapter.getData(pair));
            finalData.put("CryptoCompare", cryptocompareAdapter.getData(pair));
        }
        KylinResponse kylinResponse = new KylinResponse();
        kylinResponse.setDataFeeds(finalData);
        return kylinResponse;
    }
}
