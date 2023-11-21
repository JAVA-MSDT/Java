package com.javamsdt.bank.api;

import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;
import com.javamsdt.bank.domain.bankcard.BankCardType;

public interface Bank {
    BankCard generateBankCard(User user, BankCardType bankCardType);
}
