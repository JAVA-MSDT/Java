package com.javamsdt.service;

import java.util.Map;

public class MailTemplateGenerator {

    private final String template;

    public MailTemplateGenerator(String template) {
        this.template = template;
    }

    public String generateTemplate(Map<String, String> values) {
        String result = template;
        for (Map.Entry<String, String> entry : values.entrySet()) {
            String placeholder = "#{" + entry.getKey() + "}";
            if(template.contains(placeholder)) {
                result = result.replace(placeholder, entry.getValue());
            } else {
                return template;
            }
        }
        if (result.contains("#{")) {
            throw new RuntimeException("Not all placeholder values provided");
        }
        return result;
    }
}
