package com.javamsdt;

import com.javamsdt.generator.ConsoleTemplateGenerator;
import com.javamsdt.generator.FileTemplateGenerator;
import com.javamsdt.generator.TemplateGenerator;
import com.javamsdt.service.MailTemplateGenerator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        TemplateGenerator templateGenerator;
        MailTemplateGenerator mailTemplateGenerator = new MailTemplateGenerator();
        if (args.length == 0) {
            mailTemplateGenerator.setTemplate(getStringFromScanner());
            templateGenerator = new ConsoleTemplateGenerator(mailTemplateGenerator);
            LOGGER.info(() -> "ConsoleTemplateGenerator:: " + templateGenerator.generateTemplate());
        } else if (args.length == 2) {
            Path inputPath = Paths.get("src/main/resources", args[0]);
            Path outputPath = Paths.get("src/main/resources", args[1]);
            templateGenerator = new FileTemplateGenerator(inputPath, outputPath, mailTemplateGenerator);
            LOGGER.info(() -> "FileTemplateGenerator:: " + templateGenerator.generateTemplate());
        } else {
            LOGGER.warning("Invalid number of arguments. Usage: MessengerApp [inputFile] [outputFile]");
        }
    }

    private static String getStringFromScanner() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter the template: ");
        return scanner.nextLine();
    }
}