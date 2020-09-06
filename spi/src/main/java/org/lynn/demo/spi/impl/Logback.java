package org.lynn.demo.spi.impl;

import org.lynn.demo.spi.Log;

public class Logback implements Log {

  @Override
  public void log(String info) {
    System.out.println("Logback: " + info);
  }
}
