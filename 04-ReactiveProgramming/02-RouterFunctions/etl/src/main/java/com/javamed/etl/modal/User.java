package com.javamed.etl.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(String login) {
        this.login = login;
    }

    @Id
    private Long id;
    private String login;
}
