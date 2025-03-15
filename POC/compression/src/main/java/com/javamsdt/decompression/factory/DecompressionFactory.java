package com.javamsdt.decompression.factory;

import com.javamsdt.decompression.decompressor.*;
import com.javamsdt.decompression.decompressor.api.Decompressor;
import com.javamsdt.util.Algorithm;

public class DecompressionFactory {

    public byte[] decompress(Algorithm algorithm, byte[] data) {
        Decompressor decompressor;
        switch (algorithm) {
            case LZ4 -> decompressor = new LZ4Decompressor();
            case GZIP -> decompressor = new GZIPDecompressor();
            case ZSTD -> decompressor = new ZSTDDecompressor();
            case LZMA -> decompressor = new LZMADecompressor();
            case DEFLATE -> decompressor = new InflaterDecompressor();
            default -> throw new IllegalArgumentException("Unknown algorithm for decompression: " + algorithm);
        }
        return decompressor.decompress(data);
    }
}
