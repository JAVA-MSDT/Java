package com.javamsdt.decompression.decompressor;

import com.github.luben.zstd.Zstd;
import com.github.luben.zstd.ZstdInputStream;
import com.javamsdt.compression.compressor.api.Compressor;
import com.javamsdt.decompression.Decompressor;
import com.javamsdt.util.CommonUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZSTDDecompressor implements Decompressor {

    private static final Logger logger = Logger.getLogger(ZSTDDecompressor.class.getName());

    @Override
    public byte[] decompress(byte[] compressedData) {
        byte[] decompressed;
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
             ZstdInputStream inputStream = new ZstdInputStream(byteArrayInputStream);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            decompressed = CommonUtil.buildByteArray(outputStream, inputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error decompressing data in ZSTDDecompressor.", e);
            throw new RuntimeException(e);
        }
//        logger.log(Level.INFO, "ZSTDDecompressor decompressed the data successfully");
        return decompressed;
    }
}
