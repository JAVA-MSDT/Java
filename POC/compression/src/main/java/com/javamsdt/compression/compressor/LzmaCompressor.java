package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LzmaCompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(LzmaCompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (XZOutputStream xzOS = new XZOutputStream(outputStream, new LZMA2Options())) {
            xzOS.write(data);
            xzOS.finish();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error compressing data in LzmaCompressor.", e);
            throw new RuntimeException(e);
        }
        byte[] compressed = outputStream.toByteArray();
//        logger.log(Level.INFO, "LZ4Compressor compressed the data successfully");
        return compressed;
    }
}
