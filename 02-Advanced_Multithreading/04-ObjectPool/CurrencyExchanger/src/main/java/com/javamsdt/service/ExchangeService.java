package com.javamsdt.service;

import com.javamsdt.dao.AccountDAO;
import com.javamsdt.entity.Currency;
import com.javamsdt.entity.ExchangeRate;
import com.javamsdt.entity.UserAccount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeService {
    private Map<String, UserAccount> accounts;
    private Map<String, Currency> currencies;
    private Map<String, ExchangeRate> exchangeRates;
    private ExecutorService executorService;

    public ExchangeService() {
        this.accounts = new ConcurrentHashMap<>();
        this.currencies = new ConcurrentHashMap<>();
        this.exchangeRates = new ConcurrentHashMap<>();
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public void createAccount(UserAccount userAccount) {
        accounts.put(userAccount.getUsername(), userAccount);
        new AccountDAO().saveAccount(userAccount);
    }

    public void createCurrency(String code) {
        currencies.putIfAbsent(code, new Currency(code));
    }

    public void setExchangeRate(String fromCurrencyCode, String toCurrencyCode, BigDecimal rate) {
        Currency fromCurrency = currencies.computeIfAbsent(fromCurrencyCode, Currency::new);
        Currency toCurrency = currencies.computeIfAbsent(toCurrencyCode, Currency::new);
        exchangeRates.put(fromCurrencyCode + "_" + toCurrencyCode, new ExchangeRate(fromCurrency, toCurrency, rate));
    }

        public void performExchange(String username, String fromCurrencyCode, String toCurrencyCode, BigDecimal amount) {
        UserAccount account = accounts.get(username);
            if (account != null) {
            executorService.submit(() -> {
                synchronized (account) {
                    System.out.printf("account before currency exchange operation %s, Done by thread %s %n", account, Thread.currentThread().getName());
                    Currency fromCurrency = currencies.get(fromCurrencyCode);
                    Currency toCurrency = currencies.get(toCurrencyCode);
                    ExchangeRate exchangeRate = exchangeRates.get(fromCurrencyCode + "_" + toCurrencyCode);

                    if (fromCurrency != null && toCurrency != null && exchangeRate != null) {
                        BigDecimal fromBalance = account.getBalances().getOrDefault(fromCurrency, BigDecimal.ZERO);

                        BigDecimal exchangedAmount = amount.multiply(exchangeRate.getRate());
                        if (fromBalance.compareTo(amount) >= 0) {
                            account.getBalances().merge(fromCurrency, amount, BigDecimal::subtract);
                            account.getBalances().merge(toCurrency, exchangedAmount, BigDecimal::add);

                            System.out.printf("account after currency exchange operation %s, Done by thread %s %n", account, Thread.currentThread().getName());
                            // Save the updated account
                            new AccountDAO().saveAccount(account);
                        }
                    }
                }
            });
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
