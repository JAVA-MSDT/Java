package com.javamed.etl;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("USERS")
public class User {
    @Id
    private Long id;
    private String login;
}
