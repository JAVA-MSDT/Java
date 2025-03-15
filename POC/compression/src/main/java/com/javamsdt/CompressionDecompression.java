package com.javamsdt;

import com.javamsdt.compression.factory.CompressionFactory;
import com.javamsdt.compression.service.CompressionService;
import com.javamsdt.decompression.factory.DecompressionFactory;
import com.javamsdt.decompression.service.DecompressionService;
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

        DecompressionFactory decompressionFactory = new DecompressionFactory();
        DecompressionService decompressionService = new DecompressionService(decompressionFactory);

        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("src/files/original/", "large_json.json"), "large_json.json");
        decompressionService.decompressBenchmark(Algorithm.values(), "large_json.json");

    }
}
