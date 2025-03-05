package com.javamsdt.service;

import java.util.Map;

public class MailTemplateGenerator {

    private String template;

    public String generateTemplate(Map<String, String> values) {
        String result = getTemplate();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            String placeholder = "#{" + entry.getKey() + "}";
            if(result.contains(placeholder)) {
                result = result.replace(placeholder, entry.getValue());
            } else {
                return result;
            }
        }
        if (result.contains("#{")) {
            throw new RuntimeException("Not all placeholder values provided");
        }
        return result;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
