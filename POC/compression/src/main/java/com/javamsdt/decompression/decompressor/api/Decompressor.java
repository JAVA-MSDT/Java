package com.javamsdt.decompression.decompressor.api;

public interface Decompressor {
    byte[] decompress(byte[] compressedData);
}
