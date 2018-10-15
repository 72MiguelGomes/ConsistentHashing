package com.hashing.model;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.TreeMap;

public class Node {

  private String ip;

  private int hash;

  private TreeMap<Integer, Request> data = new TreeMap<>();

  public Node(String ip) {
    this.ip = ip;
    this.hash = Objects.hash(ip);
  }

  public void addRequest(Request request) {
    data.put(request.getHash(), request);
  }

  public int getHash() {
    return hash;
  }

  @Override
  public String toString() {

    StringBuilder strb = new StringBuilder(MessageFormat.format("\n\n#### Node {0} ####\n", ip));

    strb.append("\nip = " + ip);
    strb.append("\nhash = " + hash);

    data.values()
        .stream()
        .map(Request::toString)
        .forEach(strb::append);

    return strb.toString();
  }
}
