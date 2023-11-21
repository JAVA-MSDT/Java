package com.javamsdt.cloud.bank;

import com.javamsdt.bank.db.Db;
import com.javamsdt.bank.domain.Subscription;
import com.javamsdt.bank.domain.User;
import com.javamsdt.bank.domain.bankcard.BankCard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbInteraction {
    private final Db db = Db.getInstance();
    private final Connection connection = db.getConnection();
    private final Statement statement = db.getStatement(connection);

    // ============ Start of Common interaction of DB ============ //

    public ResultSet selectQuery(String table, String parameter, String value) {
        String sql;
        if (parameter.isEmpty() && value.isEmpty()) {
            sql = "SELECT * FROM " + table;
        } else {
            sql = "SELECT * FROM " + table + " WHERE " + parameter + " = " + value;
        }
        return db.executeQuery(statement, sql);
    }
    // ============ End of Common interaction of DB ============ //

    // ============ Start of Bank Card Db Records ============ //
    public void generateBankTableTableIfNotExists() {
        String sql = "Create table IF NOT EXISTS bank_card" +
                "(NUMBER varchar(50) primary key," +
                " name varchar(50)," +
                " surname varchar(50)," +
                " birthday varchar(50), " +
                " start_date varchar(50), " +
                " card_type varchar(50) " +
                ")";
        db.generateTable(statement, sql);
    }

    public String insertBankCardQuery(BankCard bankCard) {
        return "Insert into bank_card" +
                "(NUMBER, name, surname, birthday, start_date, card_type)" +
                " values " +
                "(" + "'" + bankCard.getNumber() + "'"
                + ", " + "'" + bankCard.getUser().getName() + "'"
                + ", " + "'" + bankCard.getUser().getSurname() + "'"
                + ", " + "'" + bankCard.getUser().getBirthday().toString() + "'"
                + ", " + "'" + bankCard.getStartDate().toString() + "'"
                + ", " + "'" + bankCard.getCardType() + "'"
                + ")";
    }

    private BankCard getBankCardFromResultSet(ResultSet resultSet) {
        BankCard bankCard = new BankCard();
        try {
            bankCard.setNumber(resultSet.getString("NUMBER"));
            bankCard.setUser(getUserFromResultSet(resultSet));
            bankCard.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
            bankCard.setCardType(resultSet.getString("card_type"));
        } catch (SQLException e) {
            System.err.println("Error Getting BankCard from ResultSet");
            throw new RuntimeException(e);
        }
        return bankCard;
    }
    // ============ End of Bank Card Db Records ============ //

    // ============ Start of User Db Records ============ //
    private User getUserFromResultSet(ResultSet resultSet) {
        User user = new User();
        try {
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
        } catch (SQLException e) {
            System.err.println("Error Getting User from ResultSet");
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        var resultSet = selectQuery("bank_card", "", "");
        try (resultSet) {
            while (resultSet.next()) {
                users.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println("Error Getting List of Users from ResultSet");
            throw new RuntimeException(e);
        }
        return users;
    }
    // ============ End of User Db Records ============ //

    // ============ Start of Subscription Db Records ============ //
    public void generateSubscriptionTableIfNotExists() {
        String sql = "Create table IF NOT EXISTS subscription" +
                "(CARD_NUMBER varchar(50) primary key," +
                " bank_card varchar(50)," +
                " start_date varchar(50)" +
                ")";
        db.generateTable(statement, sql);
    }

    public String insertSubscriptionQuery(BankCard bankCard) {
        return "Insert into subscription" +
                "(CARD_NUMBER, bank_card, start_date)" +
                " values " +
                "(" + "'" + bankCard.getNumber() + "'"
                + ", " + "'" + bankCard.getCardType() + "'"
                + ", " + "'" + bankCard.getStartDate().toString() + "'"
                + ")";
    }

    public List<Subscription> findAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        var resultSet = selectQuery("subscription", "", "");
        try (resultSet) {
            while (resultSet.next()) {
                subscriptions.add(getSubscriptionFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println("Error Getting List of Subscriptions from ResultSet");
            throw new RuntimeException(e);
        }
        return subscriptions;
    }

    public Optional<Subscription> findSubscriptionByCardNumber(String cardNumber) {
        Optional<Subscription> subscription = Optional.empty();
        var resultSet = selectQuery("subscription", "CARD_NUMBER", cardNumber);
        try (resultSet) {
            while (resultSet.next()) {
                subscription = Optional.of(getSubscriptionFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println("Error Getting Subscription Optional from ResultSet");
            throw new RuntimeException(e);
        }
        return subscription;
    }

    private Subscription getSubscriptionFromResultSet(ResultSet resultSet) {
        Subscription subscription = new Subscription();
        try {
            subscription.setCardNumber(resultSet.getString("CARD_NUMBER"));
            subscription.setBankcard(resultSet.getString("bank_card"));
            subscription.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
        } catch (SQLException e) {
            System.err.println("Error Getting Subscription from ResultSet");
            throw new RuntimeException(e);
        }
        return subscription;
    }

    // ============ End of Subscription Db Records ============ //
    public Db getDb() {
        return db;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
