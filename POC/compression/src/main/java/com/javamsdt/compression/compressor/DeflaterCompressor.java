package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;

public class DeflaterCompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(DeflaterCompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION); // Highest compression level
        deflater.setInput(data);
        deflater.finish(); // Signal end of data

        byte[] buffer = new byte[1024];
        int compressedLength = deflater.deflate(buffer);
        deflater.end();

        byte[] compressed = Arrays.copyOf(buffer, compressedLength); // Trim to actual compressed size

        logger.log(Level.INFO, "GZIPCompressor compressed the data successfully");
        return compressed;
    }
}
