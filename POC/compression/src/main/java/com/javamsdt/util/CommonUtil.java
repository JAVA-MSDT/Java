package com.javamsdt.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonUtil {
    private CommonUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static byte[] readFileFromResources(String folder, String fileName) throws IOException, URISyntaxException {
        Path path = Paths.get(folder, fileName);
        return Files.readAllBytes(path);
    }

    public static Path writeFile(String folder, String fileName, byte[] data) throws IOException {
        Path directoryPath = Paths.get(folder);
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath); // Create folder if it doesn't exist
        }
        Path filePath = directoryPath.resolve(fileName);
        return Files.write(filePath, data);
    }

    public static byte[] buildByteArray(ByteArrayOutputStream outputStream, InputStream inputStream) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        return outputStream.toByteArray();
    }
}
