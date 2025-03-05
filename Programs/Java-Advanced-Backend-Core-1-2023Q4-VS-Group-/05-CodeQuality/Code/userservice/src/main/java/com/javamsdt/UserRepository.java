package com.javamsdt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.username().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsersByEmail(String email) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.email().equals(email)) {
                result.add(user);
            }
        }
        return result;
    }

    public List<User> getUsersByDateOfBirth(String dateOfBirth) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.dateOfBirth().equals(dateOfBirth)) {
                result.add(user);
            }
        }
        return result;
    }

    public List<User> getUsersByAddress(String address) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.address().equals(address)) {
                result.add(user);
            }
        }
        return result;
    }

    public void updateUser(User updatedUser) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.username().equals(updatedUser.username())) {
                iterator.remove();
                users.add(updatedUser);
                break;
            }
        }
    }

    public void deleteUser(String username) {
        users.removeIf(user -> user.username().equals(username));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
