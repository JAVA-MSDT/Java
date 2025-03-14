package com.javamsdt.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonUtil {
    private CommonUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static byte[] readFileFromResources(String folder, String fileName) throws IOException, URISyntaxException {
        Path path = Paths.get("src/files", folder, fileName);
        return Files.readAllBytes(path);
    }

    public static Path writeFile(String folder, String fileName, byte[] data) throws IOException {
        Path directoryPath = Paths.get("src/files", folder); // Relative path to src/files/folderName
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath); // Create folder if it doesn't exist
        }
        Path filePath = directoryPath.resolve(fileName);
        return Files.write(filePath, data);
    }
}
