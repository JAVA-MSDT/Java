package com.javamsdt;

import com.javamsdt.entity.Currency;
import com.javamsdt.entity.UserAccount;
import com.javamsdt.service.ExchangeService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ExchangeService exchangeService = new ExchangeService();

        Map<Currency, BigDecimal> user1bBalances = new HashMap<>();
        user1bBalances.put(new Currency("USD"), BigDecimal.valueOf(1000));
        user1bBalances.put(new Currency("EUR"), BigDecimal.valueOf(1500));
        UserAccount user1 = new UserAccount("user1", user1bBalances);

        Map<Currency, BigDecimal> user2bBalances = new HashMap<>();
        user2bBalances.put(new Currency("USD"), BigDecimal.valueOf(1500));
        user2bBalances.put(new Currency("EUR"), BigDecimal.valueOf(1000));
        UserAccount user2 = new UserAccount("user2", user2bBalances);

        // generate accounts
        exchangeService.generateAccount(user1);
        exchangeService.generateAccount(user2);

        // generate currencies
        exchangeService.generateCurrency("USD");
        exchangeService.generateCurrency("EUR");

        // Set exchange rates
        exchangeService.setExchangeRate("USD", "EUR", new BigDecimal("0.85"));
        exchangeService.setExchangeRate("EUR", "USD", new BigDecimal("0.50"));

        // Perform exchange operations
        exchangeService.performExchange("user1", "USD", "EUR", new BigDecimal("100"));
        exchangeService.performExchange("user2", "EUR", "USD", new BigDecimal("100"));
        exchangeService.performExchange("user1", "USD", "EUR", new BigDecimal("80"));
        exchangeService.performExchange("user2", "EUR", "USD", new BigDecimal("80"));
        exchangeService.performExchange("user1", "USD", "EUR", new BigDecimal("150"));
        exchangeService.performExchange("user2", "EUR", "USD", new BigDecimal("150"));
        exchangeService.performExchange("user1", "USD", "EUR", new BigDecimal("50"));
        exchangeService.performExchange("user2", "EUR", "USD", new BigDecimal("50"));

        exchangeService.shutdown();
    }
}