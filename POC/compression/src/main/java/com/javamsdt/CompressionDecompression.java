package com.javamsdt;

import com.javamsdt.compression.factory.CompressionFactory;
import com.javamsdt.compression.service.CompressionService;
import com.javamsdt.util.Algorithm;
import com.javamsdt.util.CommonUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class CompressionDecompression {
    private static final Logger logger = Logger.getLogger(CompressionDecompression.class.getName());

    public static void main(String[] args) throws IOException, URISyntaxException {
        CompressionFactory compressionFactory = new CompressionFactory();
        CompressionService compressionService = new CompressionService(compressionFactory);
        System.out.println("Compression service started for PDF file");
        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("originalFiles", "JVM Arcticture.pdf"), "JVM Arcticture.pdf");
        System.out.println();
        System.out.println("Compression service started for JSON file");
        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("originalFiles", "large_json.json"), "large_json.json");

    }
}
