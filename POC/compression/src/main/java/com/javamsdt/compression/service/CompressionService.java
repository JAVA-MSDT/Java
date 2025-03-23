package com.javamsdt.compression.service;

import com.javamsdt.compression.factory.CompressionFactory;
import com.javamsdt.util.Algorithm;
import com.javamsdt.util.BenchmarkUtil;
import com.javamsdt.util.CommonUtil;

import java.io.IOException;

public class CompressionService {

    private final CompressionFactory compressionFactory;

    public CompressionService(CompressionFactory compressionFactory) {
        this.compressionFactory = compressionFactory;
    }


    public void compressBenchmark(Algorithm[] algorithms, byte[] data, String filename) throws IOException {
        System.out.println("------------------------------------------ Compression Benchmark --------------------------------------------------");
        System.out.println("Algorithm | Filename            | Size Before (KB) | Size After (KB) | Reduction By: (KB) | Time (ms) | Memory (KB)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        long sizeBeforeCompression = BenchmarkUtil.getSizeInKB(data.length);

        for (Algorithm algorithm : algorithms) {
            long startMemory = BenchmarkUtil.getUsedMemory();
            long startTime = System.nanoTime();

            byte[] compressed = compressionFactory.compress(algorithm, data);

            long endTime = System.nanoTime();
            long endMemory = BenchmarkUtil.getUsedMemory();

            long timeTaken = BenchmarkUtil.getTakenTimeInMillis(startTime, endTime);
            long memoryUsed = BenchmarkUtil.getMemoryUsedInKB(startMemory, endMemory);
            long sizeAfterCompression = BenchmarkUtil.getSizeInKB(compressed.length);
            long reduction = sizeBeforeCompression - sizeAfterCompression;
            CommonUtil.writeFile("src/files/compressed/" + algorithm.name(), filename, compressed);
            System.out.printf("%-9s | %-19s | %-16s | %-15s | %-18s | %-9s | %-9s%n",
                    algorithm, filename, sizeBeforeCompression, sizeAfterCompression, reduction, timeTaken, memoryUsed);
        }
    }
}
