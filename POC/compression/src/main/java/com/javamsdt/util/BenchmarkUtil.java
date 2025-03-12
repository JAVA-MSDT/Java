package com.javamsdt.util;

public class BenchmarkUtil {

    private BenchmarkUtil() {
        throw new AssertionError();
    }

    public static long getUsedMemory() {
        System.gc();
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long getTakenTimeInMillis(long startTime, long endTime) {
        return (endTime - startTime) / 1_000_000;
    }

    public static long getMemoryUsedInMegabyte(long startMemory, long endMemory) {
        return (endMemory - startMemory) / (1024 * 1024);
    }

    public static long getSizeInMegabyte(long size) {
        return size / (1024 * 1024);
    }
}
