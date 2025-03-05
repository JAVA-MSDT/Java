package com.javamsdt.generator;

import com.javamsdt.service.MailTemplateGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileTemplateGenerator implements TemplateGenerator{

    private final Path inputPath;
    private final Path outputPath;
    private final MailTemplateGenerator generator;

    public FileTemplateGenerator(Path inputPath, Path outputPath, MailTemplateGenerator generator) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.generator = generator;
    }

    @Override
    public String generateTemplate() {
        String result = "";
        try {
            String template = Files.readString(inputPath);
            generator.setTemplate(template);
            Map<String, String> runtimeValues = getRuntimeValues();
            result = generator.generateTemplate(runtimeValues);
            Files.writeString(outputPath, result);
           LOGGER.info(() -> "Generated Message written to " + outputPath);
        } catch (IOException e) {
            LOGGER.warning("Error reading/writing files: " + e);
        }
        return result;
    }
}
