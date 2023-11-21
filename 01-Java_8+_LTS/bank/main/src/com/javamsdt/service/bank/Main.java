package com.javamsdt.service.bank;

import com.javamsdt.bank.api.Bank;
import com.javamsdt.bank.domain.Subscription;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;
import com.javamsdt.bank.domain.bankcard.BankCardType;
import com.javamsdt.cloud.bank.BankCardGenerator;
import com.javamsdt.cloud.service.BankServiceImpl;
import com.javamsdt.service.api.BankService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        Bank cardGenerator = new BankCardGenerator();
        User creditUser = new User("Credit", "user", LocalDate.now().minusYears(20));
        User debitUser = new User("Debit", "user", LocalDate.now().minusYears(15));

        // ====== Generating Bank Cards ====== //
        BankCard credit = cardGenerator.generateBankCard(creditUser, BankCardType.CREDIT);
        BankCard debit = cardGenerator.generateBankCard(debitUser, BankCardType.DEBIT);


        // ====== Working with Bank Service ====== //
        BankService bankService = new BankServiceImpl();

        //  Subscribe to a Card.
        bankService.subscribe(credit);
        bankService.subscribe(debit);

        //  Get Optional Subscription by card number.
        Optional<Subscription> creditOptional = bankService.getSubscriptionByBankCardNumber(credit.getNumber());
        Optional<Subscription> debitOptional = bankService.getSubscriptionByBankCardNumber(debit.getNumber());

        creditOptional.ifPresent(System.out::println);
        debitOptional.ifPresent(System.out::println);

        // Get All users
        bankService.getAllUsers().forEach(System.out::println);


    }

}