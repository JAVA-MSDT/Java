package com.javamsdt.bank.domain.bankcard;

import com.javamsdt.bank.domain.User;

import java.time.LocalDate;


public class CreditBankCard extends BankCard {
    private String number;
    private User user;
    private LocalDate startDate;
    private String cardType = BankCardType.CREDIT.name();

    public CreditBankCard() {
    }

    public CreditBankCard(String number, User user, LocalDate startDate) {
        this.number = number;
        this.user = user;
        this.startDate = startDate;
        this.cardType = BankCardType.CREDIT.name();
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "CreditBankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                ", startDate=" + startDate +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
