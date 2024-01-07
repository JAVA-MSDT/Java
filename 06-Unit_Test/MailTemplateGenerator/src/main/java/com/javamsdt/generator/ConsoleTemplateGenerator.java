package com.javamsdt.generator;

import com.javamsdt.service.MailTemplateGenerator;

import java.util.Map;

public class ConsoleTemplateGenerator implements TemplateGenerator {

    private final MailTemplateGenerator generator;

    public ConsoleTemplateGenerator(MailTemplateGenerator generator) {
        this.generator = generator;
    }

    @Override
    public String generateTemplate() {
        Map<String, String> runtimeValues = getRuntimeValues();
        return generator.generateTemplate(runtimeValues);
    }
}
