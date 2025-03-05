module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires transitive jmp.dto;
    requires jmp.cloud.bank.impl;
    requires jmp.db;

    exports com.javamsdt.cloud.service;
}