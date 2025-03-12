package com.javamsdt.compression.compressor;

import com.javamsdt.compression.compressor.api.Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LZ4Compressor implements Compressor {

    private static final Logger logger = Logger.getLogger(LZ4Compressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        net.jpountz.lz4.LZ4Compressor compressor = factory.fastCompressor();
        byte[] compressed = compressor.compress(data);
        logger.log(Level.INFO, "LZ4Compressor compressed the data successfully");
        return compressed;
    }
}
