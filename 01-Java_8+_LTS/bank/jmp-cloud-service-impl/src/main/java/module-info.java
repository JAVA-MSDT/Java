module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api;
    requires jmp.dto;
    requires jmp.db;
    requires java.sql;

    exports com.javamsdt.cloud.bank;
}