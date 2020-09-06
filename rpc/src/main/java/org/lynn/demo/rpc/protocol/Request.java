package org.lynn.demo.rpc.protocol;

import java.io.Serializable;
import lombok.Data;

@Data
public class Request implements Serializable {

  /**
   * 请求的Service类名
   */
  private String serviceName;
  /**
   * 请求的方法名称
   */
  private String methodName;
  /**
   * 请求方法的参数类型
   */
  private Class[] argTypes;
  /**
   * 请求方法的参数
   */
  private Object[] args;

}
