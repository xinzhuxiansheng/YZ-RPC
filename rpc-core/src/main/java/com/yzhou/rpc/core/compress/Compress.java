package com.yzhou.rpc.core.compress;

import com.yzhou.rpc.common.extension.SPI;

/**
 */

@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
