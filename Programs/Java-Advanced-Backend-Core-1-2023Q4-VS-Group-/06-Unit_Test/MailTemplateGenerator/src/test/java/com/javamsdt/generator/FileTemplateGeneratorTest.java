package com.javamsdt.generator;

import com.javamsdt.service.MailTemplateGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileTemplateGeneratorTest {


    @TempDir
    Path tempDir;

    @Test
     void testGenerateTemplate() throws IOException {
        // Create temporary files
        Path inputFile = tempDir.resolve("input.txt");
        Path outputFile = tempDir.resolve("output.txt");

        // Write content to input file
        String inputContent = "Hello, #{name}!";
        Files.writeString(inputFile, inputContent);

        String input = "Hello, #{name}!\nname=John\ndone\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockInputStream);

        // Mock MailTemplateGenerator
        MailTemplateGenerator mockMailTemplateGenerator = mock(MailTemplateGenerator.class);
        when(mockMailTemplateGenerator.generateTemplate(anyMap())).thenReturn("Hello, John!");

        FileTemplateGenerator fileTemplateGenerator = new FileTemplateGenerator(inputFile, outputFile, mockMailTemplateGenerator);
        String result = fileTemplateGenerator.generateTemplate();

        assertEquals("Hello, John!", result);
    }
}