package com.javamsdt.decompression.decompressor;

import com.javamsdt.decompression.decompressor.api.Decompressor;
import com.javamsdt.util.CommonUtil;
import org.tukaani.xz.XZInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LZMADecompressor implements Decompressor {

    private static final Logger logger = Logger.getLogger(LZMADecompressor.class.getName());

    @Override
    public byte[] decompress(byte[] compressedData) {
        byte[] decompressed;
        try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(compressedData);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             InputStream inputStream = new XZInputStream(arrayInputStream);) {
            decompressed = CommonUtil.buildByteArray(outputStream, inputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error decompressing data in LZMADecompressor.", e);
            throw new RuntimeException(e);
        }
//        logger.log(Level.INFO, "LZMADecompressor compressed the data successfully");
        return decompressed;
    }
}
