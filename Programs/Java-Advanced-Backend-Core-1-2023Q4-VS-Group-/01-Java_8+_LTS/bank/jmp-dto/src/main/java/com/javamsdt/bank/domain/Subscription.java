package com.javamsdt.bank.domain;


import java.time.LocalDate;

public class Subscription {
    private String bankcard;
    private String cardNumber;
    private LocalDate startDate;

    public Subscription() {
    }

    public Subscription(String bankcard, String cardNumber, LocalDate startDate) {
        this.bankcard = bankcard;
        this.cardNumber = cardNumber;
        this.startDate = startDate;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "bankcard='" + bankcard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
