package org.lynn.demo.rpc.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Header {

  /**
   * 魔数
   */
  private short magic;
  /**
   * 协议版本
   */
  private byte version;
  /**
   * 附加信息
   */
  private byte extraInfo;
  /**
   * 消息ID
   */
  private Long messageId;
  /**
   * 消息体长度
   */
  private Integer size;

  public Header(short magic, byte version, byte extraInfo, long messageId, int size) {
    this.magic = magic;
    this.version = version;
    this.extraInfo = extraInfo;
    this.messageId = messageId;
    this.size = size;
  }
}

