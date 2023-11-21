package com.javamsdt.service.api;

import com.javamsdt.bank.domain.Subscription;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;

import java.util.List;
import java.util.Optional;

public interface BankService {
    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

    List<User> getAllUsers();

}
