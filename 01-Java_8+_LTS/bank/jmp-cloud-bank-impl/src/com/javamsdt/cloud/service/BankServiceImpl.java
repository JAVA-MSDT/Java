package com.javamsdt.cloud.service;


import com.javamsdt.bank.domain.Subscription;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;
import com.javamsdt.cloud.bank.DbInteraction;
import com.javamsdt.service.api.BankService;

import java.util.List;
import java.util.Optional;

public class BankServiceImpl implements BankService {

    private static final DbInteraction dbInteraction = new DbInteraction();

    static {
        dbInteraction.generateSubscriptionTableIfNotExists();
    }

    @Override
    public void subscribe(BankCard bankCard) {
        dbInteraction.getDb().executeUpdate(dbInteraction.getStatement(), dbInteraction.insertSubscriptionQuery(bankCard));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return dbInteraction.findSubscriptionByCardNumber(cardNumber);
    }

    @Override
    public List<User> getAllUsers() {
        return dbInteraction.findAllUser();
    }
}
