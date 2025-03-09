package org.dto.dtos;

import java.time.LocalDate;

public class UserResponseForAdmin {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private LocalDate birthDate;
    private String role;
    private String adminVariable;

    public UserResponseForAdmin(Long id, String username, String email, String fullName, String phone, LocalDate birthDate, String role, String adminVariable) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.role = role;
        this.adminVariable = adminVariable;
    }

    @Override
    public String toString() {
        return "UserResponseForAdmin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", role='" + role + '\'' +
                ", adminVariable='" + adminVariable + '\'' +
                '}';
    }
}
