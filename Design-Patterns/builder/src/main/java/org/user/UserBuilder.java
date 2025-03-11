package org.user;

import java.time.LocalDate;

public class UserBuilder {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private LocalDate birthDate;

    // ============================================================================================= //
    // =================================== Constructors Area ======================================= //
    // Only one constructor to build the object as you need with the variants of variables suits you  //
    // ============================================================================================= //
    public UserBuilder(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.phone = builder.phone;
        this.birthDate = builder.birthDate;
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

    @Override
    public String toString() {
        return "UserBuilder{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    // ========================================================================================== //
    // =================================== Static Inner class =================================== //
    // Logics to set the variables as it is needed to save making constructor for each variation  //
    // ========================================================================================== //
    public static class Builder {
        private Long id;
        private String username;
        private String email;
        private String fullName;
        private String phone;
        private LocalDate birthDate;
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
        // ===================================================================================================== //
        // ========================================= Outer Class call only ===================================== //
        // Will be called to build the object after specifying the needed variables to be included in the object //
        // ===================================================================================================== //
        public UserBuilder build() {
            return new UserBuilder(this);
        }
    }
}
