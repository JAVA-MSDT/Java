package com.javamsdt;

import com.javamsdt.compression.factory.CompressionFactory;
import com.javamsdt.compression.service.CompressionService;
import com.javamsdt.decompression.factory.DecompressionFactory;
import com.javamsdt.decompression.service.DecompressionService;
import com.javamsdt.util.Algorithm;
import com.javamsdt.util.CommonUtil;

import java.io.IOException;
import java.net.URISyntaxException;

public class CompressionDecompression {

    public static void main(String[] args) throws IOException, URISyntaxException {

        CompressionFactory compressionFactory = new CompressionFactory();
        CompressionService compressionService = new CompressionService(compressionFactory);

        DecompressionFactory decompressionFactory = new DecompressionFactory();
        DecompressionService decompressionService = new DecompressionService(decompressionFactory);

        // Before running the application, do not forget to change the file names below, and adding your own files for test
        // the project has not files, to reduce the repo size.
        pdfBenchmark(decompressionService, compressionService);

        imageBenchmark(decompressionService, compressionService);

        jsonBenchmark(decompressionService, compressionService);

    }
    
    // Before running the application, do not forget to change the file names below, and adding your own files for test
    // the project has not files, to reduce the repo size.
    private static void pdfBenchmark(DecompressionService decompressionService, CompressionService compressionService) throws IOException, URISyntaxException {
        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("src/files/original/", "LuftHansa.pdf"), "LuftHansa.pdf");
        decompressionService.decompressBenchmark(Algorithm.values(), "LuftHansa.pdf");
    }

    private static void imageBenchmark(DecompressionService decompressionService, CompressionService compressionService) throws IOException, URISyntaxException {
        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("src/files/original/", "profile.jpg"), "profile.jpg");
        decompressionService.decompressBenchmark(Algorithm.values(), "profile.jpg");
    }

    private static void jsonBenchmark(DecompressionService decompressionService, CompressionService compressionService) throws IOException, URISyntaxException {
        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("src/files/original/", "large_json.json"), "large_json.json");
        decompressionService.decompressBenchmark(Algorithm.values(), "large_json.json");
    }
}
