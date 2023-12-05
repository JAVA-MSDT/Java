package com.javamsdt.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UserAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private Map<Currency, BigDecimal> balances;

    public UserAccount() {
    }

    public UserAccount(String username) {
        this.username = username;
        this.balances = new HashMap<>();
    }

    public UserAccount(String username, Map<Currency, BigDecimal> balances) {
        this.username = username;
        this.balances = balances;
    }

    public String getUsername() {
        return username;
    }

    public Map<Currency, BigDecimal> getBalances() {
        return balances;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", balances=" + balances.toString() +
                '}';
    }
}
