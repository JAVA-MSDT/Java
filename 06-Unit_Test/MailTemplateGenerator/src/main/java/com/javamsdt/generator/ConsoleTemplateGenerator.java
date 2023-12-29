package com.javamsdt.generator;

import com.javamsdt.service.MailTemplateGenerator;

import java.util.Map;
import java.util.Scanner;

public class ConsoleTemplateGenerator implements TemplateGenerator {


    @Override
    public String generateTemplate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the template: ");
        String template = scanner.nextLine();
        MailTemplateGenerator generator = new MailTemplateGenerator(template);
        Map<String, String> runtimeValues = getRuntimeValues();
        String result = generator.generateTemplate(runtimeValues);
        System.out.println("Generated Message: " + result);
        return result;
    }
}
