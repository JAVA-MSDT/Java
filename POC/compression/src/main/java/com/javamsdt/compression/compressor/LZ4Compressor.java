package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;
import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Factory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LZ4Compressor implements Compressor {

    private static final Logger logger = Logger.getLogger(LZ4Compressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        byte[] compressed;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try(LZ4BlockOutputStream blockOutputStream = new LZ4BlockOutputStream(outputStream)) {
            blockOutputStream.write(data);
            blockOutputStream.finish();
            compressed = outputStream.toByteArray();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error compressing data in LZ4Compressor.", e);
            throw new RuntimeException(e);
        }
//        logger.log(Level.INFO, "LZ4Compressor compressed the data successfully");
        return compressed;
    }
}
