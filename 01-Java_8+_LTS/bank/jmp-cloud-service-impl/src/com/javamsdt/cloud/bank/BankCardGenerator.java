package com.javamsdt.cloud.bank;

import com.javamsdt.bank.api.Bank;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;
import com.javamsdt.bank.domain.bankcard.BankCardType;
import com.javamsdt.bank.domain.bankcard.CreditBankCard;
import com.javamsdt.bank.domain.bankcard.DebitBankCard;

import java.time.LocalDate;
import java.util.Random;

public class BankCardGenerator implements Bank {

    private static final DbInteraction dbInteraction = new DbInteraction();

    static {
        dbInteraction.generateBankTableTableIfNotExists();
    }
    @Override
    public BankCard generateBankCard(User user, BankCardType bankCardType) {
        BankCard bankCard = null;
        Random random = new Random();

        switch (bankCardType) {
            case DEBIT -> {
                bankCard = new DebitBankCard(String.valueOf(random.nextInt(0, 1000_000_000)), user, LocalDate.now());
            }
            case CREDIT -> {
                bankCard = new CreditBankCard(String.valueOf(random.nextInt(0, 1000_000_000)), user, LocalDate.now());
            }
        }

        if (bankCard != null) {
            dbInteraction.getDb().executeUpdate(dbInteraction.getStatement(), dbInteraction.insertBankCardQuery(bankCard));
        }
        return bankCard;
    }
}
