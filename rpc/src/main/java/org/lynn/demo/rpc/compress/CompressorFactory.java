package org.lynn.demo.rpc.compress;

import static org.lynn.demo.rpc.Constants.COMPRESSOR_SNAPPY;
import static org.lynn.demo.rpc.Constants.PARSE_COMPRESSOR;

public class CompressorFactory {

  private static final Compressor snappyCompressor = new SnappyCompressor();

  public static Compressor get(byte extraInfo) {
    if ((PARSE_COMPRESSOR & extraInfo) >> 3 == COMPRESSOR_SNAPPY){
      return snappyCompressor;
    }

    return null;
  }
}
