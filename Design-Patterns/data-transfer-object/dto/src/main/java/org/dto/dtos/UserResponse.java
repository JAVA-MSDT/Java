package org.dto.dtos;

import java.time.LocalDate;

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private LocalDate birthDate;
    private String role;
    private String userVariable;

    public UserResponse(Long id, String username, String email, String fullName, String phone, LocalDate birthDate, String role, String userVariable) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.role = role;
        this.userVariable = userVariable;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", role='" + role + '\'' +
                ", userVariable='" + userVariable + '\'' +
                '}';
    }
}
