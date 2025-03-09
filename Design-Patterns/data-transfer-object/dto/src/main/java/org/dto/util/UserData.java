package org.dto.util;

import org.dto.dtos.UserRequest;
import org.dto.dtos.UserRequestForAdmin;
import org.dto.dtos.UserResponse;
import org.dto.dtos.UserResponseForAdmin;
import org.dto.modal.User;

import java.time.LocalDate;

public class UserData {

    public static User getUser() {
        return new User.Builder()
                .setId(1L)
                .setUsername("User name")
                .setEmail("email@email.com")
                .setPassword("password")
                .setPhone("000 000 000 000")
                .setFullName("Full name")
                .setBirthDate(LocalDate.now())
                .setRole("Role")
                .setUserVariable("User Variable")
                .setAdminVariable("Admin Variable")
                .build();
    }

    public static UserRequest getUserRequest() {
        return new UserRequest(
                1L,
                "User name",
                "password",
                "email@email.com",
                "Full name",
                "000 000 000 000",
                LocalDate.now(),
                "Role",
                "User Variable"
        );
    }
    public static UserResponse getUserResponse() {
        return new UserResponse(
                1L,
                "User name",
                "email@email.com",
                "Full name",
                " 000 000 000 000",
                LocalDate.now(),
                "Role",
                "User Variable"
        );
    }

    public static UserRequestForAdmin getUserRequestForAdmin() {
        return new UserRequestForAdmin(
                1L,
                "User name",
                "email@email.com",
                "Full name",
                "000 000 000 000",
                LocalDate.now(),
                "Role",
                "Admin Variable"
        );
    }
    public UserResponseForAdmin getUserResponseForAdmin() {
        return new UserResponseForAdmin(
                1L,
                "User name",
                "email@email.com",
                "Full name",
                " 000 000 000 000",
                LocalDate.now(),
                "Role",
                "Admin Variable"
        );
    }
}
