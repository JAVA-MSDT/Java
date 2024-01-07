package com.javamsdt.generator;

import com.javamsdt.service.MailTemplateGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileTemplateGenerator implements TemplateGenerator{

    private final String inputFile;
    private final String outputFile;

    public FileTemplateGenerator(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public String generateTemplate() {
        String result = "";
        try {
            Path inputPath = Paths.get("src/main/resources",inputFile);
            Path outputPath = Paths.get("src/main/resources",outputFile);
            String template = Files.readString(inputPath);
            MailTemplateGenerator generator = new MailTemplateGenerator();
            generator.setTemplate(template);
            Map<String, String> runtimeValues = getRuntimeValues();
            result = generator.generateTemplate(runtimeValues);
            Files.writeString(outputPath, result);
            System.out.println("Generated Message written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error reading/writing files: " + e);
        }
        return result;
    }
}
