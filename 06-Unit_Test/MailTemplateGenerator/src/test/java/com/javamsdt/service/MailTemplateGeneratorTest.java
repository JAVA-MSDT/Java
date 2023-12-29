package com.javamsdt.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MailTemplateGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testReplaceVariablePlaceholders() {
        MailTemplateGenerator generator = new MailTemplateGenerator("Hello, #{name}!");
        String result = generator.generateTemplate(Map.of("name", "John"));
        assertEquals("Hello, John!", result);
    }

    @Test
    void testExceptionIfPlaceholderValueNotProvided() {
        MailTemplateGenerator generator = new MailTemplateGenerator("Hello, #{name}!");
        assertThrows(RuntimeException.class, () -> generator.generateTemplate(Map.of()));
    }

    @Test
    void testIgnoreValuesNotInTemplate() {
        MailTemplateGenerator generator = new MailTemplateGenerator("Hello, #{name}!");
        String result = generator.generateTemplate(Map.of("age", "25"));
        assertEquals("Hello, #{name}!", result);
    }

//    @Test
//    void testSupportValuesWithHash() {
//        MailTemplateGenerator generator = new MailTemplateGenerator("Some text: #{value}");
//        String result = generator.generateTemplate(Map.of("value", "#{tag}"));
//        assertEquals("Some text: #{tag}", result);
//    }

    @Test
    void testSupportLatin1CharacterSet() {
        MailTemplateGenerator generator = new MailTemplateGenerator("Special characters: #{special}");
        String result = generator.generateTemplate(Map.of("special", "üöä"));
        assertEquals("Special characters: üöä", result);
    }
}