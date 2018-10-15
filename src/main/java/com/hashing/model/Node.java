package com.hashing.model;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Node {

  private String ip;

  private int hash;

  private TreeMap<Integer, Request> data = new TreeMap<>();

  public Node(String ip) {
    this.ip = ip;
    this.hash = Objects.hash(ip);
  }

  public Set<Request> getRequestsToMigrate(int hash) {
    return data.navigableKeySet()
        .headSet(hash, true)
        .stream()
        .map(data::get)
        .collect(Collectors.toSet());
  }

  public void removeMigratedItems(int hash) {
    new HashSet<>(data.navigableKeySet()
        .headSet(hash, true))
        .forEach(data::remove);
  }

  public void addRequest(Request request) {
    data.put(request.getHash(), request);
  }

  public int getHash() {
    return hash;
  }

  public Request getRequest(int hash) {
    return this.data.get(hash);
  }

  @Override
  public String toString() {

    StringBuilder strb = new StringBuilder(MessageFormat.format("\n\n#### Node {0} ####", ip));

    strb.append("\nip = " + ip);
    strb.append("\nhash = " + hash);

    data.values()
        .stream()
        .map(Request::toString)
        .forEach(strb::append);

    return strb.toString();
  }
}
