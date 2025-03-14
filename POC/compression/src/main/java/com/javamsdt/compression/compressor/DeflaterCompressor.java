package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;

public class DeflaterCompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(DeflaterCompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        byte[] compressed;
        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish(); // Signal end of data

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024]; // Reasonable buffer size
            while (!deflater.finished()) {
                int compressedLength = deflater.deflate(buffer);
                outputStream.write(buffer, 0, compressedLength);
            }
            deflater.end();
            compressed = outputStream.toByteArray();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error compressing data in DeflaterCompressor.", e);
            throw new RuntimeException("Error during compression", e);
        }

//        logger.log(Level.INFO, "DeflaterCompressor compressed the data successfully");
        return compressed;
    }
}
