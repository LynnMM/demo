package org.lynn.demo.rpc;

import javax.naming.BinaryRefAddr;

public class Constants {

  /**
   * 魔数
   */
  public static final short MAGIC = 5;
  /**
   * 消息头大小
   */
  public static final int HEADER_SIZE = 16;

  public static final byte PARSE_MESSAGE_TYPE = 0x01;

  public static final byte PARSE_SERIALIZATION = 0x06;

  public static final byte PARSE_COMPRESSOR = 0x18;

  public static final byte PARSE_REQUEST_TYPE = 0x60;

  public static final byte SERIALIZATION_HESSIAN = 1;

  public static final byte COMPRESSOR_SNAPPY = 1;

  public static final byte HEART_BEAT_REQUEST = 0;
  public static final byte NORMAL_REQUEST = 1;

  public static boolean isHeartBeat(byte extraInfo) {
    if ((PARSE_REQUEST_TYPE & extraInfo) >> 5 == HEART_BEAT_REQUEST){
      return true;
    }

    return false;
  }

//  public static void main(String[] args) {
//
//    byte test = 0x60;
//    String binaryString = Integer.toBinaryString(test);
//    System.out.println(binaryString);
//  }
}



