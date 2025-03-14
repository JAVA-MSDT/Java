package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

public class GZIPCompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(GZIPCompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOS = new GZIPOutputStream(outputStream, Deflater.BEST_COMPRESSION)) {
            gzipOS.write(data);
            gzipOS.finish();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error compressing data in GZIPCompressor.", e);
            throw new RuntimeException(e);
        }
        byte[] compressed = outputStream.toByteArray();
//        logger.log(Level.INFO, "GZIPCompressor compressed the data successfully");
        return compressed;
    }
}
