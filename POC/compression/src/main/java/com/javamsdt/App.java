package com.javamsdt;

import com.javamsdt.util.Algorithm;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("Algorithm | Filename        | Size Before (MB) | Size After (MB) | Time (ms) | Memory (MB)");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Algorithm algorithm : Algorithm.values()) {
            System.out.printf("%-9s | %-15s | %-16s | %-15s | %-9s | %-9s%n",
                    algorithm, "", 1000, 2000, 30000, 4000);
        }
    }
}
