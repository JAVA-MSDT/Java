module main {
    requires jmp.dto;
    requires jmp.bank.api;
    requires jmp.cloud.bank.impl;
    requires transitive jmp.db;
    requires jmp.service.api;
    requires java.sql;
    requires jmp.cloud.service.impl;
}