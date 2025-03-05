package com.javamsdt.bank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    private static Db INSTANCE;

    private Db() {
    }

    public static Db getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Db();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        String jdbcURL = "jdbc:h2:mem:test";

        try {
            return DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            System.err.println("Unable to connect to H2 DB");
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Unable to get a statement from connection");
            throw new RuntimeException(e);
        }
    }

    public void generateTable(Statement statement, String sqlGenerate) {
        try {
            statement.execute(sqlGenerate);
        } catch (SQLException e) {
            System.err.println("Unable to generate a table!!");
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate(Statement statement, String sqlUpdate) {
        try {
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            System.err.println("Unable to execute update!!");
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(Statement statement, String sqlQuery) {
        try {
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            System.err.println("Unable to execute query!!");
            throw new RuntimeException(e);
        }
    }
}
