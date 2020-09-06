package org.lynn.demo.rpc.protocol;

import java.io.Serializable;
import lombok.Data;

@Data
public class Response implements Serializable{

  /**
   * 响应的错误码，正常响应为0，非0表示异常响应
   */
  private int code = 0;
  /**
   * 异常信息
   */
  private String errMsg;
  /**
   * 响应结果
   */
  private Object result;
}