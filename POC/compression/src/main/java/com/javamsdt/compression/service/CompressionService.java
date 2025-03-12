package com.javamsdt.compression.service;

import com.javamsdt.compression.factory.CompressionFactory;
import com.javamsdt.util.Algorithm;
import com.javamsdt.util.BenchmarkUtil;

public class CompressionService {

    private final CompressionFactory compressionFactory;

    public CompressionService(CompressionFactory compressionFactory) {
        this.compressionFactory = compressionFactory;
    }


    public void compress(Algorithm[] algorithms, byte[] data, String filename) {
        System.out.println("Algorithm | Filename        | Size Before (MB) | Size After (MB) | Time (ms) | Memory (MB)");
        System.out.println("----------------------------------------------------------------------------------------------------");

        long sizeBeforeCompression = BenchmarkUtil.getSizeInMegabyte(data.length);

        for (Algorithm algorithm : algorithms) {
            long startMemory = BenchmarkUtil.getUsedMemory();
            long startTime = System.nanoTime();

            byte[] compressed = compressionFactory.compress(algorithm, data);

            long endTime = System.nanoTime();
            long endMemory = BenchmarkUtil.getUsedMemory();

            long timeTaken = BenchmarkUtil.getTakenTimeInMillis(startTime, endTime);
            long memoryUsed = BenchmarkUtil.getMemoryUsedInMegabyte(startMemory, endMemory);
            long sizeAfterCompression = BenchmarkUtil.getSizeInMegabyte(compressed.length);
            System.out.printf("%-9s | %-15s | %-16s | %-15s | %-9s | %-9s%n",
                    algorithm, filename, sizeBeforeCompression, sizeAfterCompression, timeTaken, memoryUsed);
        }
    }
}
