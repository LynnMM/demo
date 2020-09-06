package org.lynn.demo.rpc.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

}

