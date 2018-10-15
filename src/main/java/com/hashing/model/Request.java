package com.hashing.model;

import java.util.Objects;

public class Request {

  private int hash;

  private String content;

  public Request(String content) {
    this.content = content;
    this.hash = Objects.hash(content);
  }

  public int getHash() {
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder strb = new StringBuilder("\n\nRequest");

    strb.append("\nhash = " + hash);
    strb.append("\ncontent = " + content);

    return strb.toString();
  }
}
