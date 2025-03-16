package com.javamsdt.decompression.service;

import com.javamsdt.decompression.factory.DecompressionFactory;
import com.javamsdt.util.Algorithm;
import com.javamsdt.util.BenchmarkUtil;
import com.javamsdt.util.CommonUtil;

import java.io.IOException;
import java.net.URISyntaxException;

public class DecompressionService {

    private final DecompressionFactory decompressionFactory;

    public DecompressionService(DecompressionFactory decompressionFactory) {
        this.decompressionFactory = decompressionFactory;
    }


    public void decompressBenchmark(Algorithm[] algorithms, String filename) throws IOException, URISyntaxException {
        System.out.println("--------------------------------- Decompression Benchmark ------------------------------------------");
        System.out.println("Algorithm | Filename            | Size Before (B) | Size After (B) | Time (ms) | Memory (MB)");
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Algorithm algorithm : algorithms) {
            byte[] data = CommonUtil.readFileFromResources("src/files/compressed/" + algorithm.name() + "/", filename);
            long startMemory = BenchmarkUtil.getUsedMemory();
            long startTime = System.nanoTime();

            byte[] compressed = decompressionFactory.decompress(algorithm, data);

            long endTime = System.nanoTime();
            long endMemory = BenchmarkUtil.getUsedMemory();

            long timeTaken = BenchmarkUtil.getTakenTimeInMillis(startTime, endTime);
            long memoryUsed = BenchmarkUtil.getMemoryUsedInMegabyte(startMemory, endMemory);
            long sizeAfterCompression = BenchmarkUtil.getSizeInMegabyte(compressed.length);
            CommonUtil.writeFile("src/files/decompressed/" + algorithm.name(), filename, compressed);
            System.out.printf("%-9s | %-19s | %-16s | %-15s | %-9s | %-9s%n",
                    algorithm, filename, BenchmarkUtil.getSizeInMegabyte(data.length), sizeAfterCompression, timeTaken, memoryUsed);
        }
    }
}
