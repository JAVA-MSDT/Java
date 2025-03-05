package com.javamsdt.service;

import com.javamsdt.dao.AccountDAO;
import com.javamsdt.entity.Currency;
import com.javamsdt.entity.ExchangeRate;
import com.javamsdt.entity.UserAccount;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangeService {
    private final Map<String, Currency> currencies;
    private final Map<String, ExchangeRate> exchangeRates;
    private final ExecutorService executorService;
    private final AccountDAO accountDAO = new AccountDAO();
    private final Lock lock = new ReentrantLock();

    public ExchangeService() {
        this.currencies = new ConcurrentHashMap<>();
        this.exchangeRates = new ConcurrentHashMap<>();
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public void generateAccount(UserAccount userAccount) {
        accountDAO.saveAccount(userAccount);
    }

    public void generateCurrency(String code) {
        currencies.putIfAbsent(code, new Currency(code));
    }

    public void setExchangeRate(String fromCurrencyCode, String toCurrencyCode, BigDecimal rate) {
        Currency fromCurrency = currencies.computeIfAbsent(fromCurrencyCode, Currency::new);
        Currency toCurrency = currencies.computeIfAbsent(toCurrencyCode, Currency::new);
        exchangeRates.put(fromCurrencyCode + "_" + toCurrencyCode, new ExchangeRate(fromCurrency, toCurrency, rate));
    }

    public synchronized void performExchange(String username, String fromCurrencyCode, String toCurrencyCode, BigDecimal amount) {

        executorService.submit(() -> {
            lock.lock();
            UserAccount account = accountDAO.loadAccount(username);
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
                    accountDAO.saveAccount(account);
                }
            }
            lock.unlock();
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
