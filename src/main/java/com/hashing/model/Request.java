package com.hashing.model;

import java.util.Objects;

public class Request {

  private final int hash;

  private final String key;

  private final String content;

  public Request(String key, String content) {
    this.key = key;
    this.content = content;
    this.hash = Objects.hash(key);
  }

  public int getHash() {
    return this.hash;
  }

  public String getContent() {
    return this.content;
  }

  public String getKey() {
    return key;
  }

  @Override
  public String toString() {
    StringBuilder strb = new StringBuilder("\n\nRequest");

    strb.append("\nhash = " + hash);
    strb.append("\nkey = " + key);

    return strb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Request request = (Request) o;
    return hash == request.hash &&
        Objects.equals(key, request.key) &&
        Objects.equals(content, request.content);
  }
}
