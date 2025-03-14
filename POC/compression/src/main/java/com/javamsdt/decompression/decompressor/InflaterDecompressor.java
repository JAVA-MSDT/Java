package com.javamsdt.decompression.decompressor;

import com.javamsdt.decompression.Decompressor;
import com.javamsdt.util.CommonUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class InflaterDecompressor implements Decompressor {

    private static final Logger logger = Logger.getLogger(InflaterDecompressor.class.getName());

    @Override
    public byte[] decompress(byte[] compressedData) {
        byte[] decompressed;
        try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(compressedData);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             InputStream inputStream = new InflaterInputStream(arrayInputStream);) {
            decompressed = CommonUtil.buildByteArray(outputStream, inputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error decompressing data in InflaterDecompressor.", e);
            throw new RuntimeException(e);
        }
//        logger.log(Level.INFO, "InflaterDecompressor compressed the data successfully");
        return decompressed;
    }
}
