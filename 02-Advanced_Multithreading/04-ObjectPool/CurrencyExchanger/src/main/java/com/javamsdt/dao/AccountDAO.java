package com.javamsdt.dao;

import com.javamsdt.entity.UserAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccountDAO {
    private static final String ACCOUNTS_DIRECTORY = "user_accounts";

    public void saveAccount(UserAccount account) {
        File directory = new File(ACCOUNTS_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(directory, account.getUsername())))) {
            oos.writeObject(account);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserAccount loadAccount(String username) {
        File file = new File(ACCOUNTS_DIRECTORY, username);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (UserAccount) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
