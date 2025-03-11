package org.user;

import java.time.LocalDate;

public class User {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private LocalDate birthDate;

    // =========================================================================================== //
    // =================================== Constructors Area ===================================== //
    // =========== Make a constructor for each variation of variables you do need ================ //
    // =========================================================================================== //
    public User() {
    }

    public User(Long id, String username, String email, String fullName, String phone, LocalDate birthDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // =========================================================================================== //
    // ================================= Setters & Getters Area ================================== //
    // =========================================================================================== //
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

    // =========================================================================================== //
    // =================================== Parent Object Area ==================================== //
    // =========================================================================================== //
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
