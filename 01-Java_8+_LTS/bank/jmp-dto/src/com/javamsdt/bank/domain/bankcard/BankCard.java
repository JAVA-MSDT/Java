package com.javamsdt.bank.domain.bankcard;
import com.javamsdt.bank.domain.User;

import java.time.LocalDate;

public class BankCard {
    private String number;
    private User user;
    private LocalDate startDate;
    private String cardType;

    public BankCard() {
    }

    public BankCard(String number, User user, LocalDate startDate) {
        this.number = number;
        this.user = user;
        this.startDate = startDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

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
        return "BankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                ", startDate=" + startDate +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
