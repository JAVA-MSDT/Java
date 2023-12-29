package com.javamsdt.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface TemplateGenerator {
    String generateTemplate();

    default Map<String, String> getRuntimeValues() {
        Map<String, String> values = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter runtime values (key=value), type 'done' when finished:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] keyValue = input.split("=");
            if (keyValue.length == 2) {
                values.put(keyValue[0], keyValue[1]);
            } else {
                System.out.println("Invalid input. Please use the format key=value.");
            }
        }
        return values;
    }
}
