package com.javamsdt.compression.factory;

import com.javamsdt.compression.compressor.*;
import com.javamsdt.compression.compressor.api.Compressor;
import com.javamsdt.util.Algorithm;

public class CompressionFactory {

    public byte[] compress(Algorithm algorithm, byte[] data) {
        Compressor compressor;
        switch (algorithm) {
            case LZ4 -> compressor = new LZ4Compressor();
            case GZIP -> compressor = new GZIPCompressor();
            case ZSTD -> compressor = new ZstdCompressor();
            case LZMA -> compressor = new LzmaCompressor();
            case DEFLATE -> compressor = new DeflaterCompressor();
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
        return compressor.compress(data);
    }
}
