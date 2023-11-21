package com.javamsdt.service.api;

import com.javamsdt.bank.domain.Subscription;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public interface BankService {
    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

    List<User> getAllUsers();

    default double getAverageUsersAge() {

        OptionalDouble averageAge = getAllUsers()
                .stream()
                .filter(user -> user.getBirthday() != null)
                .mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()))
                .average();

        if (averageAge.isPresent()) {
            return averageAge.getAsDouble();
        }
        return 0;
    }

    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) > 18;
    }

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate);
}
