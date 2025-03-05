package com.javamsdt.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Currency implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String code;

    public Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                '}';
    }
}
