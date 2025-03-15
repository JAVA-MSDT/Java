package com.javamsdt;

import com.javamsdt.compression.factory.CompressionFactory;
import com.javamsdt.compression.service.CompressionService;
import com.javamsdt.decompression.decompressor.*;
import com.javamsdt.util.Algorithm;
import com.javamsdt.util.CommonUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class CompressionDecompression {
    private static final Logger logger = Logger.getLogger(CompressionDecompression.class.getName());

    public static void main(String[] args) throws IOException, URISyntaxException {
       compressionBenchmark();
//         decompressionBenchmark();
    }

    private static void decompressionBenchmark() throws IOException, URISyntaxException {
        byte[] compressed = CommonUtil.readFileFromResources("src/files/compressed/ZSTD/", "JVM Arcticture.pdf");
        GZIPDecompressor gzipDecompressor = new GZIPDecompressor();
        InflaterDecompressor inflaterDecompressor = new InflaterDecompressor();
        ZSTDDecompressor lz4Decompressor = new ZSTDDecompressor();
        byte[] decompressed = lz4Decompressor.decompress(compressed);
        CommonUtil.writeFile("src/files/decompressed/ZSTD/", "JVM Arcticture.pdf", decompressed);
    }
    private static void compressionBenchmark() throws IOException, URISyntaxException {
        CompressionFactory compressionFactory = new CompressionFactory();
        CompressionService compressionService = new CompressionService(compressionFactory);
        System.out.println("Compression service started for PDF file");
//        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("src/files/original/", "JVM Arcticture.pdf"), "JVM Arcticture.pdf");
        System.out.println();
        System.out.println("Compression service started for JSON file");
        compressionService.compressBenchmark(Algorithm.values(), CommonUtil.readFileFromResources("src/files/original/", "large_json.json"), "large_json.json");

    }
}
