package com.javamsdt.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public interface TemplateGenerator {
    Logger LOGGER = Logger.getLogger(TemplateGenerator.class.getName());
    String generateTemplate();

    default Map<String, String> getRuntimeValues() {
        Map<String, String> values = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter runtime values (key=value), type 'done' when finished:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] keyValue = input.split("=");
            if (keyValue.length == 2) {
                values.put(keyValue[0], keyValue[1]);
            } else {
                LOGGER.warning("Invalid input. Please use the format key=value.");
            }
        }
        return values;
    }
}
