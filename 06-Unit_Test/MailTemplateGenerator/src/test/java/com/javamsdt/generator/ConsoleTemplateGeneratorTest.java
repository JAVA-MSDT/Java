package com.javamsdt.generator;

import com.javamsdt.service.MailTemplateGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsoleTemplateGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateTemplate() {
        // Mock System.in and System.out
        String input = "Hello, #{name}!\nname=John\ndone\n";
        InputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockInputStream);

//        ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(mockOutputStream));

        // Mock MailTemplateGenerator
        MailTemplateGenerator mockMailTemplateGenerator = mock(MailTemplateGenerator.class);
        when(mockMailTemplateGenerator.generateTemplate(anyMap())).thenReturn("Hello, John!");

        ConsoleTemplateGenerator consoleTemplateGenerator = new ConsoleTemplateGenerator(mockMailTemplateGenerator);
        String result = consoleTemplateGenerator.generateTemplate();

       // assertEquals("Generated Message: Hello, John!\n", mockOutputStream.toString());
        assertEquals("Hello, John!", result);

        // Reset System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);
    }
}