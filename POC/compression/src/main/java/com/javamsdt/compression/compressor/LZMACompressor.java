package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LZMACompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(LZMACompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        byte[] compressed;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (XZOutputStream xzOS = new XZOutputStream(outputStream, new LZMA2Options())) {
            xzOS.write(data);
            xzOS.finish();
            compressed = outputStream.toByteArray();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error compressing data in LzmaCompressor.", e);
            throw new RuntimeException(e);
        }

//        logger.log(Level.INFO, "LZ4Compressor compressed the data successfully");
        return compressed;
    }
}
