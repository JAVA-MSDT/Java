package com.javamsdt;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
    @SuppressWarnings({})
    public List<User> getUsersByParameter(String parameter, String value) {
        List<User> result = new ArrayList<>();
        switch (parameter.toLowerCase()) {
            case "username" -> result.add(userRepository.getUserByUsername(value));
            case "email" -> result.addAll(userRepository.getUsersByEmail(value));
            case "dateofbirth" -> result.addAll(userRepository.getUsersByDateOfBirth(value));
            case "address" -> result.addAll(userRepository.getUsersByAddress(value));
            default -> LOGGER.log(Level.WARNING, "Invalid parameter: {0}", parameter);
        }
        return result;
    }

}

