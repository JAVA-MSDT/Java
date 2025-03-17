package org.epamedu;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class CurrencyUtil {

    public static void main(String[] args) {
        Currency russianRuble = Currency.getInstance("RUB");
        System.out.println(russianRuble.getDisplayName());
        System.out.println(russianRuble.getCurrencyCode());
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        currencies.forEach(currency -> System.out.println(currency.getCurrencyCode() + ", " + currency.getDisplayName()));
    }

}
