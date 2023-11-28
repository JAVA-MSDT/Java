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
        user1bBalances.put(new Currency("EUR"), BigDecimal.valueOf(500));
        UserAccount user1 = new UserAccount("user1", user1bBalances);

        Map<Currency, BigDecimal> user2bBalances = new HashMap<>();
        user2bBalances.put(new Currency("USD"), BigDecimal.valueOf(500));
        user2bBalances.put(new Currency("EUR"), BigDecimal.valueOf(1000));
        UserAccount user2 = new UserAccount("user2", user2bBalances);

        // Create sample accounts
        exchangeService.createAccount(user1);
        exchangeService.createAccount(user2);

        // Create sample currencies
        exchangeService.createCurrency("USD");
        exchangeService.createCurrency("EUR");

        // Set sample exchange rates
        exchangeService.setExchangeRate("USD", "EUR", new BigDecimal("0.85"));
        exchangeService.setExchangeRate("EUR", "USD", new BigDecimal("0.50"));

        // Perform sample exchange operations
        exchangeService.performExchange("user1", "USD", "EUR", new BigDecimal("100"));
        exchangeService.performExchange("user2", "EUR", "USD", new BigDecimal("100"));

        exchangeService.shutdown();
    }
}