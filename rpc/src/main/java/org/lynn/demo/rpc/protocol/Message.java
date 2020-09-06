package org.lynn.demo.rpc.protocol;

import lombok.Data;

@Data
public class Message<T> {

  private Header header;

  private T content;

  public Message(Header header, T content) {
    this.header = header;
    this.content = content;
  }
}
