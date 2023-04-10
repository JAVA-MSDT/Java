package org.dto.dtos;

import java.time.LocalDate;

public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phone;
    private LocalDate birthDate;
    private String role;
    private String userVariable;

    public UserRequest(Long id, String username, String password, String email, String fullName, String phone, LocalDate birthDate, String role, String userVariable) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.role = role;
        this.userVariable = userVariable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserVariable() {
        return userVariable;
    }

    public void setUserVariable(String userVariable) {
        this.userVariable = userVariable;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", role='" + role + '\'' +
                ", userVariable='" + userVariable + '\'' +
                '}';
    }
}
