package com.javamed.etl.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public record User(@Id Long id, String login) {
    public User(String login) {
        this(null, login);
    }
}
