package com.example.bnp.service;

import com.example.bnp.model.Rate;
import com.example.bnp.model.RatesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class ExchangeRateService {
    public String getResult(String currencyCode) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/" + LocalDate.now().minusDays(5) + "/" + LocalDate.now();
        ResponseEntity<RatesResponse> response = restTemplate.getForEntity(resourceUrl, RatesResponse.class);
        StringBuilder result = new StringBuilder();
        for (Rate rate : response.getBody().getRates()) {
            result.append(String.format("%.2f   ", rate.getMid()));
        }
        return result.toString();
    }
}
