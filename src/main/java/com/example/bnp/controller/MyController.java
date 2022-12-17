package com.example.bnp.controller;

import com.example.bnp.model.Currency;
import com.example.bnp.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    private ExchangeRateService exchangeRate;

    @GetMapping("/exchange-rates")
    public String rate() {
        return "exchange-home";
    }

    @PostMapping("/exchange-rates")
    public String getRate(@ModelAttribute Currency currency, Model model) {
        String code = currency.getCode();
        model.addAttribute("code", code);
        try {
            String rates = exchangeRate.getResult(code);
            model.addAttribute("rates", rates);
            return "exchange-result";
        } catch (Exception e) {
            return "currency-error";
        }
    }
}
