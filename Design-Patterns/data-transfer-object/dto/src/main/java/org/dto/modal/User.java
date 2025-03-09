package org.dto.modal;

import java.time.LocalDate;

public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phone;
    private LocalDate birthDate;
    private String role;
    private String adminVariable;
    private String userVariable;

    // ============================================================================================= //
    // =================================== Constructors Area ======================================= //
    // Only one constructor to build the object as you need with the variants of variables suits you  //
    // ============================================================================================= //
    public User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.phone = builder.phone;
        this.birthDate = builder.birthDate;
        this.role = builder.role;
        this.adminVariable = builder.adminVariable;
        this.userVariable = builder.userVariable;
    }

    // ============================================================================================ //
    // ====================================== Getters Area ======================================== //
    // Getters only to guarantee immutability of the object after constructing and initializing it  //
    // ============================================================================================ //
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAdminVariable() {
        return adminVariable;
    }

    public String getUserVariable() {
        return userVariable;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", role='" + role + '\'' +
                ", adminVariable='" + adminVariable + '\'' +
                ", userVariable='" + userVariable + '\'' +
                '}';
    }

    // ========================================================================================== //
    // =================================== Static Inner class =================================== //
    // Logics to set the variables as it is needed to save making constructor for each variation  //
    // ========================================================================================== //
    public static class Builder {
        private Long id;
        private String username;
        private String password;
        private String email;
        private String fullName;
        private String phone;
        private LocalDate birthDate;
        private String role;
        private String adminVariable;
        private String userVariable;

        // =================================================================================== //
        // =================================== Setters only ================================== //
        // =================================================================================== //
        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setAdminVariable(String adminVariable) {
            this.adminVariable = adminVariable;
            return this;
        }

        public Builder setUserVariable(String userVariable) {
            this.userVariable = userVariable;
            return this;
        }

        // ===================================================================================================== //
        // ========================================= Outer Class call only ===================================== //
        // Will be called to build the object after specifying the needed variables to be included in the object //
        // ===================================================================================================== //
        public User build() {
            return new User(this);
        }
    }
}
