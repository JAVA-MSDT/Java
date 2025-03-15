package com.javamsdt.compression.compressor;

import com.github.luben.zstd.Zstd;
import com.github.luben.zstd.ZstdOutputStream;
import com.javamsdt.compression.compressor.api.Compressor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZSTDCompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(ZSTDCompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        byte[] compressed;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ZstdOutputStream zstdOutputStream = new ZstdOutputStream(byteArrayOutputStream, 3).setWorkers(1)) {
            zstdOutputStream.write(data);
            zstdOutputStream.close();
            compressed = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error compressing data in ZSTDCompressor.", e);
            throw new RuntimeException(e);
        }
//        logger.log(Level.INFO, "ZSTDCompressor compressed the data successfully");
        return compressed;
    }
}
