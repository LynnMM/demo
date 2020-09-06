package org.lynn.demo.spi.impl;

import org.lynn.demo.spi.Log;

public class Log4j implements Log {

  @Override
  public void log(String info) {
    System.out.println("Log4j: " + info);
  }
}
