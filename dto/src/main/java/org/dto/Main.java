package org.dto;

import org.dto.converter.impl.UserConverter;
import org.dto.converter.impl.UserResponseConverter;
import org.dto.dtos.UserResponse;
import org.dto.modal.User;
import org.dto.util.UserData;

public class Main {
    public static void main(String[] args) {
        UserConverter userConverter = new UserConverter();
        UserResponseConverter userResponseConverter = new UserResponseConverter();

        User user = userConverter.convert(UserData.getUserRequest());
        UserResponse userResponse = userResponseConverter.convert(UserData.getUser());

        System.out.println(" ====================================== ");
        System.out.println(" ================ User ================ ");
        System.out.println(" ====================================== ");
        System.out.println(user);

        System.out.println(" ====================================== ");
        System.out.println(" ============= User Response ========== ");
        System.out.println(" ====================================== ");
        System.out.println(userResponse);
    }

}