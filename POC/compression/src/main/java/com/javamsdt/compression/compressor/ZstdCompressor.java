package com.javamsdt.compression.compressor;

import com.github.luben.zstd.Zstd;
import com.javamsdt.compression.compressor.api.Compressor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ZstdCompressor implements Compressor {

    private static final Logger logger = Logger.getLogger(ZstdCompressor.class.getName());

    @Override
    public byte[] compress(byte[] data) {
        byte[] compressed = Zstd.compress(data);
        logger.log(Level.INFO, "ZstdCompressor compressed the data successfully");
        return compressed;
    }
}
