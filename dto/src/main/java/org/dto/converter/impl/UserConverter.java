package org.dto.converter.impl;

import org.dto.converter.Converter;
import org.dto.dtos.UserRequest;
import org.dto.modal.User;

public class UserConverter implements Converter<User, UserRequest> {
    @Override
    public User convert(UserRequest userRequest) {
        return new User.Builder()
                .setId(userRequest.getId())
                .setUsername(userRequest.getUsername())
                .setFullName(userRequest.getFullName())
                .setPassword(userRequest.getPassword())
                .setRole(userRequest.getRole())
                .setUserVariable(userRequest.getUserVariable())
                .setBirthDate(userRequest.getBirthDate())
                .setEmail(userRequest.getEmail())
                .setPhone(userRequest.getPhone())
                .build();


    }
}
