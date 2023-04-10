package org.dto.converter.impl;

import org.dto.converter.Converter;
import org.dto.dtos.UserResponse;
import org.dto.modal.User;

public class UserResponseConverter implements Converter<UserResponse, User> {
    @Override
    public UserResponse convert(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFullName(),
                user.getPhone(),
                user.getBirthDate(),
                user.getRole(),
                user.getUserVariable()
        );
    }
}
