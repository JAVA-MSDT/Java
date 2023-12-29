package com.javamsdt;

import com.javamsdt.generator.ConsoleTemplateGenerator;
import com.javamsdt.generator.FileTemplateGenerator;
import com.javamsdt.generator.TemplateGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(args.length);
        TemplateGenerator templateGenerator = new ConsoleTemplateGenerator();
        if (args.length == 0) {
            System.out.println(templateGenerator.generateTemplate());
        } else if (args.length == 2) {
            templateGenerator = new FileTemplateGenerator(args[0], args[1]);
            System.out.println(templateGenerator.generateTemplate());
        } else {
            System.out.println("Invalid number of arguments. Usage: MessengerApp [inputFile] [outputFile]");
        }
    }
}