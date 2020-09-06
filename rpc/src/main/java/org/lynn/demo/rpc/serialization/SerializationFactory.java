package org.lynn.demo.rpc.serialization;

import static org.lynn.demo.rpc.Constants.PARSE_SERIALIZATION;
import static org.lynn.demo.rpc.Constants.SERIALIZATION_HESSIAN;

public class SerializationFactory {

  private static final Serialization hessianSerialization = new HessianSerialization();

  public static Serialization get(byte extendInfo){
    if ((PARSE_SERIALIZATION & extendInfo) >> 1 == SERIALIZATION_HESSIAN){
      return hessianSerialization;
    }

    return null;
  }

}
