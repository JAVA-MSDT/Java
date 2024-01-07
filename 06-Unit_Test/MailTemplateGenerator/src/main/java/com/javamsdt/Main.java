package com.javamsdt;

import com.javamsdt.generator.ConsoleTemplateGenerator;
import com.javamsdt.generator.FileTemplateGenerator;
import com.javamsdt.generator.TemplateGenerator;
import com.javamsdt.service.MailTemplateGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TemplateGenerator templateGenerator;
        MailTemplateGenerator mailTemplateGenerator = new MailTemplateGenerator();
        if (args.length == 0) {
            mailTemplateGenerator.setTemplate(getStringFromScanner());
            templateGenerator = new ConsoleTemplateGenerator(mailTemplateGenerator);
            System.out.println(templateGenerator.generateTemplate());
        } else if (args.length == 2) {
            templateGenerator = new FileTemplateGenerator(args[0], args[1]);
            System.out.println(templateGenerator.generateTemplate());
        } else {
            System.out.println("Invalid number of arguments. Usage: MessengerApp [inputFile] [outputFile]");
        }
    }

    private static String getStringFromScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the template: ");
        String template = scanner.nextLine();
        return template;
    }
}