package com.javamsdt.service.bank;

import com.javamsdt.bank.api.Bank;
import com.javamsdt.bank.domain.Subscription;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;
import com.javamsdt.bank.domain.bankcard.BankCardType;
import com.javamsdt.cloud.bank.BankCardGenerator;
import com.javamsdt.cloud.service.BankServiceImpl;
import com.javamsdt.cloud.service.SubscriptionException;
import com.javamsdt.service.api.BankService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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
        Subscription creditOptional = bankService.getSubscriptionByBankCardNumber(credit.getNumber())
                .orElseThrow(() -> new SubscriptionException("Subscription with the provided card number is not exist"));
        Subscription debitOptional = bankService.getSubscriptionByBankCardNumber(debit.getNumber())
                .orElseThrow(() -> new SubscriptionException("Subscription with the provided card number is not exist"));

        System.out.println(creditOptional);
        System.out.println(debitOptional);
        System.out.println("getAverageUsersAge:: " + bankService.getAverageUsersAge());
        System.out.println("isPayableUser Over 18 years:: " + BankService.isPayableUser(creditUser));
        System.out.println("isPayableUser Over 18 years:: " + BankService.isPayableUser(debitUser));

        // Get All users
        List<User> users = bankService.getAllUsers();
        users.forEach(System.out::println);


    }

}